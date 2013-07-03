/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.applet;
import java.applet.Applet;

import netscape.javascript.JSObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.plugin.javascript.navig4.Window;

import com.google.common.eventbus.EventBus;
import com.trust1t.obea.async.ExternalAsyncInputManager;
import com.trust1t.obea.events.AppletLoadedEvent;
import com.trust1t.obea.external.ExternalInputManager;
import com.trust1t.obea.scanning.MKQCardScanner;
import com.trust1t.obea.service.BeidCardController;



/**
 * The Class StartUp.
 */
public class OBEA extends Applet{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4253116074922391210L;
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(OBEA.class);
	
	/** The event bus. */
	private EventBus eventBus;
	
	/** The javascript delegate. */
	private ExternalInputManager externalInputDelegate;
	private ExternalAsyncInputManager externalAsyncInputDelegate;
	
	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	@Override
	public void init()
	{
		logger.debug("starting up");
		logger.debug("creation of the eventbus");
		eventBus = new EventBus();
		
		MKQCardScanner cardScanner = new MKQCardScanner(eventBus);
		
		JSObject jsObject = initiateLiveConnect();
		
		BeidCardController controller = new BeidCardController(eventBus, jsObject);
		this.externalInputDelegate = controller.getExternalConnectionService().getExternalInputManager();
		this.externalAsyncInputDelegate = controller.getExternalConnectionService().getExternalAsyncInputManager();
		applicationStarted();
		cardScanner.init();
		
	}
	
	/**
	 * Initiate live connect.
	 *
	 * @return the jS object
	 */
	private JSObject initiateLiveConnect()
	{
		JSObject jsObject = null;
		try 
		{
			logger.debug("creation of the javascript hook");
			jsObject = Window.getWindow(this);
		} 
		catch(NoClassDefFoundError ncdfe)
		{
			logger.error("noclassdef found for Window, we're not in a browser");
		}
		catch(Exception e)
		{
			logger.error("something went wrong trying to initiate the default javascript behaviour: {}", e.getMessage());
		}
		
		return jsObject;
	}
	
	private void applicationStarted()
	{
		logger.debug("going to post that applet started");
		eventBus.post(new AppletLoadedEvent());
	}
	

	/**
	 * returns the JavaScript Delegate to perform javascript tasks on
	 * @return JavaScriptInputManager
	 */
	public ExternalInputManager getExternalInputDelegate() {
		return externalInputDelegate;
	}

	
	public ExternalAsyncInputManager getExternalAsyncInputDelegate() {
		return externalAsyncInputDelegate;
	}

	public static void main(String[] args)
	{
		OBEA a = new OBEA();
		a.init();
	}
	
}
