package com.trust1t.ocs.belgianeidsigning.events;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalAddress;

public class AddressFetchedEvent {
	
	private ExternalAddress externalAddress;
	private String callback;
	public AddressFetchedEvent(ExternalAddress externalAddress, String callback)
	{
		this.externalAddress = externalAddress;
		this.callback = callback;
	}

	public ExternalAddress getAddress()
	{
		return externalAddress;
	}

	public String getCallback() {
		return callback;
	}
	
}
