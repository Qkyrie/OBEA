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
package com.trust1t.obea.applet.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bushe.swing.event.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trust1t.obea.applet.dto.JSSignedHash;
import com.trust1t.obea.async.ExternalAsyncInputManager;
import com.trust1t.obea.events.AddressFetchedEvent;
import com.trust1t.obea.events.CertificateFetchedEvent;
import com.trust1t.obea.events.HashSignedEvent;
import com.trust1t.obea.events.IdentityFetchedEvent;
import com.trust1t.obea.events.PhotoFetchedEvent;
import com.trust1t.obea.events.PinVerifiedEvent;
import com.trust1t.obea.external.ExternalConnectionService;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaScriptAsyncInputManager.
 */
public class JavaScriptAsyncInputManager implements ExternalAsyncInputManager{
	
	/** The executor service. */
	private ExecutorService executorService;
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(JavaScriptAsyncInputManager.class);
	
	/** The external connection service. */
	private final ExternalConnectionService externalConnectionService;

	
	/**
	 * Instantiates a new java script async input manager.
	 *
	 * @param externalConnectionService the external connection service
	 */
	public JavaScriptAsyncInputManager(ExternalConnectionService externalConnectionService)
	{
		this.externalConnectionService = externalConnectionService;
		//only create a threadpool of size 1, it should be a blockingqueue
		this.executorService = Executors.newSingleThreadExecutor();
	}
	

	/**
	 * Verify pin.
	 *
	 * @param callback the callback
	 */
	public void verifyPin(final String callback) {
	
		logger.debug("entering verifyPin asynchronous method");
		
		executorService.submit(new Runnable() {
			
			public void run() {
				logger.debug("running asynchronous pinverify");
				
				PinVerifiedEvent event = new PinVerifiedEvent(getExternalConnectionService().getExternalInputManager().verifyPin(), callback);
				EventBus.publish(event);
				logger.debug("done running asynchronous pinverification");
			}
		});
		
	}


	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#signRsa(java.lang.String, java.lang.String)
	 */
	public void signRsa(final String hash, final String callback)
	{
		logger.debug("entering signRsa asynchronous method");
		
		executorService.submit(new Runnable() {
			
			public void run() {
				logger.debug("running asynchronous signing");
				JSSignedHash signedHash = new JSSignedHash(hash, getExternalConnectionService().getExternalInputManager().signRsa(hash).getResult());
				HashSignedEvent event = new HashSignedEvent(signedHash, callback);
				EventBus.publish(event);
				logger.debug("done running asynchronous singing");
			}
		});
	}
		
	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#signRsa(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void signRsa(final String hash, final String digestAlgorithm, final String callback) {
		logger.debug("entering signRsa asynchronous method");
		
		executorService.submit(new Runnable() {
			
			public void run() {
				logger.debug("running asynchronous signing");
				JSSignedHash signedHash = new JSSignedHash(hash, getExternalConnectionService().getExternalInputManager().signRsa(hash, digestAlgorithm).getResult());
				HashSignedEvent event = new HashSignedEvent(signedHash, callback);
				EventBus.publish(event);
				logger.debug("done running asynchronous singing");
			}
		});
	}


	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#signAuth(java.lang.String, java.lang.String)
	 */
	public void signAuth(final String hash, final String callback) {
		logger.debug("entering signAuth asynchronous method");
		
		executorService.submit(new Runnable() {
			
			public void run() {
				logger.debug("running asynchronous signing auth");
				JSSignedHash signedHash = new JSSignedHash(hash, getExternalConnectionService().getExternalInputManager().signAuth(hash).getResult());
				HashSignedEvent event = new HashSignedEvent(signedHash, callback);
				EventBus.publish(event);
				logger.debug("done running asynchronous singing");
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#signAuth(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void signAuth(final String hash, final String digestAlgorithm, final String callback) {
		logger.debug("entering signAuth asynchronous method");
		
		executorService.submit(new Runnable() {
			
			public void run() {
				logger.debug("running asynchronous signing auth");
				JSSignedHash signedHash = new JSSignedHash(hash, getExternalConnectionService().getExternalInputManager().signAuth(hash, digestAlgorithm).getResult());
				HashSignedEvent event = new HashSignedEvent(signedHash, callback);
				EventBus.publish(event);
				logger.debug("done running asynchronous singing");
			}
		});
	}


	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getPhoto(java.lang.String)
	 */
	public void getPhoto(final String callback)
	{
		logger.debug("Getting Async Photo");
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async Photo");
				PhotoFetchedEvent event = new PhotoFetchedEvent(getExternalConnectionService().getExternalInputManager().getPhoto(),callback);
				EventBus.publish(event);
				logger.debug("Done running Async Photo");
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getIdentity(java.lang.String)
	 */
	public void getIdentity(final String callback) {
		logger.debug("Getting Async Identity");
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async identity");
				IdentityFetchedEvent event = new IdentityFetchedEvent(getExternalConnectionService().getExternalInputManager().getIdentity(),callback);
				EventBus.publish(event);
				logger.debug("Done running Async identity");
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getAddress(java.lang.String)
	 */
	public void getAddress(final String callback) {
		logger.debug("Getting Async address");
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async address");
				AddressFetchedEvent event = new AddressFetchedEvent(getExternalConnectionService().getExternalInputManager().getAddress(), callback);
				EventBus.publish(event);
				logger.debug("Done running async address");
			}
		});
	}
	
	

	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getAuthenticationCertificate(java.lang.String)
	 */
	public void getAuthenticationCertificate(final String callback) {
		logger.debug("Getting async authentication certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async authentication certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getAuthenticationCertificate(), callback);
				EventBus.publish(event);
				logger.debug("Done running authentication certificate");
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getSigningCertificate(java.lang.String)
	 */
	public void getSigningCertificate(final String callback) {
		logger.debug("Getting async signing certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async signing certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getSigningCertificate(), callback);
				EventBus.publish(event);
				logger.debug("Done running signing certificate");
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getCACertificate(java.lang.String)
	 */
	public void getCACertificate(final String callback) {
		logger.debug("Getting async ca certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async ca certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getCACertificate(), callback);
				EventBus.publish(event);
				logger.debug("Done running ca certificate");
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getRootCACertificate(java.lang.String)
	 */
	public void getRootCACertificate(final String callback) {
		logger.debug("Getting async rootca certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async rootca certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getRootCACertificate(), callback);
				EventBus.publish(event);
				logger.debug("Done running rootca certificate ");
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see com.trust1t.obea.async.ExternalAsyncInputManager#getRRNCertificate(java.lang.String)
	 */
	public void getRRNCertificate(final String callback) {
		logger.debug("Getting async rrn certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async rrn certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getRRNCertificate(), callback);
				EventBus.publish(event);
				logger.debug("Done running rrn certificate");
			}
		});
		
	}

	/**
	 * Gets the external connection service.
	 *
	 * @return the external connection service
	 */
	public ExternalConnectionService getExternalConnectionService() {
		return externalConnectionService;
	}



}
