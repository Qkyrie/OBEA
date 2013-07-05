/*
 *
 * This file is part of the Trust1T (R) project.
 * Copyright (c) 2013 Trust1T BVBA
 * Authors: Michallis Pashidis, Kwinten Pisman, Quinten De Swaef
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License version 3
 * as published by the Free Software Foundation with the addition of the
 * following permission added to Section 15 as permitted in Section 7(a):
 * FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY Trust1T,
 * Trust1T DISCLAIMS THE WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA, 02110-1301 USA.
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License.
 *
 * You can be released from the requirements of the license by purchasing
 * a commercial license. Buying such a license is mandatory as soon as you
 * develop commercial activities involving the Trust1T software without
 * disclosing the source code of your own applications.
 * These activities include: offering paid services to customers as an ASP,
 * Signing PDFs on the fly in a web application, shipping OCS with a closed
 * source product...
 */
package com.trust1t.obea.service;

import netscape.javascript.JSObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.BeIDCard;
import be.fedict.commons.eid.client.spi.BeIDCardUI;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.trust1t.obea.applet.JavaScriptConnectionFactory;
import com.trust1t.obea.applet.ui.UIBridge;
import com.trust1t.obea.events.CardDetectedEvent;
import com.trust1t.obea.events.CardRemovedEvent;
import com.trust1t.obea.external.ExternalConnectionService;

/**
 * <b>BeidCardContoller</b>
 * 
 * This class acts as a main Controller for the Belgian EID Card. 
 * This is the accesspoint for the active Belgian Eid Card inserted in the reader.
 * 
 * This is necessary because commonseid doesn't save the active card, instead it returns the BEIDcard
 * once it is detected. By the use of this manager, which serves as a <i>cache</i> we can send asynchronous calls
 * to the card.
 * 
 * All service classes will need to pass the calls to this class.
 */
public class BeidCardController {
	
	/** The javascript controller. */
	private ExternalConnectionService externalConnectionService;
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(BeidCardController.class);
	
	/** The cached card. */
	private BeIDCard cachedCard;
	
	/** The eventbus. */
	private EventBus eventbus;
	
	/** The ui bridge. */
	private UIBridge uiBridge;
	
	/**
	 * Instantiates a new beid card manager.
	 *
	 * @param eventBus the event bus
	 * @param jsObject the js object
	 */
	public BeidCardController(EventBus eventBus, JSObject jsObject)
	{	
		logger.debug("init of the beidcardcontroller");
		this.eventbus = eventBus;
		this.externalConnectionService = initiateExternalConnectionService(jsObject);
		addAsListener();
	}
	
	/**
	 * Initiate external connection service.
	 *
	 * @param jsObject the js object
	 * @return the external connection service
	 */
	private ExternalConnectionService initiateExternalConnectionService(JSObject jsObject)
	{
		logger.debug("initializing the external connection right now");
		
		if(jsObject == null)
		{
			logger.error("Applet not deployed in a decent browser environment, shutting down!");
			
			//dirty, should take this somewhere else after refactor
			//FIXME
			System.exit(0);
			return null;
		}
		else
		{
			logger.debug("creating the applet version (with liveconnect)");
			return	JavaScriptConnectionFactory.createExternalConnection(this.getEventbus(), this, jsObject);
		}
	}
	
	/**
	 * Adds this as listener.
	 */
	private void addAsListener()
	{
		eventbus.register(this);
	}
	
	/**
	 * On card detected.
	 *
	 * @param cardDetectedEvent the card detected event
	 */
	@Subscribe
	public void onCardDetected(CardDetectedEvent cardDetectedEvent)
	{
		this.cachedCard = cardDetectedEvent.getBeidCard();
		this.externalConnectionService._onCardDetected(cardDetectedEvent);
	}
	
	/**
	 * On card removed.
	 *
	 * @param cardRemovedEvent the card removed event
	 */
	@Subscribe
	public void onCardRemoved(CardRemovedEvent cardRemovedEvent)
	{
		this.cachedCard = null;
		this.externalConnectionService._onCardRemoved(cardRemovedEvent);
	}
	
	
	/**
	 * Checks for cached card.
	 *
	 * @return true, if successful
	 */
	public boolean hasCachedCard()
	{
		return (cachedCard != null);
	}


	/**
	 * Gets the eventbus.
	 *
	 * @return the eventbus
	 */
	public EventBus getEventbus() {
		return eventbus;
	}


	/**
	 * Sets the eventbus.
	 *
	 * @param eventbus the new eventbus
	 */
	public void setEventbus(EventBus eventbus) {
		this.eventbus = eventbus;
	}

	/**
	 * Gets the external connection service.
	 *
	 * @return the external connection service
	 */
	public ExternalConnectionService getExternalConnectionService() {
		return externalConnectionService;
	}

	/**
	 * Sets the external connection service.
	 *
	 * @param externalConnectionService the new external connection service
	 */
	public void setExternalConnectionService(
			ExternalConnectionService externalConnectionService) {
		this.externalConnectionService = externalConnectionService;
	}

	/**
	 * Gets the cached card.
	 *
	 * @return the cached card
	 */
	public BeIDCard getCachedCard() {
		return cachedCard;
	}

	/**
	 * Gets the ui bridge.
	 *
	 * @return the ui bridge
	 */
	public UIBridge getUiBridge() {
		return uiBridge;
	}

	/**
	 * Sets the ui bridge.
	 *
	 * @param uiBridge the new ui bridge
	 */
	public void setUiBridge(UIBridge uiBridge) {
		if(this.hasCachedCard() && uiBridge instanceof BeIDCardUI)
		{
			logger.debug("uiBridge is an instance of beidCardUI (duh)..");
			this.getCachedCard().setUI((BeIDCardUI)uiBridge);
		}
		this.uiBridge = uiBridge;
	}


	
	
}
