package edu.ucsd.antlr232b.antlrxq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;

public class XqueryLetClause {
    public List<XqueryVariable> variable_list;
    public List<XqueryMain> xquery_list;
    
    public XqueryLetClause(List<XqueryVariable> input_variable_list,List<XqueryMain> input_xquery_list)
    {
        variable_list = new ArrayList<XqueryVariable>(input_variable_list);
        xquery_list = new ArrayList<XqueryMain>(input_xquery_list);
    }
    
    public void calculate_let(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node,XqueryWhereClause input_where,
                              XqueryReturn input_return,ArrayList<ArrayList<Node>> letclause_list,ArrayList<Node> final_list,int i) throws TransformerException, IOException
    {
        if(i == this.xquery_list.size())
        {
            boolean where_result = true;
            if (input_where != null)
            {
                where_result = input_where.evaluate_where(evaluator_hashmap,node);
                //System.out.println("Inside where");
            }
            if(where_result == true)
            {
                ArrayList<Node> returnclause_list = input_return.evaluate_return(evaluator_hashmap, node);
                //System.out.println("Size " + returnclause_list.size());
                for(int k=0;k<returnclause_list.size();k++)
                {
                    final_list.add((Node)returnclause_list.get(k));
                }
            }
        }
        else
        {
            this.xquery_list.get(i).evaluate_xquery(evaluator_hashmap, node);
            ArrayList<Node> xquery_result = evaluator_hashmap.get(this.xquery_list.get(i));
            //System.out.println("adding");
            letclause_list.add(xquery_result);
            for(int j=0;j<letclause_list.get(i).size();j++)
            {
                //System.out.println("i: " + i + "j: "+j + "len of for: " + forclause_list.size());
                //System.out.println("line2");
                ArrayList<Node> temp = new ArrayList<Node>();
                //System.out.println("line3");
                temp.add(letclause_list.get(i).get(j));
                //System.out.println("line4");
                evaluator_hashmap.put(this.variable_list.get(i), temp);
                //System.out.println("line5");
                calculate_let(evaluator_hashmap,node,input_where,input_return,letclause_list,final_list,i+1);
                //System.out.println("end1");
            }
            letclause_list.remove(i);
            //System.out.println("end2");
        }
    }
    
    public void evaluate_let(HashMap<Object, ArrayList<Node>> evaluator_hashmap,XqueryWhereClause input_where,
                             XqueryReturn input_return,ArrayList<Node> final_list,Node node) throws TransformerException, IOException
    {
        ArrayList<ArrayList<Node>> letclause_list = new ArrayList<ArrayList<Node>>(xquery_list.size());
        ArrayList<XqueryVariable> result_list = new ArrayList<XqueryVariable>();
        
        this.calculate_let(evaluator_hashmap,node,input_where,input_return,letclause_list,final_list,0);
        //System.out.println("LET OUTPUT " + final_list);
        ArrayList<Node> temp_list = new ArrayList<Node>(final_list);
        final_list=new ArrayList<Node>();
        //return temp_list;
    }	
}
