package edu.ucsd.antlr232b.antlrxq;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class DomParser 
{
	public static void main(String[] args)
	{

	      try 
	      {	
	    	 String Query="document(\"sample.xml\")/apple1[break]";
	         ANTLRInputStream input = new ANTLRInputStream(Query);
	         XqueryLexer lexer = new XqueryLexer(input);
	         CommonTokenStream tokens = new CommonTokenStream(lexer);
	         XqueryParser parser = new XqueryParser(tokens);
	         ParseTree tree = parser.ap();
	         
	         System.out.println(tree.toStringTree(parser));
	         System.out.println(tree.getChild(3).getText());
	         //System.out.println(tree.getParent().getText());
	         System.out.println(tree.getChild(0).getText());
	          
	         String file_name = tree.getText();
	         System.out.println("hello world");
	         String fname=tree.getChild(3).getText();
	         File inputFile = new File(fname);
	         
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("student");
	         System.out.println("----------------------------");
	         for (int temp = 0; temp < nList.getLength(); temp++) 
	         {
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :"+ nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) 
	            {
	               Element eElement = (Element) nNode;
	               System.out.println("Student roll no : " + eElement.getAttribute("rollno"));
	               System.out.println("First Name : "  + eElement.getElementsByTagName("firstname").item(0).getTextContent());
	               System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
	               System.out.println("Nick Name : " 
	               + eElement
	                  .getElementsByTagName("nickname")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Marks : " 
	               + eElement
	                  .getElementsByTagName("marks")
	                  .item(0)
	                  .getTextContent());
	            }
	         }
	      } 
	      catch (Exception e) 
	      {
	         e.printStackTrace();
	      }
	   }

}
