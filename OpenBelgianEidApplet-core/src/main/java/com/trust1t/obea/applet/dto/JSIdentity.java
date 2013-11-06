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

import java.util.Date;

import org.apache.commons.codec.binary.Base64;

import be.fedict.commons.eid.consumer.Identity;

import com.trust1t.obea.dto.ExternalErrorCodes;
import com.trust1t.obea.dto.ExternalIdentity;

// TODO: Auto-generated Javadoc
/**
 * The JavaScript Identity Class which will be sent to the javascript frontend.
 * It is mainly a wrapper around the commons-eid identity
 * 
 * This class is part of the public API
 */
public class JSIdentity implements ExternalIdentity{

	/** The error code. */
	private final String errorCode;
	
	/** The eid identity. */
	private final Identity eidIdentity;

	/**
	 * Instantiates a new jS identity.
	 *
	 * @param errorCode the error code
	 */
	public JSIdentity(ExternalErrorCodes errorCode)
	{
		this.errorCode = errorCode.getErrorCode();
		this.eidIdentity = null;
	}
	
	/**
	 * Instantiates a new jS identity.
	 *
	 * @param userIdentity the user identity
	 */
	public JSIdentity(Identity userIdentity)
	{
		this.errorCode = ExternalErrorCodes.SUCCEEDED.getErrorCode();
		this.eidIdentity = userIdentity;
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getCardNumber()
	 */
	public String getCardNumber() {
		return eidIdentity.getCardNumber();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getChipNumber()
	 */
	public String getChipNumber() {
		return eidIdentity.getChipNumber();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getCardValidityDateBegin()
	 */
	public Date getCardValidityDateBegin() {
		return eidIdentity.getCardValidityDateBegin().getTime();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getCardValidityDateEnd()
	 */
	public Date getCardValidityDateEnd() {
		return eidIdentity.getCardValidityDateEnd().getTime();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getCardDeliveryMunicipality()
	 */
	public String getCardDeliveryMunicipality() {
		return eidIdentity.getCardDeliveryMunicipality();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getNationalNumber()
	 */
	public String getNationalNumber() {
		return eidIdentity.getNationalNumber();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getName()
	 */
	public String getName() {
		return eidIdentity.getName();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getFirstName()
	 */
	public String getFirstName() {
		return eidIdentity.getFirstName();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getMiddleName()
	 */
	public String getMiddleName() {
		return eidIdentity.getMiddleName();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getNationality()
	 */
	public String getNationality() {
		return eidIdentity.getNationality();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getPlaceOfBirth()
	 */
	public String getPlaceOfBirth() {
		return eidIdentity.getPlaceOfBirth();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getDateOfBirth()
	 */
	public Date getDateOfBirth() {
		return eidIdentity.getDateOfBirth().getTime();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getGender()
	 */
	public String getGender() {
		return eidIdentity.getGender().name();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getNobleCondition()
	 */
	public String getNobleCondition() {
		return eidIdentity.getNobleCondition();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getDocumentType()
	 */
	public String getDocumentType() {
		return eidIdentity.getDocumentType().name();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getSpecialStatus()
	 */
	public String getSpecialStatus() {
		return eidIdentity.getSpecialStatus().name();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getDuplicate()
	 */
	public String getDuplicate() {
		return eidIdentity.getDuplicate();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.javascript.dto.ExternalIdentity#getSpecialOrganisation()
	 */
	public String getSpecialOrganisation() {
		return eidIdentity.getSpecialOrganisation().name();
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.dto.ExternalFailable#getErrorCode()
	 */
	public String getErrorCode() {
		return this.errorCode;
	}
	
	
	
}
