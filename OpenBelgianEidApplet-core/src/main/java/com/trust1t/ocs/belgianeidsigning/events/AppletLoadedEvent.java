/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.events;

/**
 * The event thrown when an applet is loaded
 */
public class AppletLoadedEvent implements IAppletEvent{

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.events.IAppletEvent#getIdentifier()
	 */
	public String getIdentifier() {
		return "_onAppletLoaded";
	}
	
}
