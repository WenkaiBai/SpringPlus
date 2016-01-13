package com.paypal.spring.plus.spring_framwork_plus.bean.creator;

import com.paypal.spring.plus.spring_framwork_plus.bean.BeanDefinition;
import com.paypal.spring.plus.spring_framwork_plus.bean.BeanFactory;

public interface BeanCreator {

	// Not used So far
	<T> T createInstance(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, ClassNotFoundException;

	<T> T createInstance(BeanDefinition beanDefinition, BeanFactory beanFactory) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException;

}
