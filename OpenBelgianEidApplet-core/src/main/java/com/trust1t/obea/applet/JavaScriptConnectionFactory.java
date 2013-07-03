package com.trust1t.obea.applet;

import netscape.javascript.JSObject;

import com.google.common.eventbus.EventBus;
import com.trust1t.obea.external.ExternalConnectionService;
import com.trust1t.obea.service.BeidCardController;

public class JavaScriptConnectionFactory {
	
	public static ExternalConnectionService createExternalConnection(EventBus eventBus, BeidCardController appletController, JSObject jsObject)
	{
		return new JavaScriptController(eventBus, appletController, jsObject);
	}
}
