package com.trust1t.ocs.belgianeidsigning.external.async;

import com.trust1t.ocs.belgianeidsigning.dto.ExternalAddress;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalCertificate;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalIdentity;
import com.trust1t.ocs.belgianeidsigning.dto.ExternalPhoto;

public interface ExternalAsyncOutputManager {

	void onGetIdentityAsyncCallback(ExternalIdentity identity, String callback);
	void onGetPhotoAsyncCallback(ExternalPhoto photo, String callback);
	void onGetAddressAsyncCallback(ExternalAddress address, String callback);
	void onGetCertificateCallback(ExternalCertificate certificate, String callback);
}
