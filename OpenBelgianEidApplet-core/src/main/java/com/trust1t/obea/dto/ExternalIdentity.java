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
package com.trust1t.obea.dto;

import java.util.Date;

// TODO: Auto-generated Javadoc
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
