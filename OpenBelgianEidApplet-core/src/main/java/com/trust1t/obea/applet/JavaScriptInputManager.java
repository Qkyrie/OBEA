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
package com.trust1t.obea.applet;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;

import javax.smartcardio.CardException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.fedict.commons.eid.client.FileType;
import be.fedict.commons.eid.client.impl.BeIDDigest;
import be.fedict.commons.eid.consumer.Address;
import be.fedict.commons.eid.consumer.Identity;
import be.fedict.commons.eid.consumer.tlv.TlvParser;

import com.trust1t.obea.applet.dto.JSAddress;
import com.trust1t.obea.applet.dto.JSCertificate;
import com.trust1t.obea.applet.dto.JSCertificateChain;
import com.trust1t.obea.applet.dto.JSIdentity;
import com.trust1t.obea.applet.dto.JSPhoto;
import com.trust1t.obea.applet.dto.JSSignResponse;
import com.trust1t.obea.applet.ui.JavaScriptUIBridge;
import com.trust1t.obea.applet.ui.PinCache;
import com.trust1t.obea.dto.ExternalAddress;
import com.trust1t.obea.dto.ExternalCertificate;
import com.trust1t.obea.dto.ExternalCertificateChain;
import com.trust1t.obea.dto.ExternalErrorCodes;
import com.trust1t.obea.dto.ExternalIdentity;
import com.trust1t.obea.dto.ExternalPhoto;
import com.trust1t.obea.dto.ExternalSignResponse;
import com.trust1t.obea.external.ExternalInputManager;
import com.trust1t.obea.service.BeidCardController;

// TODO: Auto-generated Javadoc
/**
 * The manager responsible for all input of the JavaScript side.
 * 
 * These input methods are called from JavaScript and are delegated to this class. 
 * This class is responsible for reading the input and transforming it to an internal call, which
 * then gives an output back to the JavaScript.
 */
public class JavaScriptInputManager implements ExternalInputManager{

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(JavaScriptInputManager.class);
	
	/** The cached pin. */
	private String cachedPin;
	
	/** The beid card controller. */
	private BeidCardController beidCardController;
	
	/**
	 * Instantiates a new java script input manager.
	 *
	 * @param beidCardController the beid card controller
	 */
	public JavaScriptInputManager(BeidCardController beidCardController) {
		this.beidCardController = beidCardController;
	}
	
