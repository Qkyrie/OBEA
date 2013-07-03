package com.trust1t.obea.async;

/**
 * this is the core's API
 * @author Quinten
 *
 */
public interface ExternalAsyncInputManager {

	void getIdentity(String callback);
	void getAddress(String callback);
	void getPhoto(String callback);
	
	void getAuthenticationCertificate(String callback);
	void getSigningCertificate(String callback);
	void getCACertificate(String callback);
	void getRootCACertificate(String callback);
	void getRRNCertificate(String callback);
	
}
