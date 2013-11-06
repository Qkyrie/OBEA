/*
 *
 * This file is part of the Trust1T (R) project.
 * Copyright (c) 2013 Trust1T
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

import com.trust1t.obea.dto.ExternalErrorCodes;
import com.trust1t.obea.dto.ExternalPhoto;

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
