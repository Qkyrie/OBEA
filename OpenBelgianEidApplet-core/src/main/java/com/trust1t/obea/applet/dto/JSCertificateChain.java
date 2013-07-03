/**
 * 
 */
package com.trust1t.obea.applet.dto;

import java.util.List;

import com.trust1t.obea.dto.ExternalCertificateChain;
import com.trust1t.obea.dto.ExternalErrorCodes;
import com.trust1t.obea.dto.ExternalFailable;

/**
 * The Class JavaScriptCertificateChain.
 *
 * @author quintend
 */
public class JSCertificateChain implements ExternalCertificateChain, ExternalFailable{

	/** The error code. */
	private final String errorCode;
	
	/** The certificate chain. */
	private final String[] certificateChain;
	
	/**
	 * Instantiates a new java script certificate chain.
	 *
	 * @param errorCode the error code
	 */
	public JSCertificateChain(ExternalErrorCodes errorCode)
	{
		this.errorCode = errorCode.getErrorCode();
		this.certificateChain = null;
	}
	
	public JSCertificateChain(List<String> certificateList)
	{
		this.certificateChain = (String[]) certificateList.toArray(new String[certificateList.size()]);
		this.errorCode = ExternalErrorCodes.SUCCEEDED.getErrorCode();
	}
	
	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalFailable#getErrorCode()
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalCertificateChain#getCertificateChain()
	 */
	public String[] getCertificateChain() {
		return this.certificateChain;
	}

	
	
}
