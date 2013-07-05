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
