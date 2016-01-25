package com.paypal.spring.plus.spring_framwork_plus.bean;

public class PropertyValue {

	private String typeId;
	private String typeClassName;
	private String value;
	private boolean isLocal = true;
	
	public PropertyValue(String id, String className, String value) {
		this.typeClassName = className;
		this.typeId = id;
		this.value = value;
	}

	public boolean isLocal() {
		return isLocal;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeClassName() {
		return typeClassName;
	}

	public void setTypeClassName(String typeClassName) {
		this.typeClassName = typeClassName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
