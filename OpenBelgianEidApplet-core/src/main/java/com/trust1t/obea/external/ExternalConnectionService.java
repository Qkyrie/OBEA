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
package com.trust1t.obea.external;

import org.bushe.swing.event.EventBus;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trust1t.obea.async.ExternalAsyncInputManager;
import com.trust1t.obea.async.ExternalAsyncOutputManager;
import com.trust1t.obea.events.AddressFetchedEvent;
import com.trust1t.obea.events.CardDetectedEvent;
import com.trust1t.obea.events.CardRemovedEvent;
import com.trust1t.obea.events.CertificateFetchedEvent;
import com.trust1t.obea.events.IAppletEvent;
import com.trust1t.obea.events.IdentityFetchedEvent;
import com.trust1t.obea.events.PhotoFetchedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class ExternalConnectionService.
 */
public abstract class ExternalConnectionService {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(ExternalConnectionService.class);
	
	
	/**
	 * Instantiates a new external connection service.
	 *
	 * @param eventBus the event bus
	 */
	public ExternalConnectionService()
	{
		AnnotationProcessor.process(this);
	}
	
	/**
	 * Gets the external input manager.
	 *
	 * @return the external input manager
	 */
	public abstract ExternalInputManager getExternalInputManager();
	
	/**
	 * Gets the external output manager.
	 *
	 * @return the external output manager
	 */
	public abstract ExternalOutputManager getExternalOutputManager();
	
	/**
	 * Gets the external Asynchronous input manager;.
	 *
	 * @return the external async input manager
	 */
	public abstract ExternalAsyncInputManager getExternalAsyncInputManager();
	
	/**
	 * gets the external async output Manager.
	 *
	 * @return the external async output manager
	 */
	public abstract ExternalAsyncOutputManager getExternalAsyncOutputManager();
	
	/**
	 * _on applet event.
	 *
	 * @param appletEvent the applet event
	 */
	@EventSubscriber(eventClass=IAppletEvent.class)
	public void _onAppletEvent(IAppletEvent appletEvent)
	{
		logger.debug("External Service received appletevent from eventbus");
		this.getExternalOutputManager().onAppletEvent(appletEvent);
	}
	
	/**
	 * _on card detected, triggered from the eventbus.
	 *
	 * @param cardDetectedEvent the card detected event
	 */
	public void _onCardDetected(CardDetectedEvent cardDetectedEvent)
	{
		logger.debug("External Service received onCardDetected from eventbus");
		this.getExternalOutputManager().onCardEvent(cardDetectedEvent);
	}
	
	/**
	 * _on card removed event, triggered from the eventbus.
	 *
	 * @param cardRemovedEvent the card removed event
	 */
	public void _onCardRemoved(CardRemovedEvent cardRemovedEvent)
	{	
		logger.debug("External Service received onCardRemoved from eventbus");
		this.getExternalOutputManager().onCardEvent(cardRemovedEvent);
	}
	
	/**
	 * _on identity callback.
	 *
	 * @param identityFetchedEvent the identity fetched event
	 */
	@EventSubscriber(eventClass=IdentityFetchedEvent.class)
	public void _onIdentityCallback(IdentityFetchedEvent identityFetchedEvent)
	{
		logger.debug("External Service received onIdentity Callback from eventbus");
		this.getExternalAsyncOutputManager().onGetIdentityAsyncCallback(identityFetchedEvent.getIdentity(), identityFetchedEvent.getCallback());
	}
	
	/**
	 * _on photo callback.
	 *
	 * @param photoFetchedEvent the photo fetched event
	 */
	@EventSubscriber(eventClass=PhotoFetchedEvent.class)
	public void _onPhotoCallback(PhotoFetchedEvent photoFetchedEvent)
	{
		logger.debug("External Service received onPhoto Callback from eventBus");
		this.getExternalAsyncOutputManager().onGetPhotoAsyncCallback(photoFetchedEvent.getPhoto(), photoFetchedEvent.getCallback());
	}
	
	/**
	 * _on address callback.
	 *
	 * @param addressFetchedEvent the address fetched event
	 */
	@EventSubscriber(eventClass=AddressFetchedEvent.class)
	public void _onAddressCallback(AddressFetchedEvent addressFetchedEvent)
	{
		logger.debug("External Service received onAddress callback from eventbus");
		this.getExternalAsyncOutputManager().onGetAddressAsyncCallback(addressFetchedEvent.getAddress(), addressFetchedEvent.getCallback());
	}
	
	/**
	 * _on certificate callback.
	 *
	 * @param certificateFetchedEvent the certificate fetched event
	 */
	@EventSubscriber(eventClass=CertificateFetchedEvent.class)
	public void _onCertificateCallback(CertificateFetchedEvent certificateFetchedEvent)
	{
		logger.debug("External service received oncertificate callback from eventbus");
		this.getExternalAsyncOutputManager().onGetCertificateCallback(certificateFetchedEvent.getExternalCertificate(), certificateFetchedEvent.getCallback());
	}
}
