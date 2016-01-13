package com.paypal.spring.plus.spring_framwork_plus.sample;

public class OfferImpl implements IOffer{

	public Integer integer;
	
	public OfferImpl(Integer i) {
		this.integer = i;
	}
	
	public void postOffer() {
		System.out.println("posting offer");	
	}

	public void modifyOffer() {
		System.out.println("modifying offer");
	}

	public static void main(String[] args) {
		OfferImpl o = (OfferImpl) (new CglibProxyFactory().bind(new OfferImpl(1)));
		o.postOffer();
		o.modifyOffer();
	}
}
