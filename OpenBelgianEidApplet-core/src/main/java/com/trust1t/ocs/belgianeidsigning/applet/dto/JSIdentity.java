/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.applet.dto;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;

import be.fedict.commons.eid.consumer.Identity;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalErrorCodes;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalIdentity;

/**
 * The JavaScript Identity Class which will be sent to the javascript frontend.
 * It is mainly a wrapper around the commons-eid identity
 * 
 * This class is part of the public API
 */
public class JSIdentity implements ExternalIdentity{

	private final String errorCode;
	private final Identity eidIdentity;

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
