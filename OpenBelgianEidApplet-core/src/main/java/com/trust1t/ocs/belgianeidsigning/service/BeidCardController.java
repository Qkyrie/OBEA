/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.service;

import netscape.javascript.JSObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.BeIDCard;
import be.fedict.commons.eid.client.spi.BeIDCardUI;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.trust1t.ocs.belgianeidsigning.applet.JavaScriptConnectionFactory;
import com.trust1t.ocs.belgianeidsigning.applet.ui.UIBridge;
import com.trust1t.ocs.belgianeidsigning.events.CardDetectedEvent;
import com.trust1t.ocs.belgianeidsigning.events.CardRemovedEvent;
import com.trust1t.ocs.belgianeidsigning.external.ExternalConnectionService;


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

	public BeIDCard getCachedCard() {
		return cachedCard;
	}

	public UIBridge getUiBridge() {
		return uiBridge;
	}

	public void setUiBridge(UIBridge uiBridge) {
		if(this.hasCachedCard() && uiBridge instanceof BeIDCardUI)
		{
			logger.debug("uiBridge is an instance of beidCardUI (duh)..");
			this.getCachedCard().setUI((BeIDCardUI)uiBridge);
		}
		this.uiBridge = uiBridge;
	}


	
	
}
