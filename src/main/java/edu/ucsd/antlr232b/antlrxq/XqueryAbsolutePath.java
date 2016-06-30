package edu.ucsd.antlr232b.antlrxq;

import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.uniqueNodeList;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.uniqueNodeList;

public class XqueryAbsolutePath {
    public String filename;
    public String slash;
    public XqueryRelativePath relative_path;
    
    public XqueryAbsolutePath(String input_filename,String input_slash,XqueryRelativePath input_relative_path)
    {
        filename = input_filename;
        slash = input_slash;
        relative_path = input_relative_path;
    }
    
    public boolean is_invalid_textnode(Node node)
    {
        return (node.getNodeType()==Node.TEXT_NODE &&
                (node.getNodeValue().toString().contains("\n") ||
                 node.getNodeValue().toString().contains("\t")||
                 node.getNodeValue().toString().contains("\r")));
    }
    
    public void evaluate_absolutepath(HashMap<Object, ArrayList<Node>> evaluator_hashmap) throws SAXException, IOException
    {
        File inputFile = new File(this.filename);
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc = null;
        ArrayList<Node> abs_path_list = new ArrayList<Node>();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        
        doc.getDocumentElement().normalize();
        
        Node rootx = doc.getDocumentElement();
        
        NodeList children=null;
        
        Stack curstack = new Stack();
        if(this.slash.equals("/"))
        {
            children = rootx.getChildNodes();
            ArrayList<Node> child_elements= new ArrayList<Node>();
            for(int i=0;i<children.getLength();i++)
            {
                
                child_elements.add(children.item(i));
            }
            for(int i=0;i<child_elements.size();i++)
            {
                relative_path.evaluate_relativepath(evaluator_hashmap,child_elements.get(i));
                ArrayList<Node> relative_path_list = (ArrayList<Node>) evaluator_hashmap.get(this.relative_path);
                for(int j=0;j<relative_path_list.size();j++)
                {
                    if(!is_invalid_textnode(relative_path_list.get(j)))
                        abs_path_list.add(relative_path_list.get(j));
                }
            }
        }
        else if(this.slash.equals("//"))
        {
            curstack.push(rootx);
            while(!curstack.isEmpty())
            {
                Node rootx1 =  (Node) curstack.pop();
                relative_path.evaluate_relativepath(evaluator_hashmap,rootx1);
                ArrayList<Node> relative_path_list = (ArrayList<Node>) evaluator_hashmap.get(this.relative_path);
                for(int j=0;j<relative_path_list.size();j++)
                {
                    if(!is_invalid_textnode(relative_path_list.get(j)))
                        abs_path_list.add(relative_path_list.get(j));
                }
                children = rootx1.getChildNodes();
                ArrayList<Node> child_elements= new ArrayList<Node>();
                for(int i=0;i<children.getLength();i++)
                {
                    child_elements.add(children.item(i));
                }
                for(int j=0;j<child_elements.size();j++)
                {
                    curstack.push(child_elements.get(j));
                }
            }
        }
        else
        {
            System.out.println("Absolute path slash error");
        }
        Object obj = this;
        //System.out.print("\nBEFOREApSlash: "+abs_path_list);
        abs_path_list=uniqueNodeList(abs_path_list);
        //System.out.print("\nAFTERApSlash: "+abs_path_list);
        evaluator_hashmap.put(obj, abs_path_list);
        //System.out.println(abs_path_list);
        
        // for(int i=0;i<abs_path_list.size();i++)
        // 	print_tree(abs_path_list.get(i),0);
        
    }
}
