package com.trust1t.obea.async;

import com.trust1t.obea.dto.ExternalAddress;
import com.trust1t.obea.dto.ExternalCertificate;
import com.trust1t.obea.dto.ExternalIdentity;
import com.trust1t.obea.dto.ExternalPhoto;

public interface ExternalAsyncOutputManager {

	void onGetIdentityAsyncCallback(ExternalIdentity identity, String callback);
	void onGetPhotoAsyncCallback(ExternalPhoto photo, String callback);
	void onGetAddressAsyncCallback(ExternalAddress address, String callback);
	void onGetCertificateCallback(ExternalCertificate certificate, String callback);
}
