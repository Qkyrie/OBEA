/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.external;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalAddress;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalCertificate;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalCertificateChain;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalIdentity;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalPhoto;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalSignResponse;

/**
 * The Interface ExternalInputManager.
 */
public interface ExternalInputManager {
	
	/**
	 * Sets the pin.
	 */
	void setPin(String pinCode);
	
    ExternalSignResponse signRsa(String base64EncodedBytes);

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
	
	ExternalPhoto getPhoto();
	
	ExternalAddress getAddress();
	
	/**
	 * Gets the Cards ATR
	 * @return
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
