/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.applet;

import netscape.javascript.JSObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.trust1t.obea.applet.async.JavaScriptAsyncInputManager;
import com.trust1t.obea.applet.async.JavaScriptAsyncOutputManager;
import com.trust1t.obea.async.ExternalAsyncInputManager;
import com.trust1t.obea.async.ExternalAsyncOutputManager;
import com.trust1t.obea.external.ExternalConnectionService;
import com.trust1t.obea.external.ExternalInputManager;
import com.trust1t.obea.external.ExternalOutputManager;
import com.trust1t.obea.service.BeidCardController;

/**
 * The controller for all JavaScript Communication.
 */
public class JavaScriptController extends ExternalConnectionService{
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(JavaScriptController.class);
	
	
	
	/** The javascript output manager. */
	private ExternalOutputManager externalOutputManager;
	
	/** The java script input manager. */
	private ExternalInputManager externalInputManager;
	
	private ExternalAsyncOutputManager externalAsyncOutputManager;
	
	private ExternalAsyncInputManager externalAsyncInputManager;
	
	/**
	 * Instantiates a new java script controller.
	 *
	 * @param eventBus the event bus
	 * @param appletController the applet controller
	 * @param jsObject the js object
	 */
	public JavaScriptController(EventBus eventBus, BeidCardController appletController, JSObject jsObject)
	{
		super(eventBus);
		logger.debug("init of the JavaScriptController");
		
		this.externalOutputManager = new JavaScriptOutputManager(jsObject);
		this.externalInputManager = new JavaScriptInputManager(appletController);
		this.externalAsyncInputManager = new JavaScriptAsyncInputManager(eventBus, this);
		this.externalAsyncOutputManager = new JavaScriptAsyncOutputManager(eventBus, jsObject);
	}
	

	/**
	 * Gets the javascript output manager.
	 *
	 * @return the javascript output manager
	 */
	public ExternalOutputManager getExternalOutputManager() {
		return externalOutputManager;
	}


	/**
	 * Gets the java script input manager.
	 *
	 * @return the java script input manager
	 */
	public ExternalInputManager getExternalInputManager() {
		return externalInputManager;
	}


	public ExternalAsyncOutputManager getExternalAsyncOutputManager() {
		return externalAsyncOutputManager;
	}


	public ExternalAsyncInputManager getExternalAsyncInputManager() {
		return externalAsyncInputManager;
	}


	
	
}