	/**
	 * Gets the address Object.
	 *
	 * @return the address
	 */
	public ExternalAddress getAddress()
	{
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<JSAddress>() {
					public JSAddress run() {
						try 
						{
							final byte[] idData = beidCardController.getCachedCard().readFile(FileType.Address);
							final Address address = TlvParser.parse(idData, Address.class);
							return new JSAddress(address);
						} 
						catch(InterruptedException ie)
						{
							return new JSAddress(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSAddress(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSAddress(ExternalErrorCodes.NO_CARD_INSERTED);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.external.ExternalInputManager#getPhoto()
	 */
	public ExternalPhoto getPhoto() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<JSPhoto>() {

				public JSPhoto run() {
					try 
					{
						final byte[] photoData = beidCardController.getCachedCard().readFile(FileType.Photo);
						logger.debug("successfully fetched the photo as bytearray");
						return new JSPhoto(Base64.encodeBase64String(photoData));
					} 
					catch(InterruptedException ie)
					{
						logger.error("card was busy");
						return new JSPhoto(ExternalErrorCodes.CARD_BUSY);
					}
					catch (Exception e) {
						logger.error(e.getMessage());
						return new JSPhoto(ExternalErrorCodes.ACCESS_DENIED);
					}
				}
			});
		}
		else
		{
			logger.error("no card was inserted");
			return new JSPhoto(ExternalErrorCodes.NO_CARD_INSERTED);
		}
		
		
	}

	
	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getIdentity()
	 */
	public ExternalIdentity getIdentity()
	{
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<JSIdentity>() {
					public JSIdentity run() {
						try 
						{
							final byte[] idData = beidCardController.getCachedCard().readFile(FileType.Identity);
							final Identity userIdentity = TlvParser.parse(idData, Identity.class);
							return new JSIdentity(userIdentity);
						} 
						catch(InterruptedException ie)
						{
							return new JSIdentity(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSIdentity(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSIdentity(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}
	

	
	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion()
	{
		return "1.0.0-SNAPSHOT";
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getAuthenticationCertificate()
	 */
	public ExternalCertificate getAuthenticationCertificate() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificate>() {
					public ExternalCertificate run() {
						try 
						{
							final String authenticationCertificate;
							authenticationCertificate = Base64.encodeBase64String(beidCardController.getCachedCard().getAuthenticationCertificate().getEncoded());
							logger.debug("authenticationCertificate: {}", authenticationCertificate);
							return new JSCertificate(authenticationCertificate, ExternalErrorCodes.SUCCEEDED);
						} 
						catch(CardException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificate(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificate(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificate(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}



	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getSigningCertificate()
	 */
	public ExternalCertificate getSigningCertificate() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificate>() {
					public ExternalCertificate run() {
						try 
						{
							final String signingCertificate;
							signingCertificate = Base64.encodeBase64String(beidCardController.getCachedCard().getSigningCertificate().getEncoded());
							logger.debug("signingCertificate: {}", signingCertificate);
							return new JSCertificate(signingCertificate, ExternalErrorCodes.SUCCEEDED);
						} 
						catch(CardException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificate(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificate(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificate(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getCACertificate()
	 */
	public ExternalCertificate getCACertificate() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificate>() {
					public ExternalCertificate run() {
						try 
						{
							final String caCertificate;
							caCertificate = Base64.encodeBase64String(beidCardController.getCachedCard().getCACertificate().getEncoded());
							logger.debug("caCertificate: {}", caCertificate);
							return new JSCertificate(caCertificate, ExternalErrorCodes.SUCCEEDED);
						} 
						catch(CardException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificate(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificate(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificate(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}




	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getRootCACertificate()
	 */
	public ExternalCertificate getRootCACertificate() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificate>() {
					public ExternalCertificate run() {
						try 
						{
							final String rootCACertificate;
							rootCACertificate = Base64.encodeBase64String(beidCardController.getCachedCard().getRootCACertificate().getEncoded());
							logger.debug("rootCACertificate: {}", rootCACertificate);
							return new JSCertificate(rootCACertificate, ExternalErrorCodes.SUCCEEDED);
						} 
						catch(CardException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificate(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificate(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificate(ExternalErrorCodes.NO_CARD_INSERTED);
		}
		
	}




	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getRRNCertificate()
	 */
	public ExternalCertificate getRRNCertificate() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificate>() {
					public ExternalCertificate run() {
						try 
						{
							final String rrnCertificate;
							rrnCertificate = Base64.encodeBase64String(beidCardController.getCachedCard().getAuthenticationCertificate().getEncoded());
							logger.debug("rrnCertificate: {}", rrnCertificate);
							return new JSCertificate(rrnCertificate, ExternalErrorCodes.SUCCEEDED);
						} 
						catch(CardException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificate(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificate(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificate(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificate(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}




	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getAuthenticationCertificateChain()
	 */
	public ExternalCertificateChain getAuthenticationCertificateChain() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificateChain>() {
					public ExternalCertificateChain run() {
						try 
						{
							List<String> authenticationCertificateChain = new LinkedList<String>();
							for(X509Certificate x509Certificate : beidCardController.getCachedCard().getAuthenticationCertificateChain())
							{
								final String authenticationChainPart = Base64.encodeBase64String(x509Certificate.getEncoded());
								authenticationCertificateChain.add(authenticationChainPart);
								logger.debug("authenticationChainPart: {}", authenticationChainPart);
							}
							
							return new JSCertificateChain(authenticationCertificateChain);
						} 
						catch(CardException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificateChain(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificateChain(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}




	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getSigningCertificateChain()
	 */
	public ExternalCertificateChain getSigningCertificateChain() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificateChain>() {
					public ExternalCertificateChain run() {
						try 
						{
							List<String> signingCertificateChain = new LinkedList<String>();
							for(X509Certificate x509Certificate : beidCardController.getCachedCard().getSigningCertificateChain())
							{
								final String signingChainPart = Base64.encodeBase64String(x509Certificate.getEncoded());
								signingCertificateChain.add(signingChainPart);
								logger.debug("signingChainPart: {}", signingChainPart);
							}
							
							return new JSCertificateChain(signingCertificateChain);
						} 
						catch(CardException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificateChain(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificateChain(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}




	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getCACertificateChain()
	 */
	public ExternalCertificateChain getCACertificateChain() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificateChain>() {
					public ExternalCertificateChain run() {
						try 
						{
							List<String> caCertificateChain = new LinkedList<String>();
							for(X509Certificate x509Certificate : beidCardController.getCachedCard().getCACertificateChain())
							{
								final String caCertificateChainPart = Base64.encodeBase64String(x509Certificate.getEncoded());
								caCertificateChain.add(caCertificateChainPart);
								logger.debug("caCertificateChainPart: {}", caCertificateChainPart);
							}
							
							return new JSCertificateChain(caCertificateChain);
						} 
						catch(CardException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificateChain(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificateChain(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}




	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getRRNCertificateChain()
	 */
	public ExternalCertificateChain getRRNCertificateChain() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalCertificateChain>() {
					public ExternalCertificateChain run() {
						try 
						{
							List<String> rrnCertificateChain = new LinkedList<String>();
							for(X509Certificate x509Certificate : beidCardController.getCachedCard().getRRNCertificateChain())
							{
								final String rrnCertificateChainPart = Base64.encodeBase64String(x509Certificate.getEncoded());
								rrnCertificateChain.add(rrnCertificateChainPart);
								logger.debug("rrnCertificateChainPart: {}", rrnCertificateChainPart);
							}
							
							return new JSCertificateChain(rrnCertificateChain);
						} 
						catch(CardException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(IOException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch(CertificateException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CERTIFICATE_PROBLEM);
						}
						catch(InterruptedException e)
						{
							return new JSCertificateChain(ExternalErrorCodes.CARD_BUSY);
						}
						catch (Exception e) {
							logger.error(e.getMessage());
							return new JSCertificateChain(ExternalErrorCodes.ACCESS_DENIED);
						}
					}
				});
		} 
		else
		{
			logger.error("no card was inserted");
			return new JSCertificateChain(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.external.ExternalInputManager#verifyPin()
	 */
	public boolean verifyPin()
	{
		//if the pin wasn't set yet, return false
		if(this.cachedPin == null || this.cachedPin.equals(""))
		{
			return false;
		}
		
		//else create new pincache for gui
		PinCache cache = new PinCache(this.cachedPin);
		beidCardController.setUiBridge(new JavaScriptUIBridge());
		beidCardController.getUiBridge().setPinCache(cache);
		JSSignResponse response = (JSSignResponse) signRsa("a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s=");
		if (response.getErrorCode().equals(ExternalErrorCodes.SUCCEEDED.getErrorCode())){
			
			//means that pin was OK, keep it like this in cache
			return true;
			
		}
		else
		{
			logger.error("pin wasn't OK");
			//resetting pin now, it wasn't OK
			this.cachedPin = null;
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.trust1t.obea.external.ExternalInputManager#signRsa(java.lang.String)
	 */
	public ExternalSignResponse signRsa(final String base64EncodedBytes)
	{
		//if the pin wasn't set yet, return false
		if(this.cachedPin == null || this.cachedPin.equals(""))
		{
			return new JSSignResponse(ExternalErrorCodes.NO_PIN_PRIVIDED);
		}
				
		//else create new pincache for gui
		PinCache cache = new PinCache(this.cachedPin);
		beidCardController.setUiBridge(new JavaScriptUIBridge());
		beidCardController.getUiBridge().setPinCache(cache);
		
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<ExternalSignResponse>() {
				public ExternalSignResponse run() {
					try 
					{
					    byte[] originalBytes = null;
						originalBytes = Base64.decodeBase64(base64EncodedBytes);
						byte[] returnValue =  beidCardController.getCachedCard().sign(originalBytes, BeIDDigest.SHA_256, FileType.NonRepudiationCertificate, false);
						String returnValueEncoded = Base64.encodeBase64String(returnValue);
						return new JSSignResponse(returnValueEncoded);
					} 
					
				catch (Exception e) 
				{
					e.printStackTrace();
					logger.error("couldn't decode bytes for given base64 encoded message");
					return new JSSignResponse(ExternalErrorCodes.ILLEGAL_ARGUMENT);
				}
			}
			
			});
		}
		else
		{
			logger.error("no card was inserted");
			return new JSSignResponse(ExternalErrorCodes.NO_CARD_INSERTED);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.trust1t.obea.external.ExternalInputManager#setPin(java.lang.String)
	 */
	public void setPin(String pinCode)
	{
		if(beidCardController.hasCachedCard())
		{
			try {
				logger.debug("setting pincache");
				PinCache cache = new PinCache(pinCode);
				beidCardController.setUiBridge(new JavaScriptUIBridge());
				beidCardController.getUiBridge().setPinCache(cache);
				this.cachedPin = pinCode;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}
	

	/* (non-Javadoc)
	 * @see com.qkyrie.ts.mkqapplet.external.ExternalInputManager#getCardAtr()
	 */
	public String getCardAtr() {
		if(beidCardController.hasCachedCard())
		{
			return AccessController.doPrivileged(new PrivilegedAction<String>() {
					public String run() {
						try 
						{
							final String cardAtr;
							cardAtr = Base64.encodeBase64String(beidCardController.getCachedCard().getATR().getBytes());
							logger.debug("signingCertificate: {}", cardAtr);
							return cardAtr;
						} 
						catch (Exception e) {
							logger.error(e.getMessage());
							return null;
						}
					}
				});
		} 
		else
		{
			return null;
		}
	}


	
	
	
}
