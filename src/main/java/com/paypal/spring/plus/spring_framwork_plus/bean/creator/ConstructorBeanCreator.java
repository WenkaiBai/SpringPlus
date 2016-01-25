package com.paypal.spring.plus.spring_framwork_plus.bean.creator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.paypal.spring.plus.spring_framwork_plus.bean.BeanDefinition;
import com.paypal.spring.plus.spring_framwork_plus.bean.BeanFactory;
import com.paypal.spring.plus.spring_framwork_plus.bean.PropertyValue;

public class ConstructorBeanCreator implements BeanCreator{

	public <T> T createInstance(BeanDefinition beanDefinition)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		T object = (T) Class.forName(beanDefinition.getBeanClassName()).newInstance();
		return object;
	}

	public <T> T createInstance(BeanDefinition beanDefinition,
			BeanFactory beanFactory) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		if (beanDefinition.getPropertyList().isEmpty()) {
			T object = (T) Class.forName(beanDefinition.getBeanClassName()).newInstance();
			return object;
		} else {
			Class<?>[] parameterTypesArray = new Class<?>[beanDefinition.getPropertyList().size()]; 
			Object[] parameterArray = new Object[beanDefinition.getPropertyList().size()];
			
			for(int i = 0; i < beanDefinition.getPropertyList().size(); i++) {
				PropertyValue propertyValue = beanDefinition.getPropertyList().get(i);
				parameterTypesArray[i] = Class.forName(propertyValue.getTypeClassName());
				
				if(propertyValue.isLocal()) {
					//this is local class instance existing in factory
					parameterArray[i] = beanFactory.getBean(propertyValue.getTypeId());
				} else {
					//this is java system instance class
					Constructor insideConstructor = parameterTypesArray[i].getConstructor(String.class);
					try {
						parameterArray[i] = insideConstructor.newInstance(propertyValue.getValue());
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			Constructor constructor = Class.forName(beanDefinition.getBeanClassName())
				.getConstructor(parameterTypesArray);			
			T object = null;
			try {
				object = (T) constructor.newInstance(parameterArray);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {	
				e.printStackTrace();
			}
			return object;
		}
	}

}
