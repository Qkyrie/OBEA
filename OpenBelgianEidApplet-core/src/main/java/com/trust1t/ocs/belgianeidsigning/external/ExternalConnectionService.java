/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.trust1t.ocs.belgianeidsigning.events.AddressFetchedEvent;
import com.trust1t.ocs.belgianeidsigning.events.CardDetectedEvent;
import com.trust1t.ocs.belgianeidsigning.events.CardRemovedEvent;
import com.trust1t.ocs.belgianeidsigning.events.CertificateFetchedEvent;
import com.trust1t.ocs.belgianeidsigning.events.IAppletEvent;
import com.trust1t.ocs.belgianeidsigning.events.IdentityFetchedEvent;
import com.trust1t.ocs.belgianeidsigning.events.PhotoFetchedEvent;
import com.trust1t.ocs.belgianeidsigning.external.async.ExternalAsyncInputManager;
import com.trust1t.ocs.belgianeidsigning.external.async.ExternalAsyncOutputManager;

/**
 * The Class ExternalConnectionService.
 */
public abstract class ExternalConnectionService {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(ExternalConnectionService.class);
	
	/** The event bus. */
	private EventBus eventBus;
	
	/**
	 * Instantiates a new external connection service.
	 *
	 * @param eventBus the event bus
	 */
	public ExternalConnectionService(EventBus eventBus)
	{
		this.eventBus = eventBus;
		addAsListener();
	}
	
	/**
	 * Adds the as listener.
	 */
	private void addAsListener()
	{
		eventBus.register(this);
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
	 * Gets the external Asynchronous input manager;
	 * @return
	 */
	public abstract ExternalAsyncInputManager getExternalAsyncInputManager();
	
	/**
	 * gets the external async output Manager
	 * @return
	 */
	public abstract ExternalAsyncOutputManager getExternalAsyncOutputManager();
	
	/**
	 * _on applet event.
	 *
	 * @param appletEvent the applet event
	 */
	@Subscribe
	public void _onAppletEvent(IAppletEvent appletEvent)
	{
		logger.debug("External Service received appletevent from eventbus");
		this.getExternalOutputManager().onAppletEvent(appletEvent);
	}
	
	/**
	 * _on card detected, triggered from the eventbus
	 *
	 * @param cardDetectedEvent the card detected event
	 */
	@Subscribe
	public void _onCardDetected(CardDetectedEvent cardDetectedEvent)
	{
		logger.debug("External Service received onCardDetected from eventbus");
		this.getExternalOutputManager().onCardEvent(cardDetectedEvent);
	}
	
	/**
	 * _on card removed event, triggered from the eventbus
	 *
	 * @param cardRemovedEvent the card removed event
	 */
	@Subscribe
	public void _onCardRemoved(CardRemovedEvent cardRemovedEvent)
	{	
		logger.debug("External Service received onCardRemoved from eventbus");
		this.getExternalOutputManager().onCardEvent(cardRemovedEvent);
	}
	
	@Subscribe
	public void _onIdentityCallback(IdentityFetchedEvent identityFetchedEvent)
	{
		logger.debug("External Service received onIdentity Callback from eventbus");
		this.getExternalAsyncOutputManager().onGetIdentityAsyncCallback(identityFetchedEvent.getIdentity(), identityFetchedEvent.getCallback());
	}
	
	@Subscribe
	public void _onPhotoCallback(PhotoFetchedEvent photoFetchedEvent)
	{
		logger.debug("External Service received onPhoto Callback from eventBus");
		this.getExternalAsyncOutputManager().onGetPhotoAsyncCallback(photoFetchedEvent.getPhoto(), photoFetchedEvent.getCallback());
	}
	
	@Subscribe
	public void _onAddressCallback(AddressFetchedEvent addressFetchedEvent)
	{
		logger.debug("External Service received onAddress callback from eventbus");
		this.getExternalAsyncOutputManager().onGetAddressAsyncCallback(addressFetchedEvent.getAddress(), addressFetchedEvent.getCallback());
	}
	
	@Subscribe
	public void _onCertificateCallback(CertificateFetchedEvent certificateFetchedEvent)
	{
		logger.debug("External service received oncertificate callback from eventbus");
		this.getExternalAsyncOutputManager().onGetCertificateCallback(certificateFetchedEvent.getExternalCertificate(), certificateFetchedEvent.getCallback());
	}
}
