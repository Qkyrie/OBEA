/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.applet.ui;

/**
 * An interface between the commons eid UI interface and the javascript/external interface
 */
public interface UIBridge {

	boolean hasPinProvided();
	void setPinCache(PinCache pinCache);
	
}
