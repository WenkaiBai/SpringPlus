package com.paypal.spring.plus.spring_framwork_plus.aop;

public class MethodPointCut {

	private String mappedMethodName;
	
	public MethodPointCut(String method) {
		this.mappedMethodName = method;
	}
	
	public String getMappedMethodName() {
		return mappedMethodName;
	}
	public void setMappedMethodName(String mappedMethodName) {
		this.mappedMethodName = mappedMethodName;
	}
	
}
