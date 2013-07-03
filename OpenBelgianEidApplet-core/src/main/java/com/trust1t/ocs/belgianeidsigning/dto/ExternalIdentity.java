/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.dto;

import java.util.Date;

/**
 * The Interface ExternalIdentity.
 */
public interface ExternalIdentity extends ExternalFailable{
	
	/**
	 * Gets the card number.
	 *
	 * @return the card number
	 */
	String getCardNumber();

	/**
	 * Gets the chip number.
	 *
	 * @return the chip number
	 */
	String getChipNumber();

	/**
	 * Gets the card validity date begin.
	 *
	 * @return the card validity date begin
	 */
	Date getCardValidityDateBegin();

	/**
	 * Gets the card validity date end.
	 *
	 * @return the card validity date end
	 */
	Date getCardValidityDateEnd();

	/**
	 * Gets the card delivery municipality.
	 *
	 * @return the card delivery municipality
	 */
	String getCardDeliveryMunicipality();

	/**
	 * Gets the national number.
	 *
	 * @return the national number
	 */
	String getNationalNumber();

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	String getFirstName();

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	String getMiddleName();

	/**
	 * Gets the nationality.
	 *
	 * @return the nationality
	 */
	String getNationality();

	/**
	 * Gets the place of birth.
	 *
	 * @return the place of birth
	 */
	String getPlaceOfBirth();

	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	Date getDateOfBirth();

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	String getGender();

	/**
	 * Gets the noble condition.
	 *
	 * @return the noble condition
	 */
	String getNobleCondition();

	/**
	 * Gets the document type.
	 *
	 * @return the document type
	 */
	String getDocumentType();

	/**
	 * Gets the special status.
	 *
	 * @return the special status
	 */
	String getSpecialStatus();

	/**
	 * Gets the duplicate.
	 *
	 * @return the duplicate
	 */
	String getDuplicate();

	/**
	 * Gets the special organisation.
	 *
	 * @return the special organisation
	 */
	String getSpecialOrganisation();

	
}
