package chapter16;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jdk.internal.org.xml.sax.SAXException;

public class Question12 {

	public static void main(String[] args) throws ParserConfigurationException, org.xml.sax.SAXException, IOException{
		File fXmlFile = new File("C:\\Users\\Tmax\\git\\ctci\\CtCI_chap1\\src\\chapter16\\file.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		Question12 q12 = new Question12();
		System.out.println(q12.encode(doc.getDocumentElement()));
		
		
		

	}
	
	public String encode(Element xml) {
		//pre-defined map
		HashMap<String, Integer> map = new HashMap<>();
		int seq = 1;
		map.put("family", seq); seq++;
		map.put("person", seq); seq++;
		map.put("firstName", seq); seq++;
		map.put("lastName", seq); seq++;
		map.put("state", seq); seq++;
		
		//pasrsing
		StringBuilder sb = new StringBuilder();
		
		encode(xml, sb, map);
		
		return sb.toString();
		
	}

	private void encode(Node node, StringBuilder sb, HashMap<String, Integer> map) {
		String nodeName = node.getNodeName();
		int code;
		if (map.containsKey(nodeName)) {
			code = map.get(nodeName);
			encode(code, sb);
		}
		if (node.getNodeValue() != null) {
			encode(node.getNodeValue(), sb);
		}
		if (node.hasAttributes()) {
			NamedNodeMap nodemap = node.getAttributes();
			for (int i=0; i<nodemap.getLength(); i++) {
				Node item = nodemap.item(i);
				nodeName = item.getNodeName();
				code = map.get(nodeName);
				encode(code, sb);
				if (item.getNodeValue() != null) {
					encode(item.getNodeValue(), sb);
				}
			}
			encode("0", sb);
		}
		
		if (node.hasChildNodes()) {
			NodeList nodes = node.getChildNodes();
			for (int i=0; i<nodes.getLength(); i++) {
				encode(nodes.item(i),sb,map);
			}
			encode("0", sb);
		}
		//encode("0", sb);
	}
	
	
	//Á¦³Ê¸¯...
	private void encode(String val, StringBuilder sb) {
		sb.append(val);
		sb.append(" ");
	}
	
	private void encode(int val, StringBuilder sb) {
		sb.append(val);
		sb.append(" ");
	}
}
