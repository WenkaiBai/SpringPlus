package com.paypal.spring.plus.spring_framwork_plus.sample;

import com.paypal.spring.plus.spring_framwork_plus.aop.MethodAfterAdvice;

public class AfterAdvice implements MethodAfterAdvice{

	public void execute() {
		System.out.println("After, we do some thing first");	
	}

}
