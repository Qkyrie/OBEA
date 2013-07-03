package com.trust1t.ocs.belgianeidsigning.applet.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import netscape.javascript.JSObject;

import com.google.common.eventbus.EventBus;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalAddress;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalCertificate;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalIdentity;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalPhoto;
import com.trust1t.ocs.belgianeidsigning.external.async.ExternalAsyncOutputManager;

public class JavaScriptAsyncOutputManager implements ExternalAsyncOutputManager{

	private final Logger logger = LoggerFactory.getLogger(JavaScriptAsyncOutputManager.class);
	
	private final EventBus eventBus;
	private final JSObject jsObject;
	
	public JavaScriptAsyncOutputManager(EventBus eventBus, JSObject jbObject)
	{
		this.eventBus = eventBus;
		this.jsObject = jbObject;
	}
	
	public void onGetIdentityAsyncCallback(ExternalIdentity identity, String callback) {
		try 
		{
			jsObject.call(callback, new Object[]{identity});
		} catch (Exception e) {
			logger.error("error during getIdentityasync Callback to javascript");
		}
	}
	
	public void onGetPhotoAsyncCallback(ExternalPhoto photo, String callback) {
		try {
			jsObject.call(callback, new Object[]{photo});
		} catch (Exception e) {
			logger.error("error during getPhotoAsync Callback to javascript");
		}
		
	}


	public void onGetAddressAsyncCallback(ExternalAddress address, String callback) {
		try 
		{
			jsObject.call(callback, new Object[]{address});
		} catch (Exception e) {
			logger.error("error during getaddress Callback to javascript");
		}
	}
	
	public void onGetCertificateCallback(ExternalCertificate certificate, String callback)
	{
		try {
			jsObject.call(callback, new Object[]{certificate});
		} catch (Exception e) {
			logger.error("error during the getCertificate callback to javascript for callback: {}", callback);
		}
	}

	
}
