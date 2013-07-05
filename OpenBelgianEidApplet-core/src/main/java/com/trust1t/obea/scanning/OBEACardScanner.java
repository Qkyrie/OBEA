/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.BeIDCardManager;
import be.fedict.commons.eid.client.CardAndTerminalManager;

import com.google.common.eventbus.EventBus;
import com.trust1t.obea.listening.MKQCardListener;

/**
 * The main class that makes sure the applet keeps running. This scanner is mainly a wrapper around
 * the terminalmanager and beidcardmanager provided by commons eid.
 */
public class MKQCardScanner {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(MKQCardScanner.class);
	
	/** The is running. */
	private boolean isRunning = false;
	
	/** The event bus. */
	private EventBus eventBus;
	
	/**
	 * Instantiates a new mKQ card scanner.
	 *
	 * @param eventBus the event bus
	 */
	public MKQCardScanner(EventBus eventBus)
	{
		this.eventBus = eventBus;
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
			manager.addBeIDCardEventListener(new MKQCardListener(eventBus));
			
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
