package com.trust1t.ocs.belgianeidsigning.events;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalIdentity;

public class IdentityFetchedEvent {

	private ExternalIdentity externalIdentity;
	private String callback;
	
	public IdentityFetchedEvent(ExternalIdentity externalIdentity, String callback)
	{
		this.externalIdentity = externalIdentity;
		this.callback = callback;
	}
	
	public ExternalIdentity getIdentity()
	{
		return this.externalIdentity;
	}

	public String getCallback() {
		return callback;
	}
	
	
}
