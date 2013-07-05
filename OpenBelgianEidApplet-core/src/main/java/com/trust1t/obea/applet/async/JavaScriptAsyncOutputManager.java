/*
 *
 * This file is part of the Trust1T (R) project.
 * Copyright (c) 2013 Trust1T BVBA
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
package com.trust1t.obea.applet.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import netscape.javascript.JSObject;

import com.google.common.eventbus.EventBus;
import com.trust1t.obea.async.ExternalAsyncOutputManager;
import com.trust1t.obea.dto.ExternalAddress;
import com.trust1t.obea.dto.ExternalCertificate;
import com.trust1t.obea.dto.ExternalIdentity;
import com.trust1t.obea.dto.ExternalPhoto;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaScriptAsyncOutputManager.
 */
public class JavaScriptAsyncOutputManager implements ExternalAsyncOutputManager{

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(JavaScriptAsyncOutputManager.class);
	
	/** The event bus. */
	private final EventBus eventBus;
	
	/** The js object. */
	private final JSObject jsObject;
	
	/**
	 * Instantiates a new java script async output manager.
	 *
	 * @param eventBus the event bus
	 * @param jbObject the jb object
	 */
	public JavaScriptAsyncOutputManager(EventBus eventBus, JSObject jbObject)
	{
		this.eventBus = eventBus;
		this.jsObject = jbObject;
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncOutputManager#onGetIdentityAsyncCallback(com.trust1t.obea.dto.ExternalIdentity, java.lang.String)
	 */
	public void onGetIdentityAsyncCallback(ExternalIdentity identity, String callback) {
		try 
		{
			jsObject.call(callback, new Object[]{identity});
		} catch (Exception e) {
			logger.error("error during getIdentityasync Callback to javascript");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncOutputManager#onGetPhotoAsyncCallback(com.trust1t.obea.dto.ExternalPhoto, java.lang.String)
	 */
	public void onGetPhotoAsyncCallback(ExternalPhoto photo, String callback) {
		try {
			jsObject.call(callback, new Object[]{photo});
		} catch (Exception e) {
			logger.error("error during getPhotoAsync Callback to javascript");
		}
		
	}


	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncOutputManager#onGetAddressAsyncCallback(com.trust1t.obea.dto.ExternalAddress, java.lang.String)
	 */
	public void onGetAddressAsyncCallback(ExternalAddress address, String callback) {
		try 
		{
			jsObject.call(callback, new Object[]{address});
		} catch (Exception e) {
			logger.error("error during getaddress Callback to javascript");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncOutputManager#onGetCertificateCallback(com.trust1t.obea.dto.ExternalCertificate, java.lang.String)
	 */
	public void onGetCertificateCallback(ExternalCertificate certificate, String callback)
	{
		try {
			jsObject.call(callback, new Object[]{certificate});
		} catch (Exception e) {
			logger.error("error during the getCertificate callback to javascript for callback: {}", callback);
		}
	}

	
}
