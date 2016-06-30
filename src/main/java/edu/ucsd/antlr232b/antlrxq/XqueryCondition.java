package edu.ucsd.antlr232b.antlrxq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XqueryCondition {
    public XqueryMain xquery_left;
    public XqueryMain xquery_right;
    public String operand;
    public XqueryCondition condition_left;
    public XqueryCondition condition_right;
    public List<XqueryVariable> variable_list;
    public List<XqueryMain> xquery_list;
    
    public XqueryCondition(XqueryMain input_left,String input_operand,XqueryMain input_right)
    {
        xquery_left = input_left;
        xquery_right = input_right;
        operand = input_operand;
        condition_left = null;
        condition_right = null;
        variable_list = new ArrayList<XqueryVariable>();
        xquery_list = new ArrayList<XqueryMain>();
        //System.out.println("Inside constructor2");
        
    }
    
    public XqueryCondition(String input_operand,XqueryMain input_xquery)
    {
        xquery_left = input_xquery;
        xquery_right = null;
        operand = input_operand;
        condition_left = null;
        condition_right = null;
        variable_list = new ArrayList<XqueryVariable>();
        xquery_list = new ArrayList<XqueryMain>();
        //System.out.println("Inside constructor3");
    }
    
    public XqueryCondition(String input_operand,List<XqueryVariable> input_variable_list,
                           List<XqueryMain> input_xquery_list,XqueryCondition input_condition)
    {
        xquery_left = null;
        xquery_right = null;
        operand = input_operand;
        condition_left = input_condition;
        condition_right = null;
        variable_list = new ArrayList<XqueryVariable>(input_variable_list);
        xquery_list = new ArrayList<XqueryMain>(input_xquery_list);
        //System.out.println("Inside constructor4");
        //System.out.println("Varlist:	"+variable_list);
        //System.out.println("XQ_list:	"+xquery_list);
    }
    
    public XqueryCondition(String input_operand,XqueryCondition input_condition)
    {
        xquery_left = null;
        xquery_right = null;
        operand = input_operand;
        condition_left = input_condition;
        condition_right = null;
        variable_list = new ArrayList<XqueryVariable>();
        xquery_list = new ArrayList<XqueryMain>();
        //System.out.println("Inside constructor" + input_condition + "  " + this.operand);
        //System.out.println("THISthis \t" + this.condition_left);
    }
    
    public XqueryCondition(XqueryCondition input_left_condition,String input_operand,XqueryCondition input_right_condition)
    {
        xquery_left = null;
        xquery_right = null;
        operand = input_operand;
        condition_left = input_left_condition;
        condition_right = input_right_condition;
        variable_list = new ArrayList<XqueryVariable>();
        xquery_list = new ArrayList<XqueryMain>();
        //System.out.println("Inside constructor5");
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
    
    public boolean calculate_condition(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node,
                                       ArrayList<ArrayList<Node>> conditionclause_list,int i) throws TransformerException, IOException
    {
        if(i == this.xquery_list.size())
        {
            return this.condition_left.evaluate_condition(evaluator_hashmap, node);
        }
        else
        {
            this.xquery_list.get(i).evaluate_xquery(evaluator_hashmap, node);
            ArrayList<Node> xquery_result = evaluator_hashmap.get(this.xquery_list.get(i));
            conditionclause_list.add(xquery_result);
            for(int j=0;j<conditionclause_list.get(i).size();j++)
            {
                ArrayList<Node> temp = new ArrayList<Node>();
                temp.add(conditionclause_list.get(i).get(j));
                evaluator_hashmap.put(this.variable_list.get(i), temp);
                if(calculate_condition(evaluator_hashmap,node,conditionclause_list,i+1) == true)
                    return true;
            }
            conditionclause_list.remove(i);
        }
        return false;
    }
    public boolean evaluate_condition(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node) throws TransformerException, IOException
    {
        ArrayList<Node> condition_list=new ArrayList<Node>();
        ArrayList<Node> condition_list2=new ArrayList<Node>();
        ArrayList<Node> left_list=new ArrayList<Node>();
        ArrayList<Node> right_list=new ArrayList<Node>();
        
        if(this.operand.equals("()") &&
           this.xquery_left != null)
        {
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            condition_list = evaluator_hashmap.get(this.xquery_left);
            if(condition_list.size() > 0)
                return false;
            return true;
        }
        
        else if(this.operand.equals("()") &&
                this.condition_left != null &&
                this.condition_right == null)
        {
            //System.out.println("Inside bracket open");
            return this.condition_left.evaluate_condition(evaluator_hashmap, node);
        }
        
        
        else if(( this.operand.equals("=") || this.operand.equals("eq")) &&
                this.xquery_left != null &&
                this.xquery_right != null)
        {
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            left_list = evaluator_hashmap.get(this.xquery_left);
            if(left_list!=null)
            {
                for(int j=0;j<left_list.size();j++)
                {
                    condition_list.add(left_list.get(j));
                }
            }
            this.xquery_right.evaluate_xquery(evaluator_hashmap,node);
            right_list = evaluator_hashmap.get(this.xquery_right);
            
            if(right_list!=null)
            {
                for(int j=0;j<right_list.size();j++)
                {
                    condition_list2.add(right_list.get(j));
                }
            }
            for(int i=0;i<condition_list.size();i++)
            {
                for(int j=0;j<condition_list2.size();j++)
                {
                    //System.out.println("value compare" + condition_list.get(i).getTextContent() +"\t" + condition_list2.get(j).getTextContent() );
                    if(value_compare(condition_list.get(i),condition_list2.get(j)))
                    {
                        //ystem.out.println("value compare" + condition_list.get(i).getTextContent() +"\t" + condition_list2.get(j).getTextContent() );
                        
                        return true;
                    }
                }
            }
            return false;
        }
        
        
        else if(( this.operand.equals("==") || this.operand.equals("is")) &&
                this.xquery_left != null &&
                this.xquery_right != null)
        {
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            left_list = evaluator_hashmap.get(this.xquery_left);
            if(left_list!=null)
            {
                for(int j=0;j<left_list.size();j++)
                {
                    condition_list.add(left_list.get(j));
                }
            }
            this.xquery_right.evaluate_xquery(evaluator_hashmap, node);
            right_list = evaluator_hashmap.get(this.xquery_right);
            if(right_list!=null)
            {
                for(int j=0;j<right_list.size();j++)
                {
                    condition_list2.add(right_list.get(j));
                }
            }
            //System.out.print("\nCondition list 1 : "+ condition_list);
            //System.out.print("\nCondition list 2 : "+ condition_list2);
            if(condition_list.size() != condition_list2.size())
                return false;
            else
            {
                for(int i=0;i<condition_list.size();i++)
                {
                    //System.out.print("\n node1 : "+ condition_list.get(i).getTextContent());
                    //System.out.print("\n node2 : "+ condition_list2.get(i).getTextContent());
                    
                    if(!id_compare(condition_list.get(i),condition_list2.get(i)))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        
        else if(operand == "and")
        {
            return (this.condition_left.evaluate_condition(evaluator_hashmap, node) &&
                    this.condition_right.evaluate_condition(evaluator_hashmap, node));	
        }
        
        else if(operand == "or")
        {
            return (this.condition_left.evaluate_condition(evaluator_hashmap, node) ||
                    this.condition_right.evaluate_condition(evaluator_hashmap, node));	
        }
        
        else if(operand == "not")
        {
            //System.out.println("Inside not");
            //System.out.println("left here: "+ this.condition_left);
            //System.out.println("NOT output" + this.condition_left.evaluate_condition(evaluator_hashmap, node));
            return (!this.condition_left.evaluate_condition(evaluator_hashmap, node));	
        }
        else if(operand == "some")
        {
            ArrayList<ArrayList<Node>> conditionclause_list = new ArrayList<ArrayList<Node>>(xquery_list.size());
            return calculate_condition(evaluator_hashmap,node,conditionclause_list,0);
        }
        return false;
    }
    
}
