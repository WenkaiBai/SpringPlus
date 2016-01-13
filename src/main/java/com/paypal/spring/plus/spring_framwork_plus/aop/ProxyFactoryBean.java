package com.paypal.spring.plus.spring_framwork_plus.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactoryBean implements MethodInterceptor{

	private Object target;
	private Advisor advisor;
	
	public ProxyFactoryBean(Object target, Advisor advisor) {
		this.target = target;
		this.advisor = advisor;
		
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public Object bind() {
		Enhancer hancer = new Enhancer();
		
		hancer.setSuperclass(target.getClass());
		
		hancer.setCallback(this);
		return hancer.create();
	}
	
	public Object intercept(Object arg0, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		Object result = null;
		if(this.advisor.getPointcut().getMappedMethodName().equals(
				method.getName())) {
			
			if(MethodAfterAdvice.class.isInstance(this.advisor.getAdvice())) {
				//After
				result = method.invoke(this.target, args);
				this.advisor.getAdvice().execute();
			}
			else if (MethodBeforeAdvice.class.isInstance(this.advisor.getAdvice())) {
				this.advisor.getAdvice().execute();
				result = method.invoke(this.target, args);	
			}
		}
		return result;
	}
	
	
}
