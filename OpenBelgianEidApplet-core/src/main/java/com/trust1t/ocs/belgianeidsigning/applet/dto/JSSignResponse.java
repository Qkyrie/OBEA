/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.applet.dto;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalErrorCodes;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalFailable;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalSignResponse;

/**
 * The Class JSSignResponse.
 */
public class JSSignResponse implements ExternalSignResponse, ExternalFailable{

	/** The error code. */
	private String errorCode;
	
	/** The result. */
	private String result;
	
	/**
	 * Instantiates a new jS sign response.
	 *
	 * @param errorCode the error code
	 */
	public JSSignResponse(ExternalErrorCodes errorCode)
	{
		this.result = null;
		this.errorCode = errorCode.getErrorCode();
	}
	
	/**
	 * Instantiates a new jS sign response.
	 *
	 * @param base64EncodedResult the base64 encoded result
	 */
	public JSSignResponse(String base64EncodedResult)
	{
		this.result = base64EncodedResult;
		this.errorCode = ExternalErrorCodes.SUCCEEDED.getErrorCode();
	}
	
	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalFailable#getErrorCode()
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalSignResponse#getResult()
	 */
	public String getResult() {
		return this.result;
	}

	
}
