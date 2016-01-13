package com.paypal.spring.plus.spring_framwork_plus.aop;

import com.paypal.spring.plus.spring_framwork_plus.sample.AfterAdvice;

public class Advisor {

	private Advice advice;
	private MethodPointCut pointcut;
	
	public Advisor(Object ad, MethodPointCut pointcut)
	{
		this.advice = (Advice) ad;
		this.pointcut = pointcut;
	}

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public MethodPointCut getPointcut() {
		return pointcut;
	}

	public void setPointcut(MethodPointCut pointcut) {
		this.pointcut = pointcut;
	}
}
