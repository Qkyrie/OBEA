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
package com.trust1t.obea.listening;
import javax.smartcardio.CardTerminal;

import org.bushe.swing.event.EventBus;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.BeIDCard;
import be.fedict.commons.eid.client.event.BeIDCardEventsListener;

import com.trust1t.obea.events.CardDetectedEvent;
import com.trust1t.obea.events.CardRemovedEvent;


/**
 * The listener interface for receiving OBEA events.
 * The class that is interested in processing a MKQCard
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addMKQCardListener<code> method. When
 * the MKQCard event occurs, that object's appropriate
 * method is invoked.
 *
 * 
 */
public class OBEACardListener implements BeIDCardEventsListener{

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(OBEACardListener.class);
	
	
	/**
	 * Instantiates a new mKQ card listener and adds itself to the eventbus.
	 *
	 * @param eventBus the event bus
	 */
	public OBEACardListener()
	{
		AnnotationProcessor.process(this);
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
		EventBus.publish(new CardDetectedEvent(beidCard));
	}

	/* (non-Javadoc)
	 * @see be.fedict.commons.eid.client.event.BeIDCardEventsListener#eIDCardRemoved(javax.smartcardio.CardTerminal, be.fedict.commons.eid.client.BeIDCard)
	 */
	public void eIDCardRemoved(CardTerminal terminal, BeIDCard beidCard) {
		logger.debug("listener detected card remove, posting it to the eventbus.");
		EventBus.publish(new CardRemovedEvent(beidCard));
	}

}
