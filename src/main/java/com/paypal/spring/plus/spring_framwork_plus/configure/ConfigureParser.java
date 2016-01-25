package com.paypal.spring.plus.spring_framwork_plus.configure;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.paypal.spring.plus.spring_framwork_plus.bean.BeanDefinition;
import com.paypal.spring.plus.spring_framwork_plus.bean.DefaultListableBeanFactory;
import com.paypal.spring.plus.spring_framwork_plus.bean.PropertyValue;


public class ConfigureParser {
	private Document configureDocument = null;
	private String configureFilePath = "src//configure.xml";
	private NodeList beanNodeList = null;
	
	
	public ConfigureParser() throws ParserConfigurationException, SAXException, IOException {
		// step 1:获得DOM解析器工厂
        // 工厂的作用是创建具体的解析器
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // step 2：获得具体的dom解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        // step 3:解析一个xml文档，获得Document对象（根节点）
        // 此文档放在项目目录下即可
        this.configureDocument = db.parse(new File(configureFilePath));
        
        beanNodeList = this.configureDocument.getElementsByTagName(XMLProperty.BEAN);
	}
	
	public Document getDocument() {
		return this.configureDocument;
	}
	
	public void readIntoFactory(DefaultListableBeanFactory beanFactory) {
		for (int i = 0 ; i < this.beanNodeList.getLength(); i++) {
			Element currentBean = (Element) this.beanNodeList.item(i);
			BeanDefinition beanDefinition = new BeanDefinition();
			
			beanDefinition.setBeanId(currentBean.getAttribute(XMLProperty.BEANID));
			beanDefinition.setBeanClassName(currentBean.getAttribute(XMLProperty.BEANCLASS));
			if (currentBean.hasAttribute(XMLProperty.BEANSCOPE)) {
				beanDefinition.setScope(currentBean.getAttribute(XMLProperty.BEANSCOPE));
			}
			//read property
			NodeList propertyNodes = currentBean.getElementsByTagName(XMLProperty.PROPERTY);
			for (int j = 0 ; j < propertyNodes.getLength(); j++) {
				Element currentNode = (Element) propertyNodes.item(j);
				String id = currentNode.getAttribute(XMLProperty.BEANID);
				Element valueNode = (Element) currentNode.getElementsByTagName(XMLProperty.VALUE).item(0);
				String valueId = valueNode.getAttribute(XMLProperty.REL);
				String valueClass = valueNode.getAttribute(XMLProperty.BEANCLASS);
				String value = valueNode.getTextContent();
				
				PropertyValue propertyValue = new PropertyValue(valueId, valueClass, value);

				if ((valueClass == null || valueClass.trim().isEmpty()) &&
							!beanFactory.getBeanDefinitionMap().containsKey(valueId)) {
					System.err.println("xml fail: there are no bean's id is "+valueId);
					return;
				} else if (valueClass == null || valueClass.trim().isEmpty()) {
						propertyValue.setTypeClassName(
								beanFactory.getBeanDefinitionMap().get(valueId).getBeanClassName());
				} else if ("java.lang.Object".equals(valueClass) && 
						beanFactory.getBeanDefinitionMap().containsKey(valueId)) {
					//propertyValue.setTypeClassName(
							//beanFactory.getBeanDefinitionMap().get(valueId).getBeanClassName());
				} else {
					/** this instance's class is not customized */
					propertyValue.setLocal(false);
				}
				beanDefinition.getPropertyList().add(propertyValue);	
			}
			
			beanFactory.getBeanDefinitionMap().put(beanDefinition.getBeanId(), beanDefinition);
		}
	}

}
