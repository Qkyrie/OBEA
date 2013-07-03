/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.applet.dto;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalErrorCodes;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalPhoto;

/**
 * The wrapper for a certificate to be sent through JavaScript.
 */
public class JSPhoto implements ExternalPhoto{

	/** The base64 encoded certificate. */
	private final String base64Photo;
	
	/** The error code. */
	private final String errorCode;
	
	/**
	 * Instantiates a new jS certificate.
	 *
	 * @param base64Photo the base64 encoded certificate
	 * @param errorCode the error code
	 */
	public JSPhoto(String base64Photo)
	{
		this.errorCode = ExternalErrorCodes.SUCCEEDED.getErrorCode();
		this.base64Photo = base64Photo;
	}
	
	/**
	 * JSCertificate constructor, to be used when something failed
	 * @param errorCode
	 */
	public JSPhoto(ExternalErrorCodes errorCode)
	{
		this.base64Photo = null;
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
	public String getBase64Photo() {
		return base64Photo;
	}
	
	

}
