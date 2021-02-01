package de.DiscordBOT;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//TODO Read XML file to check for user settings (introURL, etc.)
public class XMLReader {
	public XMLReader() {
		System.out.println("Reading XML data");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("resources/users.xml");
			
			NodeList users = doc.getElementsByTagName("user");
			System.out.println(users.getLength());
			
			
		} catch(ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
