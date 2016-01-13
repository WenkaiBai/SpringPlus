package com.paypal.spring.plus.spring_framwork_plus.sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler{

	private Object delegate;
	
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), 
								delegate.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Before "+method.getName()+", we do some thing first");
		Object result = null;
		result = method.invoke(delegate, args);
		System.out.println("After "+method.getName()+", we do some thing first");
		return result;
	}
}
