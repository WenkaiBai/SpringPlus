package com.paypal.spring.plus.spring_framwork_plus.bean.creator;

import com.paypal.spring.plus.spring_framwork_plus.bean.BeanDefinition;

public class BeanCreatorFactory {

	private BeanCreator constructorBeanCreator = new ConstructorBeanCreator();
	private BeanCreator setterBeanCreator = new SetterBeanCreator();
	
	private static class Loader {
		static BeanCreatorFactory INSTANCE = new BeanCreatorFactory();
	}
	
	private BeanCreatorFactory() {}
	
	public static BeanCreatorFactory getInstance() {
		return Loader.INSTANCE;
	}
	
	public BeanCreator findCreationFactory(BeanDefinition beanDefinition) {
		if (beanDefinition.isSetter()) {
			return this.setterBeanCreator;
		} else {
			return this.constructorBeanCreator;
		}
	}
}
