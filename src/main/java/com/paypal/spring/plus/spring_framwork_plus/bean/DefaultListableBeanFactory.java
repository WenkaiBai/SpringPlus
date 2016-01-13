package com.paypal.spring.plus.spring_framwork_plus.bean;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.paypal.spring.plus.spring_framwork_plus.bean.creator.BeanCreatorFactory;

public class DefaultListableBeanFactory implements BeanFactory{


	/** Map of bean definition objects, keyed by bean name
	 *  Waiting for XML reader to fill it */
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
		
	/** Map of singleton bean objects, keyed by bean name*/
	private Map<String, Object> singletonNameMap = new ConcurrentHashMap<String, Object>();
	
	public DefaultListableBeanFactory() {
		
	}
	
	public Map<String, BeanDefinition> getBeanDefinitionMap() {
		return beanDefinitionMap;
	}

	public void setBeanDefinitionMap(Map<String, BeanDefinition> beanDefinitionMap) {
		this.beanDefinitionMap = beanDefinitionMap;
	}

	public <T> T getBean(String name) 
			throws InstantiationException, IllegalAccessException, 
			ClassNotFoundException, NoSuchMethodException, SecurityException {
		if(!beanDefinitionMap.containsKey(name)) {
			return null;
		}
		else {
			BeanDefinition beanDefinition = beanDefinitionMap.get(name);
			if (beanDefinition.getScope().toLowerCase().equals(BeanDefinition.SINGLETON)) {
				// deal with singleton object
				if(singletonNameMap.containsKey(name)) {
					return (T) singletonNameMap.get(name);
				}
				else {
					T newInstance = BeanCreatorFactory.getInstance().
							findCreationFactory(beanDefinition).createInstance(beanDefinition, this);
					singletonNameMap.put(name, newInstance);
					return newInstance;
				}
			}
			else if (beanDefinition.getScope().equals(BeanDefinition.PROTOTYPE)) {
				// deal with prototype object
				return BeanCreatorFactory.getInstance().findCreationFactory(beanDefinition).createInstance(beanDefinition, this);
			}
			else {
				// could throw exception in future
				return null;
			}
		}
	}

	/** Default scope of this bean is Singleton*/
	public <T> T getBean(String name, Class<T> classType)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		
		return null;
	}

	

}
