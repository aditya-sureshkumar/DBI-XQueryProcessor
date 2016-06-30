package edu.ucsd.antlr232b.antlrxq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XQueryUtils {
    
    public XQueryUtils()
    {}
    
    public static Node makeElem(String tagname, ArrayList<Node> node_list)
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try
        {
            docBuilder = docFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        
        Document doc = docBuilder.newDocument();
        //System.out.println("TAGNAME\t"+tagname);
        
        Node rootElement = doc.createElement(tagname);
        //System.out.println("CREATEDNODE"+rootElement);
        for(int i=0;i<node_list.size();i++)
        {
            Node firstDocImportedNode = doc.importNode(node_list.get(i), true);
            rootElement.appendChild(firstDocImportedNode);
        }
        return rootElement;
    }
    
    public static Node makeText(String value)
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try
        {
            docBuilder = docFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        Document doc = docBuilder.newDocument();
        Node text_node = doc.createTextNode(value);
        return text_node;
    }
    
    public static ArrayList<Node> uniqueNodeList(ArrayList<Node> node_list)
    {
        //System.out.print("\n\nIncoming list"+node_list);
        
        Set<Node> node_set = new HashSet<Node>(node_list);
        ArrayList<Node> final_list = new ArrayList<Node>(node_set);
        //System.out.print("\nUpdated list"+final_list+"\n\n");
        
        return final_list;
    }
    public static ArrayList<Node> retreive_variable(HashMap<Object, ArrayList<Node>> evaluator_hashmap,XqueryVariable xqv)
    {
        for (Object key : evaluator_hashmap.keySet())
        {
            XqueryVariable var = null;
            if (key instanceof XqueryVariable)
            {
                var = (XqueryVariable)key;
                if(xqv.name.equals(var.name))
                {
                    return evaluator_hashmap.get(var);
                }
            }
        }
        Object obj = xqv;
        ArrayList<Node> variable_list = new ArrayList<Node>();
        variable_list=evaluator_hashmap.get(obj);
        return variable_list;
    }
}
