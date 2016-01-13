package com.paypal.spring.plus.spring_framwork_plus.bean;


import java.util.LinkedList;
import java.util.List;

public class BeanDefinition {

	public static final String SINGLETON = "singleton";
	public static final String PROTOTYPE = "prototype";
	
	private String beanId = null;
	private String beanClassName = null;
	private String scope = SINGLETON; // default is singleton as usual
	private boolean isSetter = false;
	private List<PropertyValue> propertyList = new LinkedList<PropertyValue>();
	
	public List<PropertyValue> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<PropertyValue> propertyList) {
		this.propertyList = propertyList;
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public boolean isSetter() {
		return this.isSetter;
	}
}
