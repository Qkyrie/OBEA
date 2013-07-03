package com.trust1t.obea.events;

import com.trust1t.obea.dto.ExternalCertificate;

public class CertificateFetchedEvent {

	private final ExternalCertificate externalCertificate;
	private final String callback;
	
	public CertificateFetchedEvent(ExternalCertificate externalCertificate, String callback)
	{
		this.externalCertificate = externalCertificate;
		this.callback = callback;
	}

	public ExternalCertificate getExternalCertificate() {
		return externalCertificate;
	}

	public String getCallback() {
		return callback;
	}
	
	
	
}
