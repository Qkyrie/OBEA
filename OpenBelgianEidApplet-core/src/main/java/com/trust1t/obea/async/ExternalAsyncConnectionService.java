package com.trust1t.obea.async;

import com.google.common.eventbus.EventBus;

public class ExternalAsyncConnectionService {

	private EventBus eventBus;
	
	public ExternalAsyncConnectionService(EventBus eventBus)
	{
		this.eventBus = eventBus;
		addAsListener();
	}
	
	private void addAsListener()
	{
		this.eventBus.register(this);
	}
	
	
	
	
	
}
