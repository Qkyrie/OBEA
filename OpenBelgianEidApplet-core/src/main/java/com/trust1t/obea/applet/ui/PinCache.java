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
package com.trust1t.obea.applet.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <b>PinCache</b> Class. 
 * 
 * This cache provides basic functionality to <i>temporarily</i> save the pin, provided by the frontend.
 */
public class PinCache {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(PinCache.class);

	/** The pin cache. */
	private char[] pin;
	
	/**
	 * Instantiates a new pin cache.
	 *
	 * @param pinCache the pin cache
	 */
	public PinCache(String pinCache)
	{
		this.pin = pinCache.toCharArray();
	}

	/**
	 * Gets the pin cache.
	 *
	 * @return the pin cache
	 */
	public char[] getPin() {
		logger.debug("getting the cached pin");
		return pin;
	}
	
}
