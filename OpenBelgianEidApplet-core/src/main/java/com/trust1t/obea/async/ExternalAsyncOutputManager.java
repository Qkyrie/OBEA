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
package com.trust1t.obea.async;

import com.trust1t.obea.applet.dto.JSSignedHash;
import com.trust1t.obea.dto.ExternalAddress;
import com.trust1t.obea.dto.ExternalCertificate;
import com.trust1t.obea.dto.ExternalIdentity;
import com.trust1t.obea.dto.ExternalPhoto;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExternalAsyncOutputManager.
 */
public interface ExternalAsyncOutputManager {

	/**
	 * On get identity async callback.
	 *
	 * @param identity the identity
	 * @param callback the callback
	 */
	void onGetIdentityAsyncCallback(ExternalIdentity identity, String callback);
	
	/**
	 * On get photo async callback.
	 *
	 * @param photo the photo
	 * @param callback the callback
	 */
	void onGetPhotoAsyncCallback(ExternalPhoto photo, String callback);
	
	/**
	 * On get address async callback.
	 *
	 * @param address the address
	 * @param callback the callback
	 */
	void onGetAddressAsyncCallback(ExternalAddress address, String callback);
	
	/**
	 * On get certificate callback.
	 *
	 * @param certificate the certificate
	 * @param callback the callback
	 */
	void onGetCertificateCallback(ExternalCertificate certificate, String callback);
	
	/**
	 * On hash signed callback.
	 *
	 * @param signedHash the signed hash
	 * @param callback the callback
	 */
	void onHashSignedCallback(JSSignedHash signedHash, String callback);
	
	/**
	 * On pin verified callback.
	 *
	 * @param pinVerified the pin verified
	 * @param callback the callback
	 */
	void onPinVerifiedCallback(boolean pinVerified, String callback);
}
