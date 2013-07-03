package com.trust1t.ocs.belgianeidsigning.applet;

import netscape.javascript.JSObject;

import com.google.common.eventbus.EventBus;
import com.trust1t.ocs.belgianeidsigning.external.ExternalConnectionService;
import com.trust1t.ocs.belgianeidsigning.service.BeidCardController;

public class JavaScriptConnectionFactory {
	
	public static ExternalConnectionService createExternalConnection(EventBus eventBus, BeidCardController appletController, JSObject jsObject)
	{
		return new JavaScriptController(eventBus, appletController, jsObject);
	}
}
