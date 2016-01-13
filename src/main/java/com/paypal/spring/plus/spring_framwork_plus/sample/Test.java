package com.paypal.spring.plus.spring_framwork_plus.sample;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.paypal.spring.plus.spring_framwork_plus.aop.Advice;
import com.paypal.spring.plus.spring_framwork_plus.aop.ProxyFactoryBean;
import com.paypal.spring.plus.spring_framwork_plus.bean.BeanFactory;
import com.paypal.spring.plus.spring_framwork_plus.bean.DefaultListableBeanFactory;
import com.paypal.spring.plus.spring_framwork_plus.configure.ConfigureParser;

public class Test {

	public static BeanFactory init()
	{
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		ConfigureParser cp = null;
		try {
			cp = new ConfigureParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cp.readIntoFactory(dlbf);
		return dlbf;
	}
	
	public static void main(String[] args) {
		
		ConfigureContext ac =  new ConfigureContext(new OfferImpl(null), new Person(), 1);
		
		try {
			Constructor c = String.class.getConstructor(String.class);
			Object i = c.newInstance("12");
			//System.err.println((String) i .toString());
			
			
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BeanFactory dlbf = Test.init();
		try {
			//System.out.println(((OfferImpl) dlbf.getBean("offerimpl")).integer);
			//System.out.println(((OfferImpl)((ConfigureContext) dlbf.getBean("configureContext")).offer).integer);
			((Person)((ProxyFactoryBean)dlbf.getBean("proxyBean")).bind()).say();
			((Person)((ProxyFactoryBean)dlbf.getBean("proxyBean")).bind()).wave();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
