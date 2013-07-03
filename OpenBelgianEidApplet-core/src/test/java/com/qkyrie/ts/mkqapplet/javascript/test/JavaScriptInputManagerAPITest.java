package com.qkyrie.ts.mkqapplet.javascript.test;

import org.junit.Test;

import com.qkyrie.ts.mkqapplet.tests.TestReflectionUtils;
import com.trust1t.obea.applet.JavaScriptInputManager;
import com.trust1t.obea.applet.JavaScriptOutputManager;

import static junit.framework.Assert.*;

public class JavaScriptInputManagerAPITest {
	
	/**
	 * Check if the method for getting the version in the api still exists
	 */
	@Test
	public void getVersionExists()
	{
		assertTrue(TestReflectionUtils.methodExists(JavaScriptInputManager.class, "getVersion", null));
	}

}
