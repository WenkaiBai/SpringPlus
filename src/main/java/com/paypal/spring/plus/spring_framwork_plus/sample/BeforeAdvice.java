package com.paypal.spring.plus.spring_framwork_plus.sample;

import com.paypal.spring.plus.spring_framwork_plus.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice{

	public void execute() {
		System.out.println("Before, we do some thing first");
	}

	
}
