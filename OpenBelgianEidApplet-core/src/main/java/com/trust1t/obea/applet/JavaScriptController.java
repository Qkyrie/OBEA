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

import netscape.javascript.JSObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trust1t.obea.applet.async.JavaScriptAsyncInputManager;
import com.trust1t.obea.applet.async.JavaScriptAsyncOutputManager;
import com.trust1t.obea.async.ExternalAsyncInputManager;
import com.trust1t.obea.async.ExternalAsyncOutputManager;
import com.trust1t.obea.external.ExternalConnectionService;
import com.trust1t.obea.external.ExternalInputManager;
import com.trust1t.obea.external.ExternalOutputManager;
import com.trust1t.obea.service.BeidCardController;

// TODO: Auto-generated Javadoc
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
	
	/** The external async output manager. */
	private ExternalAsyncOutputManager externalAsyncOutputManager;
	
	/** The external async input manager. */
	private ExternalAsyncInputManager externalAsyncInputManager;
	
	/**
	 * Instantiates a new java script controller.
	 *
	 * @param eventBus the event bus
	 * @param appletController the applet controller
	 * @param jsObject the js object
	 */
	public JavaScriptController(BeidCardController appletController, JSObject jsObject)
	{
		super();
		logger.debug("init of the JavaScriptController");
		
		this.externalOutputManager = new JavaScriptOutputManager(jsObject);
		this.externalInputManager = new JavaScriptInputManager(appletController);
		this.externalAsyncInputManager = new JavaScriptAsyncInputManager(this);
		this.externalAsyncOutputManager = new JavaScriptAsyncOutputManager(jsObject);
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


	/* (non-Javadoc)
	 * @see com.trust1t.obea.external.ExternalConnectionService#getExternalAsyncOutputManager()
	 */
	public ExternalAsyncOutputManager getExternalAsyncOutputManager() {
		return externalAsyncOutputManager;
	}


	/* (non-Javadoc)
	 * @see com.trust1t.obea.external.ExternalConnectionService#getExternalAsyncInputManager()
	 */
	public ExternalAsyncInputManager getExternalAsyncInputManager() {
		return externalAsyncInputManager;
	}


	
	
}
