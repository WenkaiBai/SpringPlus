package com.paypal.spring.plus.spring_framwork_plus.sample;

public class ConfigureContext {


	public Object offer ;
	public Person person;
	public Integer integer;
	public ConfigureContext(Object o, Person p, Integer in){ 
		this.offer = o;
		this.person = (Person) p;
		this.integer = in;
		i++; 
	}
	
	public static Integer i = 0;
	
	public ConfigureContext(int it)
	{
		i = it;
		System.out.println(i);
	}
}
