/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.applet.dto;

import be.fedict.commons.eid.consumer.Address;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalAddress;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalErrorCodes;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalFailable;

/**
 * The Class JSAddress.
 */
public class JSAddress implements ExternalAddress, ExternalFailable{

	/** The error code. */
	private final String errorCode;

	/** The eid address. */
	private final Address eidAddress;

	/**
	 * Instantiates a new jS address.
	 *
	 * @param errorCode the error code
	 */
	public JSAddress(ExternalErrorCodes errorCode)
	{
		this.errorCode = errorCode.getErrorCode();
		eidAddress = null;
	}
	
	/**
	 * Instantiates a new jS address.
	 *
	 * @param eidAddress the eid address
	 */
	public JSAddress(Address eidAddress)
	{
		this.errorCode = ExternalErrorCodes.SUCCEEDED.getErrorCode();
		this.eidAddress = eidAddress;
	}
	
	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalAddress#getStreetAndNumber()
	 */
	public String getStreetAndNumber()
	{
		return eidAddress.getStreetAndNumber();
	}
	
	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalAddress#getZip()
	 */
	public String getZip()
	{
		return eidAddress.getZip();
	}
	
	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalAddress#getMunicipality()
	 */
	public String getMunicipality() {
		return eidAddress.getMunicipality();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalFailable#getErrorCode()
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	
	
}
