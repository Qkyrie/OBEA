package com.trust1t.ocs.belgianeidsigning.events;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalPhoto;

public class PhotoFetchedEvent {

	private ExternalPhoto externalIdentity;
	private String callback;
	
	public PhotoFetchedEvent(ExternalPhoto externalPhoto, String callback)
	{
		this.externalIdentity = externalPhoto;
		this.callback = callback;
	}
	
	public ExternalPhoto getPhoto()
	{
		return this.externalIdentity;
	}

	public String getCallback() {
		return callback;
	}
	
	
}
