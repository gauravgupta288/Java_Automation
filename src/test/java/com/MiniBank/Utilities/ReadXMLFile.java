package com.MiniBank.Utilities;

import java.io.File;
import java.util.HashMap;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class ReadXMLFile {
	
	private static final String FILENAME = "src/test/java/com/MiniBank/PageObject/BasePage.xml";

	
	@Test
	public HashMap<String, String> parseXML() {
		HashMap<String, String> hMap = new  HashMap<String, String>();
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
	          // parse XML file
	          DocumentBuilder db = dbf.newDocumentBuilder();
	          Document doc = db.parse(new File(FILENAME));
	          doc.getDocumentElement().normalize();
	          // get <staff>
	          NodeList list = doc.getElementsByTagName("Element");
	          
	          for (int temp = 0; temp < list.getLength(); temp++) {
	              Node node = list.item(temp);
	                  Element element = (Element) node;
	                  NodeList param = element.getElementsByTagName("param");
	                  for (int count = 0; count < param.getLength(); count++) {
	                      Node node1 = param.item(count);
	                      if (node1.getNodeType() == node1.ELEMENT_NODE) {
	                         Element car = (Element) node1;
	                         hMap.put(element.getAttribute("name"), car.getAttribute("value"));
	                      }
	                   }
	          }

	      } catch (Exception e) {
	          e.printStackTrace();
	      }
		return hMap;
	}
}
