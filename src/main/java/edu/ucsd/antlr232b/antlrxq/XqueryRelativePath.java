package edu.ucsd.antlr232b.antlrxq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.uniqueNodeList;

public class XqueryRelativePath {
    public String token;
    public XqueryRelativePath relative_path_left;
    public XqueryRelativePath relative_path_right;
    public String slash;
    public XqueryFilter filter;
    
    public XqueryRelativePath(String input_token)
    {
        token = input_token;
        relative_path_left = null;
        relative_path_right = null;
        slash = "";
        filter = null;
    }
    
    public XqueryRelativePath(String input_token,XqueryRelativePath input_relative_path)
    {
        token = input_token;
        relative_path_left = input_relative_path;
        relative_path_right = null;
        slash = "";
        filter = null;
    }
    
    public XqueryRelativePath(XqueryRelativePath input_relative_path)
    {
        token = "";
        relative_path_left = input_relative_path;
        relative_path_right = null;
        slash = "";
        filter = null;
    }
    
    public XqueryRelativePath(XqueryRelativePath input_relative_path1, String input_slash, XqueryRelativePath input_relative_path2)
    {
        token = "";
        relative_path_left = input_relative_path1;
        relative_path_right = input_relative_path2;
        slash = input_slash;
        filter = null;
        //System.out.println("hi" + slash);
    }
    
    public XqueryRelativePath(XqueryRelativePath input_relative_path1,XqueryRelativePath input_relative_path2)
    {
        token = "";
        relative_path_left = input_relative_path1;
        relative_path_right = input_relative_path2;
        slash = "";
        filter = null;
    }
    
    public XqueryRelativePath(XqueryRelativePath input_relative_path,XqueryFilter input_filter)
    {
        token = "";
        relative_path_left = input_relative_path;
        relative_path_right = null;
        slash = "";
        filter = input_filter;
    }
    
    public boolean is_invalid_textnode(Node node)
    {
        return (node.getNodeType()==Node.TEXT_NODE &&
                (node.getNodeValue().toString().contains("\n") ||
                 node.getNodeValue().toString().contains("\t")||
                 node.getNodeValue().toString().contains("\r")));
    }
    
    public void evaluate_relativepath(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node)
    {
        Object obj = this;
        Stack curstack = new Stack();
        ArrayList<Node> relative_path_list = new ArrayList<Node>();
        ArrayList<Node> left_list = new ArrayList<Node>();
        ArrayList<Node> right_list = new ArrayList<Node>();
        
        if(this.token.equals("."))
        {
            if(!is_invalid_textnode(node))
                relative_path_list.add(node.getParentNode());
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.token.equals("*"))
        {
            if(!is_invalid_textnode(node))
                relative_path_list.add(node);
            
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.token.equals(".."))
        {
            if(!is_invalid_textnode(node))
                relative_path_list.add(node.getParentNode().getParentNode());
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.token.equals("text()"))
        {
            if(node.getNodeType()==Node.TEXT_NODE)
            {
                if(!is_invalid_textnode(node))
                {
                    //System.out.println("TEXTNODE CONTET: "+node.getTextContent());
                    //node.setTextContent(node.getTextContent().replace(" ",""));
                    //node.setTextContent(node.getTextContent().replace(".",""));
                    //node.setTextContent(node.getTextContent().replace(",",""));
                    
                    //node.setTextContent(node.getTextContent().replace("!",""));
                    //System.out.println("AFTERTEXTNODE CONTET: "+node.getTextContent());
                    relative_path_list.add(node);
                }
                
            }
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
            
        }
        
        
        else if( !this.token.equals("") && this.token.charAt(0) == '@')
        {
            NamedNodeMap dummymap = node.getAttributes();
            if(dummymap!=null)
            {
                if(dummymap.getNamedItem((this.token.substring(1,this.token.length()))) != null)
                {
                    if(!is_invalid_textnode(node))
                        relative_path_list.add(node);
                }
            }
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
            
        }
        
        else if(this.token.equals(node.getNodeName()))
        {
            if(!is_invalid_textnode(node))
                relative_path_list.add(node);
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.token.equals("()"))
        {
            this.relative_path_left.evaluate_relativepath(evaluator_hashmap, node);
            ArrayList<Node> rel_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_left);
            for(int j=0;j<rel_list.size();j++)
            {
                if(!is_invalid_textnode(node))
                    relative_path_list.add(rel_list.get(j));
            }
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.slash.equals("/"))
        {
            this.relative_path_left.evaluate_relativepath(evaluator_hashmap, node);
            left_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_left);
            for(int i = 0; i < left_list.size();i++)
            {
                NodeList children = left_list.get(i).getChildNodes();
                for(int k=0;k<children.getLength();k++)
                {
                    
                    this.relative_path_right.evaluate_relativepath(evaluator_hashmap,children.item(k));
                    right_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_right);
                    for(int j=0;j<right_list.size();j++)
                    {
                        if(!is_invalid_textnode(node))
                            relative_path_list.add(right_list.get(j));
                    }
                }
            }
            //System.out.print("\nBEFORErpSlash: "+relative_path_list);
            relative_path_list=uniqueNodeList(relative_path_list);
            //System.out.print("\nAFTERrpSlash: "+relative_path_list);
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.slash.equals("//"))
        {
            this.relative_path_left.evaluate_relativepath(evaluator_hashmap, node);
            left_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_left);
            NodeList children2 = null;
            for(int i = 0; i < left_list.size();i++)
            {
                curstack.push(left_list.get(i));
                while(!curstack.isEmpty())
                {
                    Node root1 = (Node) curstack.pop();
                    this.relative_path_right.evaluate_relativepath(evaluator_hashmap,root1);
                    right_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_right);
                    for(int j=0;j<right_list.size();j++)
                    {
                        if(!is_invalid_textnode(node))
                            relative_path_list.add(right_list.get(j));
                    }
                    children2 = root1.getChildNodes();
                    for(int k=0;k<children2.getLength();k++)
                    {
                        curstack.push(children2.item(k));
                    }
                }
            }
            //System.out.print("\nBEFORErpDOUBLESlash: "+relative_path_list);
            relative_path_list=uniqueNodeList(relative_path_list);
            //System.out.print("\nAFTERrpDOUBLESlash: "+relative_path_list);
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.filter != null)
        {
            this.relative_path_left.evaluate_relativepath(evaluator_hashmap, node);
            left_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_left);
            for(int i=0;i<left_list.size();i++)
            {
                
                boolean ans = this.filter.evaluate_filter(evaluator_hashmap,left_list.get(i));
                if(ans)
                    relative_path_list.add(left_list.get(i));
            }
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        
        else if(this.slash.equals(","))
        {
            this.relative_path_left.evaluate_relativepath(evaluator_hashmap, node);
            left_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_left);
            for(int j=0;j<left_list.size();j++)
            {
                //System.out.println("left rp1 " + relative_path_list);
                if(!is_invalid_textnode(node))
                    relative_path_list.add(left_list.get(j));
                //System.out.println("left rp " + relative_path_list);
            }
            this.relative_path_right.evaluate_relativepath(evaluator_hashmap, node);
            right_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_right);
            
            for(int j=0;j<right_list.size();j++)
            {
                //System.out.println("right rp1 " + relative_path_list);
                if(!is_invalid_textnode(node))
                    relative_path_list.add(right_list.get(j));
                //System.out.println("right rp " + relative_path_list);
            }
            
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
        else
        {
            
            obj = this;
            evaluator_hashmap.put(obj, relative_path_list);
        }
        
    }
    
}
