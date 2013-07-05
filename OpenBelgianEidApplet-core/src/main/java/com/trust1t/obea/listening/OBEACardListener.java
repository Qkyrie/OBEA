/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.listening;
import javax.smartcardio.CardTerminal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.BeIDCard;
import be.fedict.commons.eid.client.event.BeIDCardEventsListener;

import com.google.common.eventbus.EventBus;
import com.trust1t.obea.events.CardDetectedEvent;
import com.trust1t.obea.events.CardRemovedEvent;


/**
 * The listener interface for receiving MKQCard events.
 * The class that is interested in processing a MKQCard
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addMKQCardListener<code> method. When
 * the MKQCard event occurs, that object's appropriate
 * method is invoked.
 *
 * @see MKQCardEvent
 */
public class MKQCardListener implements BeIDCardEventsListener{

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(MKQCardListener.class);
	
	/** 
	 * The event bus. All activities containing cards found and removed events will be posted from this class.
	 * All listeners will be triggered by this class through the use of this eventbus */
	private EventBus eventBus;
	
	/**
	 * Instantiates a new mKQ card listener and adds itself to the eventbus
	 *
	 * @param eventBus the event bus
	 */
	public MKQCardListener(EventBus eventBus)
	{
		this.eventBus = eventBus;
		addAsListener();
	}
	
	/**
	 * Adds the as listener.
	 */
	private void addAsListener()
	{
		this.eventBus.register(this);
	}
	
	/* (non-Javadoc)
	 * @see be.fedict.commons.eid.client.event.BeIDCardEventsListener#eIDCardEventsInitialized()
	 */
	public void eIDCardEventsInitialized() {
	}

	/* (non-Javadoc)
	 * @see be.fedict.commons.eid.client.event.BeIDCardEventsListener#eIDCardInserted(javax.smartcardio.CardTerminal, be.fedict.commons.eid.client.BeIDCard)
	 */
	public void eIDCardInserted(CardTerminal terminal, BeIDCard beidCard) {
		logger.debug("listener detected card insert, posting it to the eventbus.");
		eventBus.post(new CardDetectedEvent(beidCard));
	}

	/* (non-Javadoc)
	 * @see be.fedict.commons.eid.client.event.BeIDCardEventsListener#eIDCardRemoved(javax.smartcardio.CardTerminal, be.fedict.commons.eid.client.BeIDCard)
	 */
	public void eIDCardRemoved(CardTerminal terminal, BeIDCard beidCard) {
		logger.debug("listener detected card remove, posting it to the eventbus.");
		eventBus.post(new CardRemovedEvent(beidCard));
	}

}
