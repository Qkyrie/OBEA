/*
 * @author Quinten De Swaef
 */
package com.trust1t.obea.dto;

/**
 * The Enum ExternalErrorCodes.
 */
public enum ExternalErrorCodes {

	/** The succeeded. */
	SUCCEEDED("200"), /** The access denied. */
 ACCESS_DENIED("401"), /** The no card inserted. */
 NO_CARD_INSERTED("400"), /** The card busy. */
 CARD_BUSY("423"), /** The certificate problem. */
 CERTIFICATE_PROBLEM("415"),
 ILLEGAL_ARGUMENT("414"),
 NO_PIN_PRIVIDED("430");
	
	/** The error code. */
	private String errorCode;
	

	/**
	 * Instantiates a new external error codes.
	 *
	 * @param errorCode the error code
	 */
	private ExternalErrorCodes(String errorCode)
	{
		this.errorCode = errorCode;
	}
	
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString()
	{
		return getErrorCode();
	}
}
