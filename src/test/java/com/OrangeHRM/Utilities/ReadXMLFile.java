package com.OrangeHRM.Utilities;

import java.io.File;
import java.util.HashMap;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class ReadXMLFile {
	
	public HashMap<String, String> parseXML(String filname) {
		HashMap<String, String> hMap = new  HashMap<>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
	          // parse XML file
	          DocumentBuilder db = dbf.newDocumentBuilder();
	          Document doc = db.parse(new File("Resources/"+filname));
	          doc.getDocumentElement().normalize();
	          // get <staff>
	          NodeList list = doc.getElementsByTagName("Element");
	          
	          for (int temp = 0; temp < list.getLength(); temp++) {
	              Node node = list.item(temp);
	                  Element element = (Element) node;
	                  NodeList param = element.getElementsByTagName("param");
	                  for (int count = 0; count < param.getLength(); count++) {
	                      Node node1 = param.item(count);
	                      if (node1.getNodeType() == Node.ELEMENT_NODE) {
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
