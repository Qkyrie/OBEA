/*
 *
 * This file is part of the Trust1T (R) project.
 * Copyright (c) 2013 Trust1T
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
package com.trust1t.obea.scanning;

import org.bushe.swing.event.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.BeIDCardManager;
import be.fedict.commons.eid.client.CardAndTerminalManager;

import com.trust1t.obea.listening.OBEACardListener;

/**
 * The main class that makes sure the applet keeps running. This scanner is mainly a wrapper around
 * the terminalmanager and beidcardmanager provided by commons eid.
 */
public class OBEACardScanner {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(OBEACardScanner.class);
	
	/** The is running. */
	private boolean isRunning = false;
	

	/**
	 * Instantiates a new mKQ card scanner.
	 *
	 * @param eventBus the event bus
	 */
	public OBEACardScanner()
	{
		logger.trace("first init of the MKQCardScanner");
	}
	
	/**
	 * Inits the.
	 */
	public void init()
	{		
		if(!isRunning)
		{
			CardAndTerminalManager terminalManager = new CardAndTerminalManager();
			BeIDCardManager manager = new BeIDCardManager(terminalManager);
			manager.addBeIDCardEventListener(new OBEACardListener());
			
			logger.trace("starting terminalManager");
			terminalManager.start();
	
			isRunning = true;
		
		}
		else
		{
			logger.trace("main thread was already running");
		}
		
		letMeSleep();
	}
	
	/**
	 * Let me sleep.
	 */
	private void letMeSleep()
	{
		try {
			logger.trace("sending main thread to sleep");
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			logger.error("MKQCardscanner was unable to wait");
		}
		finally
		{
			logger.trace("done sleeping, reinit");
			this.init();
		}
	}

	/**
	 * Checks if is running.
	 *
	 * @return true, if is running
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * Sets the running.
	 *
	 * @param isRunning the new running
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	
	
}
