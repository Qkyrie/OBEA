/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.applet.ui;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.PINPurpose;
import be.fedict.commons.eid.client.spi.BeIDCardUIAdapter;


/**
 * The Class JavaScriptUIBridge, which overrides UI calls to the standard implementation of the UI of commons eid.
 */
public class JavaScriptUIBridge extends BeIDCardUIAdapter implements UIBridge{

		/** The logger. */
		private Logger logger = LoggerFactory.getLogger(JavaScriptUIBridge.class);
		
		/** The pin cache. */
		private PinCache pinCache;
	

		/* (non-Javadoc)
		 * @see be.fedict.eid.commons.dialogs.DefaultBeIDCardUI#obtainPIN(int, be.fedict.commons.eid.client.PINPurpose)
		 */
		@Override
		public char[] obtainPIN(final int retriesLeft, final PINPurpose reason)
		{
			logger.debug("amount of retries left: {}", retriesLeft);
			
			if(getCachedPin() == null || (retriesLeft < 3 && retriesLeft != -1))
			{
				logger.error("no pin was cached or retriesleft was less than 3: {}", retriesLeft);
				throw new IllegalArgumentException("no pin defined or retriestLeft was less than 3: " + retriesLeft);
			}
			else
			{
				logger.debug("getting pin from javascript call");
				return getCachedPin();
			}
		}

		/**
		 * Gets the cached pin.
		 *
		 * @return the cached pin
		 */
		public char[] getCachedPin() {
			return pinCache.getPin();
		}
		
		public boolean hasPinProvided(){
			//check if pincache is set
			return (pinCache != null);
		}


		/**
		 * Gets the pin cache.
		 *
		 * @return the pin cache
		 */
		public PinCache getPinCache() {
			return pinCache;
		}

		/**
		 * Sets the pin cache.
		 *
		 * @param pinCache the new pin cache
		 */
		public void setPinCache(PinCache pinCache) {
			this.pinCache = pinCache;
		}
		
		

}
