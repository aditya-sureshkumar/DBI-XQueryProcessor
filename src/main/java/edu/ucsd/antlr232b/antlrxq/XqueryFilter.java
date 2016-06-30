package edu.ucsd.antlr232b.antlrxq;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XqueryFilter {
    
    public String operand;
    public XqueryRelativePath relative_path_left;
    public XqueryRelativePath relative_path_right;
    public XqueryFilter filter_left;
    public XqueryFilter filter_right;
    
    public XqueryFilter(XqueryRelativePath input_relative_path)
    {
        operand = "";
        relative_path_left = input_relative_path;
        relative_path_right = null;
        filter_left = null;
        filter_right = null;
    }
    
    public XqueryFilter(XqueryFilter left,String input_operand)
    {
        operand = input_operand;
        relative_path_left = null;
        relative_path_right = null;
        filter_left = left;
        filter_right = null;
    }
    
    public XqueryFilter(XqueryRelativePath input_relative_path1,String input_operand,XqueryRelativePath input_relative_path2)
    {
        operand = input_operand;
        relative_path_left = input_relative_path1;
        relative_path_right = input_relative_path2;
        filter_left = null;
        filter_right = null;
    }
    
    public XqueryFilter(XqueryFilter input_filter_left ,XqueryFilter input_filter_right)
    {
        operand = "";
        relative_path_left = null;
        relative_path_right = null;
        filter_left = input_filter_left;
        filter_right = input_filter_right;
    }
    
    public XqueryFilter(XqueryFilter input_filter_left ,String input_operand,XqueryFilter input_filter_right)
    {
        operand = input_operand;
        relative_path_left = null;
        relative_path_right = null;
        filter_left = input_filter_left;
        filter_right = input_filter_right;
    }
    
    public XqueryFilter(XqueryFilter input_filter_left)
    {
        operand = "";
        relative_path_left = null;
        relative_path_right = null;
        filter_left = input_filter_left;
        filter_right = null;
    }
    
    public boolean value_compare(Node node1, Node node2)
    {
        if(node1.isEqualNode(node2))
            return true;
        else
            return false;
    }
    public boolean id_compare(Node node1,Node node2)
    {
        if(node1.isSameNode(node2))
            return true;
        else
            return false;
    }
    public boolean evaluate_filter(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node)
    {
        ArrayList<Node> filter_list=new ArrayList<Node>();
        ArrayList<Node> filter_list2=new ArrayList<Node>();
        ArrayList<Node> left_list=new ArrayList<Node>();
        ArrayList<Node> right_list=new ArrayList<Node>();
        
        if(this.operand.equals("") &&
           this.relative_path_left != null &&
           this.relative_path_right == null &&
           this.filter_left == null &&
           this.filter_right == null)
        {
            
            this.relative_path_left.evaluate_relativepath(evaluator_hashmap, node);
            filter_list = evaluator_hashmap.get(this.relative_path_left);
            if(filter_list.size() > 0)
                return true;
            return false;
        }
        
        else if(this.operand.equals("()") &&
                this.filter_left != null &&
                this.filter_right == null)
        {
            return this.filter_left.evaluate_filter(evaluator_hashmap, node);
        }
        
        
        else if(( this.operand.equals("=") || this.operand.equals("eq")) &&
                this.relative_path_left != null &&
                this.relative_path_right != null)
        {
            //System.out.println("Inside =");
            NodeList children = node.getChildNodes();
            for(int i=0;i<children.getLength();i++)
            {
                this.relative_path_left.evaluate_relativepath(evaluator_hashmap, children.item(i));
                left_list = evaluator_hashmap.get(this.relative_path_left);
                for(int j=0;j<left_list.size();j++)
                {
                    filter_list.add(left_list.get(j));
                }
                this.relative_path_right.evaluate_relativepath(evaluator_hashmap, children.item(i));
                right_list = evaluator_hashmap.get(this.relative_path_right);
                for(int j=0;j<right_list.size();j++)
                {
                    filter_list2.add(right_list.get(j));
                }
            }
            //System.out.println(filter_list);
            //System.out.println(filter_list2);
            if(filter_list.size() != filter_list2.size())
                return false;
            else
            {
                for(int i=0;i<filter_list.size();i++)
                {
                    if(!value_compare(filter_list.get(i),filter_list2.get(i)))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        
        
        else if(( this.operand.equals("==") || this.operand.equals("is")) &&
                this.relative_path_left != null &&
                this.relative_path_right != null)
        {
            NodeList children = node.getChildNodes();
            for(int i=0;i<children.getLength();i++)
            {
                this.relative_path_left.evaluate_relativepath(evaluator_hashmap, children.item(i));
                left_list = evaluator_hashmap.get(this.relative_path_left);
                for(int j=0;j<left_list.size();j++)
                {
                    filter_list.add(left_list.get(j));
                }
                this.relative_path_right.evaluate_relativepath(evaluator_hashmap, children.item(i));
                right_list = evaluator_hashmap.get(this.relative_path_right);
                for(int j=0;j<right_list.size();j++)
                {
                    filter_list2.add(right_list.get(j));
                }
            }
            if(filter_list.size() != filter_list2.size())
                return false;
            else
            {
                for(int i=0;i<filter_list.size();i++)
                {
                    if(!id_compare(filter_list.get(i),filter_list2.get(i)))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        
        else if(operand == "and")
        {
            return (this.filter_left.evaluate_filter(evaluator_hashmap, node) &&
                    this.filter_right.evaluate_filter(evaluator_hashmap, node));	
        }
        
        else if(operand == "or")
        {
            return (this.filter_left.evaluate_filter(evaluator_hashmap, node) ||
                    this.filter_right.evaluate_filter(evaluator_hashmap, node));	
        }
        
        else if(operand == "not")
        {
            return (!this.filter_left.evaluate_filter(evaluator_hashmap, node));	
        }
        return false;
    }
    
    
}