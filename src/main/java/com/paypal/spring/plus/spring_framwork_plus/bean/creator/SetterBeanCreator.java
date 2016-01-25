package com.paypal.spring.plus.spring_framwork_plus.bean.creator;

import com.paypal.spring.plus.spring_framwork_plus.bean.BeanDefinition;
import com.paypal.spring.plus.spring_framwork_plus.bean.BeanFactory;

public class SetterBeanCreator implements BeanCreator{

	public <T> T createInstance(BeanDefinition beanDefinition)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		T object = (T) Class.forName(beanDefinition.getBeanClassName()).newInstance();
		return object;
	}

	public <T> T createInstance(BeanDefinition beanDefinition,
			BeanFactory beanFactory) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException {
		T object = (T) Class.forName(beanDefinition.getBeanClassName()).newInstance();
		return object;
	}

}
