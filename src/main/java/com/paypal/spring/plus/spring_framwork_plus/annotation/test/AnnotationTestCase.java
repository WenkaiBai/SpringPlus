package com.paypal.spring.plus.spring_framwork_plus.annotation.test;

import com.paypal.spring.plus.spring_framwork_plus.annotation.Inject;
import com.paypal.spring.plus.spring_framwork_plus.sample.OfferImpl;
import com.paypal.spring.plus.spring_framwork_plus.sample.Person;

public class AnnotationTestCase {

	@Inject
	public OfferImpl offer ;
	@Inject
	public Person person;
	
	public void say(){
		System.out.println(offer.hashCode()+":"+person.hashCode());
	}
}
