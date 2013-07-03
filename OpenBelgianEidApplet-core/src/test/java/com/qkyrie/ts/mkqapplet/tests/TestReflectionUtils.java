package com.qkyrie.ts.mkqapplet.tests;

import java.lang.reflect.Method;

public class TestReflectionUtils {

	
	public static boolean methodExists(Class<?> clazz, String methodName, Class<?>... parameterTypes)
	{
		Method m = null;
		try {
			m = clazz.getMethod(methodName, parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (m != null);
	}
	
}
