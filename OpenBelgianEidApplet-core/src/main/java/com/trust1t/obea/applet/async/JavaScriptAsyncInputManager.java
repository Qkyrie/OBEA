package com.trust1t.obea.applet.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.google.common.eventbus.EventBus;
import com.trust1t.obea.async.ExternalAsyncInputManager;
import com.trust1t.obea.events.AddressFetchedEvent;
import com.trust1t.obea.events.CertificateFetchedEvent;
import com.trust1t.obea.events.IdentityFetchedEvent;
import com.trust1t.obea.events.PhotoFetchedEvent;
import com.trust1t.obea.external.ExternalConnectionService;

public class JavaScriptAsyncInputManager implements ExternalAsyncInputManager{
	private ExecutorService executorService;
	
	private final Logger logger = LoggerFactory.getLogger(JavaScriptAsyncInputManager.class);
	
	private final ExternalConnectionService externalConnectionService;
	private final EventBus eventBus;
	
	public JavaScriptAsyncInputManager(EventBus eventBus, ExternalConnectionService externalConnectionService)
	{
		this.eventBus = eventBus;
		this.externalConnectionService = externalConnectionService;
		//only create a threadpool of size 1, it should be a blockingqueue
		this.executorService = Executors.newSingleThreadExecutor();
	}
	
	public void getPhoto(final String callback)
	{
		logger.debug("Getting Async Photo");
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async Photo");
				PhotoFetchedEvent event = new PhotoFetchedEvent(getExternalConnectionService().getExternalInputManager().getPhoto(),callback);
				eventBus.post(event);
				logger.debug("Done running Async Photo");
			}
		});
	}
	
	public void getIdentity(final String callback) {
		logger.debug("Getting Async Identity");
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async identity");
				IdentityFetchedEvent event = new IdentityFetchedEvent(getExternalConnectionService().getExternalInputManager().getIdentity(),callback);
				eventBus.post(event);
				logger.debug("Done running Async identity");
			}
		});
		
	}

	public void getAddress(final String callback) {
		logger.debug("Getting Async address");
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async address");
				AddressFetchedEvent event = new AddressFetchedEvent(getExternalConnectionService().getExternalInputManager().getAddress(), callback);
				eventBus.post(event);
				logger.debug("Done running async address");
			}
		});
	}
	
	

	public void getAuthenticationCertificate(final String callback) {
		logger.debug("Getting async authentication certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async authentication certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getAuthenticationCertificate(), callback);
				eventBus.post(event);
				logger.debug("Done running authentication certificate");
			}
		});
	}

	public void getSigningCertificate(final String callback) {
		logger.debug("Getting async signing certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async signing certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getSigningCertificate(), callback);
				eventBus.post(event);
				logger.debug("Done running signing certificate");
			}
		});
		
	}

	public void getCACertificate(final String callback) {
		logger.debug("Getting async ca certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async ca certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getCACertificate(), callback);
				eventBus.post(event);
				logger.debug("Done running ca certificate");
			}
		});
		
	}

	public void getRootCACertificate(final String callback) {
		logger.debug("Getting async rootca certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async rootca certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getRootCACertificate(), callback);
				eventBus.post(event);
				logger.debug("Done running rootca certificate ");
			}
		});
		
	}

	public void getRRNCertificate(final String callback) {
		logger.debug("Getting async rrn certificate");
		
		executorService.submit(new Runnable() {
			public void run() {
				logger.debug("Running Async rrn certificate");
				CertificateFetchedEvent event = new CertificateFetchedEvent(getExternalConnectionService().getExternalInputManager().getRRNCertificate(), callback);
				eventBus.post(event);
				logger.debug("Done running rrn certificate");
			}
		});
		
	}

	public ExternalConnectionService getExternalConnectionService() {
		return externalConnectionService;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

}
