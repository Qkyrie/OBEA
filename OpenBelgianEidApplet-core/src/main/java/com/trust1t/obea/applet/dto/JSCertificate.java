/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.applet.dto;

import com.trust1t.obea.dto.ExternalCertificate;
import com.trust1t.obea.dto.ExternalErrorCodes;
import com.trust1t.obea.dto.ExternalFailable;

/**
 * The wrapper for a certificate to be sent through JavaScript.
 */
public class JSCertificate implements ExternalCertificate, ExternalFailable{

	/** The base64 encoded certificate. */
	private final String base64EncodedCertificate;
	
	/** The error code. */
	private final String errorCode;
	
	/**
	 * Instantiates a new jS certificate.
	 *
	 * @param base64EncodedCertificate the base64 encoded certificate
	 * @param errorCode the error code
	 */
	public JSCertificate(String base64EncodedCertificate, ExternalErrorCodes errorCode)
	{
		this.errorCode = errorCode.getErrorCode();
		this.base64EncodedCertificate = base64EncodedCertificate;
	}
	
	/**
	 * JSCertificate constructor, to be used when something failed
	 * @param errorCode
	 */
	public JSCertificate(ExternalErrorCodes errorCode)
	{
		this.base64EncodedCertificate = null;
		this.errorCode = errorCode.getErrorCode();
	}
	
	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalFailable#getErrorCode()
	 */
	public String getErrorCode() {
		return errorCode;
	}


	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalCertificate#getBase64EncodedCertificate()
	 */
	public String getBase64EncodedCertificate() {
		return base64EncodedCertificate;
	}
	
	

}
