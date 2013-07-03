/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.events;

/**
 * The Class IllegalRequestEvent.
 */
public class IllegalRequestEvent implements ExceptionEvent{

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.events.ExceptionEvent#getErrorCode()
	 */
	public String getErrorCode() {
		return "100";
	}

	
}
