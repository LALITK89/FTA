package D_RND;
import org.w3c.dom.*;

import A_CommonUtilityclasses.Utility_Class;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class UpdateTestngXML 
{
	 public void updateXML() 
	 {
	        try {
	            // Path to the existing testng.xml file
	            File testngXmlFile = new File("testng.xml");

	            // Create a Document Builder Factory and Document Builder
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();

	            // Parse the testng.xml file to create a Document object
	            Document document = builder.parse(testngXmlFile);

	            // Get the root element (suite)
	            Element root = document.getDocumentElement();

	            // Get all the <test> elements
	            NodeList testList = root.getElementsByTagName("test");

	            // Iterate through the <test> elements
	            for (int i = 0; i < testList.getLength(); i++) 
	            {
	              Element testElement = (Element) testList.item(i);

	                // Get the <groups> element
	               NodeList groupsList = testElement.getElementsByTagName("groups");
	               for (int j = 0; j < groupsList.getLength(); j++) 
	               {
	                 Element groupsElement = (Element) groupsList.item(j);

	                    // Get the <run> element
	                   NodeList runList = groupsElement.getElementsByTagName("run");
	                   for (int k = 0; k < runList.getLength(); k++) 
	                   {
	                     Element runElement = (Element) runList.item(k);

	                        // Find the <include> element with the old group name
	                        NodeList includeList = runElement.getElementsByTagName("include");
	                        for (int l = 0; l < includeList.getLength(); l++) 
	                        {
	                            Element includeElement = (Element) includeList.item(l);
	                            
	                               // Update the group name to the new value
	                                Utility_Class.configFile();
	                                includeElement.setAttribute("name", Utility_Class.propobj.getProperty("GroupName"));
	                            }
	                        }
	                    }
	                }
	            

	            // Write the updated document back to the file
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.transform(new DOMSource(document), new StreamResult(testngXmlFile));
	            System.out.println("Testng.xml has been updated.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public static void main(String[]args)
	 {
		 UpdateTestngXML obj = new UpdateTestngXML();
		 obj.updateXML();
	 }
}
