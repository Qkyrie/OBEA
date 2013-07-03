/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.applet.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <b>PinCache</b> Class. 
 * 
 * This cache provides basic functionality to <i>temporarily</i> save the pin, provided by the frontend.
 */
public class PinCache {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(PinCache.class);

	/** The pin cache. */
	private char[] pin;
	
	/**
	 * Instantiates a new pin cache.
	 *
	 * @param pinCache the pin cache
	 */
	public PinCache(String pinCache)
	{
		this.pin = pinCache.toCharArray();
	}

	/**
	 * Gets the pin cache.
	 *
	 * @return the pin cache
	 */
	public char[] getPin() {
		logger.debug("getting the cached pin");
		return pin;
	}
	
}
