/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.events;

/**
 * The Interface ICardEvent.
 * 
 * All CardEvents sent to the the frontend need to implement this interface to enforce an identifier
 */
public interface ICardEvent {

	/**
	 * Gets the identifier, which is unique per EventType
	 *
	 * @return the identifier
	 */
	String getIdentifier();
	
}
