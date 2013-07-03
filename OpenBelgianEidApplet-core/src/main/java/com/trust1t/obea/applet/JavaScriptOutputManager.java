/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.applet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trust1t.obea.events.IAppletEvent;
import com.trust1t.obea.events.ICardEvent;
import com.trust1t.obea.external.ExternalOutputManager;

import netscape.javascript.JSObject;

/**
 * The JavaScriptOutputManager is responsible to delegate all events to the browser through LiveConnect.
 */
public class JavaScriptOutputManager implements ExternalOutputManager{

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(JavaScriptOutputManager.class);
	
	/** The js object. */
	private JSObject jsObject;
	
	/**
	 * Instantiates a new java script output manager.
	 *
	 * @param jsObject the js object
	 */
	public JavaScriptOutputManager(JSObject jsObject)
	{
		logger.debug("init of the JavascriptOutputManager");
		this.jsObject = jsObject;
	}
	
	
	public void onCardEvent(ICardEvent cardEvent)
	{
		try 
		{
			jsObject.call(cardEvent.getIdentifier(), new Object[]{});
		} catch (Exception e) {
			logger.error("Error during onCardEvent to JavaScript {}", e.getMessage());
		}
	}
	
	/**
	 * This method is delegated to the javascript method to call an applet event
	 *
	 * @param appletEvent the applet event
	 */
	public void onAppletEvent(IAppletEvent appletEvent)
	{
		try {
			jsObject.call(appletEvent.getIdentifier(), new Object[]{});
		} catch (Exception e) {
			logger.error("Error during onAppletEvent to JavaScript {}", e.getMessage());
		}
	}

	/**
	 * Gets the js object.
	 *
	 * @return the js object
	 */
	public JSObject getJsObject() {
		return jsObject;
	}

	/**
	 * Sets the js object.
	 *
	 * @param jsObject the new js object
	 */
	public void setJsObject(JSObject jsObject) {
		this.jsObject = jsObject;
	}
	
	
	
	
	
}
