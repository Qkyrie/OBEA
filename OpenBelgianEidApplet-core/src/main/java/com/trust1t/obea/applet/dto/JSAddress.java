/*
 *
 * This file is part of the Trust1T (R) project.
 * Copyright (c) 2013 Trust1T BVBA
 * Authors: Michallis Pashidis, Kwinten Pisman, Quinten De Swaef
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License version 3
 * as published by the Free Software Foundation with the addition of the
 * following permission added to Section 15 as permitted in Section 7(a):
 * FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY Trust1T,
 * Trust1T DISCLAIMS THE WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA, 02110-1301 USA.
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License.
 *
 * You can be released from the requirements of the license by purchasing
 * a commercial license. Buying such a license is mandatory as soon as you
 * develop commercial activities involving the Trust1T software without
 * disclosing the source code of your own applications.
 * These activities include: offering paid services to customers as an ASP,
 * Signing PDFs on the fly in a web application, shipping OCS with a closed
 * source product...
 */
package com.trust1t.obea.applet.dto;

import be.fedict.commons.eid.consumer.Address;

import com.trust1t.obea.dto.ExternalAddress;
import com.trust1t.obea.dto.ExternalErrorCodes;
import com.trust1t.obea.dto.ExternalFailable;

// TODO: Auto-generated Javadoc
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
