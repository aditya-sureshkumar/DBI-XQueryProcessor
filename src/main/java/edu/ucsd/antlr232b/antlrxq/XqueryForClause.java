package edu.ucsd.antlr232b.antlrxq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;
import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.uniqueNodeList;

public class XqueryForClause {
    
    public List<XqueryVariable> variable_list;
    public List<XqueryMain> xquery_list;
    
    public XqueryForClause(List<XqueryVariable> input_variable_list,List<XqueryMain> input_xquery_list)
    {
        variable_list = new ArrayList<XqueryVariable>(input_variable_list);
        xquery_list = new ArrayList<XqueryMain>(input_xquery_list);
        
    }
    
    public void calculate_for(HashMap<Object, ArrayList<Node>> evaluator_hashmap, Node node, XqueryWhereClause input_where,
                              XqueryLetClause input_let, XqueryReturn input_return, ArrayList<ArrayList<Node>> forclause_list,ArrayList<Node> final_list,int i) throws TransformerException, IOException
    {
        
        if(i == this.xquery_list.size())
        {
            boolean where_result = true;
            if(input_let != null)
                input_let.evaluate_let(evaluator_hashmap,input_where,input_return,final_list,node);
            else
            {
                if (input_where != null)
                {
                    where_result = input_where.evaluate_where(evaluator_hashmap,node);
                    //System.out.println("Inside where");
                }
                if(where_result == true)
                {
                    
                    ArrayList<Node> returnclause_list = input_return.evaluate_return(evaluator_hashmap, node);
                    //for(int l=0;l<returnclause_list.size();l++)
                    //System.out.println(returnclause_list.get(l).getTextContent());
                    for(int k=0;k<returnclause_list.size();k++)
                    {
                        final_list.add((Node)returnclause_list.get(k));
                    }
                }
            }
            
        }
        else
        {
            this.xquery_list.get(i).evaluate_xquery(evaluator_hashmap, node);
            ArrayList<Node> xquery_result = evaluator_hashmap.get(this.xquery_list.get(i));
            //System.out.println("adding"+xquery_result);
            forclause_list.add(xquery_result);
            for(int j=0;j<forclause_list.get(i).size();j++)
            {
                //System.out.println("i: " + i + "j: "+j + "len of for: " + forclause_list.size());
                //System.out.println("line2");
                ArrayList<Node> temp = new ArrayList<Node>();
                //System.out.println("line3");
                temp.add(forclause_list.get(i).get(j));
                //System.out.println("line4");
                evaluator_hashmap.put(this.variable_list.get(i), temp);
                //System.out.println("line5");
                calculate_for(evaluator_hashmap,node,input_where,input_let,input_return,forclause_list,final_list,i+1);
                //System.out.println("end1");
            }
            forclause_list.remove(i);
            //System.out.println("end2");
        }
    }
    
    public ArrayList<Node> evaluate_forclause(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node,
                                              XqueryWhereClause input_where,XqueryLetClause input_let,XqueryReturn input_return) throws TransformerException, IOException
    {
        ArrayList<ArrayList<Node>> forclause_list = new ArrayList<ArrayList<Node>>(xquery_list.size());
        ArrayList<XqueryVariable> result_list = new ArrayList<XqueryVariable>();
        ArrayList<Node> final_list = new ArrayList<Node>();
        
        this.calculate_for(evaluator_hashmap,node,input_where,input_let,input_return,forclause_list,final_list,0);
        //for(int l=0;l<final_list.size();l++)
        //System.out.println(final_list.get(l).getTextContent());
        //System.out.println("FOR OUTPUT " + final_list);
        ArrayList<Node> temp_list = new ArrayList<Node>(final_list);
        //System.out.println("GLOBAL LIST " + final_list);
        final_list=new ArrayList<Node>();
        
        
        //return uniqueNodeList(temp_list);
        return temp_list;
    }
    
    
}
