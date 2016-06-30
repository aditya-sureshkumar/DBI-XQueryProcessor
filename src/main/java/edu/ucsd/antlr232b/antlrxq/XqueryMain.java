package edu.ucsd.antlr232b.antlrxq;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.antlr.v4.runtime.misc.Utils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.makeText;
import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.makeElem;
import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.uniqueNodeList;
import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.retreive_variable;

public class XqueryMain
{
    public static ArrayList<Node> main_list;
    public XqueryVariable variable;
    public XqueryStringConstant stringconstant;
    public XqueryAbsolutePath absolute_path;
    public XqueryXpath xpath;
    public String operand;
    public XqueryMain xquery_left;
    public XqueryMain xquery_right;
    public XqueryRelativePath relative_path_left;
    public String left_string;
    public String right_string;
    public XqueryForClause forclause;
    public XqueryLetClause letclause;
    public XqueryWhereClause whereclause;
    public XqueryReturn returnclause;
    public XqueryJoin join_clause;
    
    public XqueryMain(XqueryJoin j)
    {
        join_clause=j;
    }
    
    public XqueryMain(String input_operand, XqueryVariable input_variable)
    {
        variable = input_variable;
        stringconstant = null;
        absolute_path = null;
        xpath = null;
        operand = input_operand;
        xquery_left = null;
        xquery_right = null;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(XqueryStringConstant input_stringconstant)
    {
        variable = null;
        stringconstant = input_stringconstant;
        absolute_path = null;
        xpath = null;
        operand = "";
        xquery_left = null;
        xquery_right = null;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(XqueryXpath input_xpath)
    {
        variable = null;
        stringconstant = null;
        absolute_path = null;
        xpath =  input_xpath;
        operand = "";
        xquery_left = null;
        xquery_right = null;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(XqueryAbsolutePath input_absolute_path)
    {
        variable = null;
        stringconstant = null;
        absolute_path = input_absolute_path;
        xpath = null;
        operand = "";
        xquery_left = null;
        xquery_right = null;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(String input_operand,XqueryMain input_xquery)
    {
        variable = null;
        stringconstant = null;
        absolute_path = null;
        xpath = null;
        operand = input_operand;
        xquery_left = input_xquery;
        xquery_right = null;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(XqueryMain left,String input_operand,XqueryMain right)
    {
        variable = null;
        stringconstant = null;
        absolute_path = null;
        xpath = null;
        operand = input_operand;
        xquery_left = left;
        xquery_right = right;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(XqueryMain input_xquery,String input_operand,XqueryRelativePath input_relative_path)
    {
        variable = null;
        stringconstant = null;
        absolute_path = null;
        xpath = null;
        operand = input_operand;
        xquery_left = input_xquery;
        xquery_right = null;
        relative_path_left = input_relative_path;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(String input_operand,String input_left_string,String input_right_string,XqueryMain input_xquery)
    {
        variable = null;
        stringconstant = null;
        absolute_path = null;
        xpath = null;
        operand = input_operand;
        xquery_left = input_xquery;
        xquery_right = null;
        relative_path_left = null;
        left_string= input_left_string;
        right_string = input_right_string;
        forclause = null;
        letclause = null;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public XqueryMain(XqueryForClause input_for,XqueryLetClause input_let,XqueryWhereClause input_where,XqueryReturn input_return)
    {
        variable = null;
        stringconstant = null;
        absolute_path = null;
        xpath = null;
        operand = "";
        xquery_left = null;
        xquery_right = null;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = input_for;
        letclause = input_let;
        whereclause = input_where;
        returnclause = input_return;
        join_clause = null;
    }
    
    public XqueryMain(XqueryForClause input_for,XqueryReturn input_return)
    {
        this(input_for,null,null,input_return);
    }
    
    public XqueryMain(XqueryForClause input_for,XqueryLetClause input_let,XqueryReturn input_return)
    {
        this(input_for,input_let,null,input_return);
    }
    
    public XqueryMain(XqueryForClause input_for,XqueryWhereClause input_where,XqueryReturn input_return)
    {
        this(input_for,null,input_where,input_return);
    }
    
    public XqueryMain(XqueryLetClause input_let,XqueryMain input_xquery)
    {
        variable = null;
        stringconstant = null;
        absolute_path = null;
        xpath = null;
        operand = "";
        xquery_left = input_xquery;
        xquery_right = null;
        relative_path_left = null;
        left_string= "";
        right_string = "";
        forclause = null;
        letclause = input_let;
        whereclause = null;
        returnclause = null;
        join_clause = null;
    }
    
    public ArrayList<Node> return_mainlist()
    {
        //for(int l=0;l<main_list.size();l++)
        //System.out.println(main_list.get(l).getTextContent());
        return main_list;
    }
    
    public void evaluate_xquery(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node) throws TransformerException, IOException
    {
        //File inputFile = new File(this.filename);
        ArrayList<Node> xquery_list = new ArrayList<Node>();
        ArrayList<Node> left_list = new ArrayList<Node>();
        ArrayList<Node> right_list = new ArrayList<Node>();
        Object obj = this;
        if(this.absolute_path != null)
        {
            try
            {
                this.absolute_path.evaluate_absolutepath(evaluator_hashmap);
            }
            catch (SAXException | IOException e)
            {
                e.printStackTrace();
            }
            ArrayList<Node> abs_path =(ArrayList<Node>) evaluator_hashmap.get(this.absolute_path);
            for(int i=0;i<abs_path.size();i++)
                xquery_list.add(abs_path.get(i));
            obj = this;
            evaluator_hashmap.put(obj, xquery_list);
            //System.out.println("Abs path output" + xquery_list);
        }
        
        else if(this.operand == "$")
        {
            ArrayList<Node> variable_list=retreive_variable(evaluator_hashmap, this.variable);
            obj = this;
            evaluator_hashmap.put(obj,variable_list);
        }
        else if(this.stringconstant != null)
        {
            //makeText(this.stringconstant.name);
            xquery_list.add(makeText(this.stringconstant.name));
            obj = this;
            evaluator_hashmap.put(obj, xquery_list);
        }
        
        else if(this.operand == "()")
        {
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            ArrayList<Node> xquery_left_list =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_left);
            for(int j=0;j<xquery_left_list.size();j++)
            {
                xquery_list.add((xquery_left_list).get(j));
            }
            obj = this;
            evaluator_hashmap.put(obj, xquery_list);
        }
        else if(this.operand == ",")
        {
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            left_list =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_left);
            if(left_list!=null)
            {
                for(int j=0;j<left_list.size();j++)
                {
                    xquery_list.add(left_list.get(j));
                }
            }
            this.xquery_right.evaluate_xquery(evaluator_hashmap, node);
            right_list =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_right);
            if(right_list!=null)
            {
                for(int j=0;j<right_list.size();j++)
                {
                    xquery_list.add(right_list.get(j));
                }
            }
            obj = this;
            evaluator_hashmap.put(obj, xquery_list);
            //System.out.println("LOL\t"+xquery_list);
        }
        else if(this.operand == "/")
        {
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            left_list =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_left);
            //System.out.println("left_list" + left_list);
            for(int i = 0; i < left_list.size();i++)
            {
                NodeList children = left_list.get(i).getChildNodes();
                for(int k=0;k<children.getLength();k++)
                {
                    
                    this.relative_path_left.evaluate_relativepath(evaluator_hashmap,children.item(k));
                    right_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_left);
                    for(int j=0;j<right_list.size();j++)
                    {
                        xquery_list.add(right_list.get(j));
                    }
                }
            }
            obj = this;
            ArrayList<Node> xquerylist = uniqueNodeList(xquery_list);
            evaluator_hashmap.put(obj, xquerylist);
        }
        else if(this.operand == "//")
        {
            Stack curstack = new Stack();
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            left_list =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_left);
            NodeList children2 = null;
            for(int i = 0; i < left_list.size();i++)
            {
                curstack.push(left_list.get(i));
                while(!curstack.isEmpty())
                {
                    Node root1 = (Node) curstack.pop();
                    this.relative_path_left.evaluate_relativepath(evaluator_hashmap,root1);
                    right_list =(ArrayList<Node>) evaluator_hashmap.get(this.relative_path_left);
                    for(int j=0;j<right_list.size();j++)
                    {
                        xquery_list.add(right_list.get(j));
                    }
                    children2 = root1.getChildNodes();
                    for(int k=0;k<children2.getLength();k++)
                    {
                        curstack.push(children2.item(k));
                    }
                }
            }
            obj = this;
            ArrayList<Node> xquerylist = uniqueNodeList(xquery_list);
            evaluator_hashmap.put(obj, xquerylist);	
        }
        else if(this.operand == "<>{}</>")
        {
            this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
            ArrayList<Node> xquery_left =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_left);
            //System.out.println("XQ left"+ xquery_left);
            xquery_list.add(makeElem(this.left_string,xquery_left));
            obj = this;
            evaluator_hashmap.put(obj, xquery_list);
        }
        else if(this.forclause != null)
        {
            System.out.println("Inside for clause xquery main");
            ArrayList<Node> for_clause_result = this.forclause.evaluate_forclause(evaluator_hashmap, node,
                                                                                  this.whereclause,this.letclause,this.returnclause);
            //for(int l=0;l<for_clause_result.size();l++)
            //System.out.println(for_clause_result.get(l).getTextContent());
            obj = this;
            System.out.println("size " + for_clause_result.size());
            evaluator_hashmap.put(obj, for_clause_result);
            main_list = new ArrayList<Node>();
            main_list.addAll(for_clause_result);
            //ArrayList<Node> temp = evaluator_hashmap.get(obj);
            //for(int l=0;l<main_list.size();l++)
            //System.out.println(main_list.get(l).getTextContent());
            
        }
        else if(this.letclause != null && this.xquery_left != null)
        {
        }
        else if(this.join_clause != null)
        {
            this.join_clause.evaluate_xqueryjoin(evaluator_hashmap, node);
            ArrayList<Node> join_result = this.join_clause.evaluate_xqueryjoin(evaluator_hashmap, node);
            obj = this;
            evaluator_hashmap.put(obj, join_result);
        }
    }
}
