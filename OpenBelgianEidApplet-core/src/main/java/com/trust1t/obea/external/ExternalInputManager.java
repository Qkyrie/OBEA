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
package com.trust1t.obea.external;

import com.trust1t.obea.dto.ExternalAddress;
import com.trust1t.obea.dto.ExternalCertificate;
import com.trust1t.obea.dto.ExternalCertificateChain;
import com.trust1t.obea.dto.ExternalIdentity;
import com.trust1t.obea.dto.ExternalPhoto;
import com.trust1t.obea.dto.ExternalSignResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExternalInputManager.
 */
public interface ExternalInputManager {
	
	/**
	 * Sets the pin.
	 *
	 * @param pinCode the new pin
	 */
	void setPin(String pinCode);
	
    /**
     * Sign rsa.
     *
     * @param base64EncodedBytes the base64 encoded bytes
     * @return the external sign response
     */
    ExternalSignResponse signRsa(String base64EncodedBytes);
    
    /**
     * Sign auth.
     *
     * @param base64EncodedBytes the base64 encoded bytes
     * @return the external sign response
     */
    ExternalSignResponse signAuth(String base64EncodedBytes);

    /**
     * Verify pin.
     *
     * @return true, if successful
     */
    boolean verifyPin();
    
	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	String getVersion();
	
	/**
	 * Gets the identity.
	 *
	 * @return the identity
	 */
	ExternalIdentity getIdentity();
	
	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	ExternalPhoto getPhoto();
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	ExternalAddress getAddress();
	
	/**
	 * Gets the Cards ATR.
	 *
	 * @return the card atr
	 */
	String getCardAtr();
	
	/**
	 * Gets the authentication certificate.
	 *
	 * @return the authentication certificate
	 */
	ExternalCertificate getAuthenticationCertificate();
	
	/**
	 * Gets the signing certificate.
	 *
	 * @return the signing certificate
	 */
	ExternalCertificate getSigningCertificate();
	
	/**
	 * Gets the cA certificate.
	 *
	 * @return the cA certificate
	 */
	ExternalCertificate getCACertificate();
	
	/**
	 * Gets the root ca certificate.
	 *
	 * @return the root ca certificate
	 */
	ExternalCertificate getRootCACertificate();
	
	/**
	 * Gets the rRN certificate.
	 *
	 * @return the rRN certificate
	 */
	ExternalCertificate getRRNCertificate();
	
	/**
	 * Gets the authentication certificate chain.
	 *
	 * @return the authentication certificate chain
	 */
	ExternalCertificateChain getAuthenticationCertificateChain();
	
	/**
	 * Gets the signing certificate chain.
	 *
	 * @return the signing certificate chain
	 */
	ExternalCertificateChain getSigningCertificateChain();
	
	/**
	 * Gets the cA certificate chain.
	 *
	 * @return the cA certificate chain
	 */
	ExternalCertificateChain getCACertificateChain();
	
	/**
	 * Gets the rRN certificate chain.
	 *
	 * @return the rRN certificate chain
	 */
	ExternalCertificateChain getRRNCertificateChain();
	
}
