/*
 *
 * This file is part of the Trust1T (R) project.
 * Copyright (c) 2013 Trust1T
 * Authors: Michallis Pashidis, Kwinten Pisman, Quinten De Swaef
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License version 3
 * as published by the Free Software Foundation with the addition of the
 * following permission added to Section 15 as permitted in Section 7(a):
 * FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY Trust1T,
 * Trust1T DISCLAIMS THE WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA, 02110-1301 USA.
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License.
 *
 * You can be released from the requirements of the license by purchasing
 * a commercial license. Buying such a license is mandatory as soon as you
 * develop commercial activities involving the Trust1T software without
 * disclosing the source code of your own applications.
 * These activities include: offering paid services to customers as an ASP,
 * Signing PDFs on the fly in a web application, shipping OCS with a closed
 * source product...
 */
package com.trust1t.obea.applet;
import java.applet.Applet;

import netscape.javascript.JSObject;

import org.bushe.swing.event.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.plugin.javascript.navig4.Window;

import com.trust1t.obea.async.ExternalAsyncInputManager;
import com.trust1t.obea.events.AppletLoadedEvent;
import com.trust1t.obea.external.ExternalInputManager;
import com.trust1t.obea.scanning.OBEACardScanner;
import com.trust1t.obea.service.BeidCardController;



// TODO: Auto-generated Javadoc
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
	
	/** The external async input delegate. */
	private ExternalAsyncInputManager externalAsyncInputDelegate;
	
	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	@Override
	public void init()
	{
		logger.debug("starting up");
		logger.debug("creation of the eventbus");

		
		OBEACardScanner cardScanner = new OBEACardScanner();
		
		JSObject jsObject = initiateLiveConnect();
		
		BeidCardController controller = new BeidCardController(jsObject);
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
	
	/**
	 * Application started.
	 */
	private void applicationStarted()
	{
		logger.debug("going to post that applet started");
		EventBus.publish(new AppletLoadedEvent());
	}
	

	/**
	 * returns the JavaScript Delegate to perform javascript tasks on.
	 *
	 * @return JavaScriptInputManager
	 */
	public ExternalInputManager getExternalInputDelegate() {
		return externalInputDelegate;
	}

	
	/**
	 * Gets the external async input delegate.
	 *
	 * @return the external async input delegate
	 */
	public ExternalAsyncInputManager getExternalAsyncInputDelegate() {
		return externalAsyncInputDelegate;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		OBEA a = new OBEA();
		a.init();
	}
	
}
