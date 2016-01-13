package com.paypal.spring.plus.spring_framwork_plus.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AOPProxy implements MethodInterceptor{

	private Object delegate;
	
	public AOPProxy() {
		
	}
	
	public Object bind(Object delegate)
	{
		this.delegate = delegate;
		Enhancer hancer = new Enhancer();
		
		hancer.setSuperclass(delegate.getClass());
		
		hancer.setCallback(this);
		return hancer.create();
	}
	public Object intercept(Object arg0, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("Before "+method.getName()+", we do some thing first");
		Object result = null;
		result = method.invoke(delegate, args);
		System.out.println("After "+method.getName()+", we do some thing first");
		return result;
	}

}