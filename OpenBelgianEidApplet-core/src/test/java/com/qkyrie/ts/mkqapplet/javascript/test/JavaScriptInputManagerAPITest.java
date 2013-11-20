/*
 *
 * This file is part of the Trust1T (R) project.
 * Copyright (c) 2013 Trust1T BVBA
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
package com.qkyrie.ts.mkqapplet.javascript.test;

import org.junit.Test;

import com.qkyrie.ts.mkqapplet.tests.TestReflectionUtils;
import com.trust1t.obea.applet.JavaScriptInputManager;
import com.trust1t.obea.applet.JavaScriptOutputManager;
import com.trust1t.obea.applet.async.JavaScriptAsyncInputManager;

import static junit.framework.Assert.*;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaScriptInputManagerAPITest.
 */
public class JavaScriptInputManagerAPITest {
	
	/** asynchronous methods **/
	
	@Test
	public void getPhotoExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getPhoto", String.class));
	}
	
	@Test
	public void getIdentityExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getIdentity", String.class));
	}
	
	@Test
	public void getAddressExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getAddress", String.class));
	}

	@Test
	public void getAuthenticationCertificateExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getAuthenticationCertificate", String.class));
	}
	

	@Test
	public void getSigningCertificateExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getSigningCertificate", String.class));
	}
	

	@Test
	public void getCACertificateExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getCACertificate", String.class));
	}
	

	@Test
	public void getRootCACertificateExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getRootCACertificate", String.class));
	}
	

	@Test
	public void getRRNCertificateExists(){
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "getRRNCertificate", String.class));
	}
	
	@Test
	public void verifyPinExists()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "verifyPin", String.class));
	}
	

	@Test
	public void signRsaExists()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "signRsa", String.class, String.class));
	}
	
	@Test
	public void signAuthExists()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "signAuth", String.class, String.class));
	}
	
	@Test
	public void signRsaWithAlgorithmChoiceExists()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "signRsa", String.class, String.class, String.class));
	}
	
	@Test
	public void signAuthWithAlgorithmChoiceExists()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptAsyncInputManager.class, "signAuth", String.class, String.class, String.class));
	}
	
	/** synchronous methods **/
	/**
	 * Check if the method for getting the version in the api still exists.
	 *
	 * @return the version exists
	 */
	@Test
	public void getVersionExists()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getVersion", null));
	}
	/**
	 * Check if the method for getting the version in the api still exists.
	 *
	 * @return the version exists
	 */
	
	@Test
	public void getAddress()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getAddress", null));
	}
	
	@Test
	public void getPhoto()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getPhoto", null));
	}
	
	@Test
	public void getIdentity()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getIdentity", null));
	}
	
	@Test
	public void getAuthenticationCertificate()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getAuthenticationCertificate", null));
	}
	
	@Test
	public void getRRNCertificate()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getRRNCertificate", null));
	}
	
	@Test
	public void getSigningCertificate()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getSigningCertificate", null));
	}
	
	@Test
	public void getCACertificate()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getCACertificate", null));
	}
	
	@Test
	public void getRootCACertificate()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getRootCACertificate", null));
	}
	
	@Test
	public void getAuthenticationCertificateChain()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getAuthenticationCertificateChain", null));
	}
	
	@Test
	public void getSigningCertificateChain()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getSigningCertificateChain", null));
	}
	
	@Test
	public void getCACertificateChain()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getCACertificateChain", null));
	}
	
	@Test
	public void getRRNCertificateChain()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getRRNCertificateChain", null));
	}
	

	@Test
	public void verifyPin()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "verifyPin", null));
	}
	

	@Test
	public void signRSA()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "signRsa", String.class));
	}
	
	@Test
	public void setPin()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "setPin", String.class));
	}
	
}
