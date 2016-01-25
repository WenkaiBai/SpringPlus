package com.paypal.spring.plus.spring_framwork_plus.sample;

import com.paypal.spring.plus.spring_framwork_plus.annotation.Inject;

public class AnnotationTestCase {

	@Inject
	public OfferImpl offer ;
	@Inject
	public Person person;
	
	public void say(){
		System.out.println(offer.hashCode()+":"+person.hashCode());
	}
}
