package com.paypal.spring.plus.spring_framwork_plus.bean;

public interface BeanFactory {

	//Object getBean(String name);
	
	<T> T getBean(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException;
	
	<T> T getBean(String name, Class<T> classType) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	
}
