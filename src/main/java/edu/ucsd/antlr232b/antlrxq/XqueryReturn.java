package edu.ucsd.antlr232b.antlrxq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;

public class XqueryReturn {
    public XqueryMain xquery;
    public XqueryReturn(XqueryMain input_xquery)
    {
        xquery = input_xquery;
    }
    public ArrayList<Node> evaluate_return(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node) throws TransformerException, IOException
    {
        this.xquery.evaluate_xquery(evaluator_hashmap, node);
        ArrayList<Node> xquery_left =(ArrayList<Node>) evaluator_hashmap.get(this.xquery);
        //System.out.println("return list");
        
        //for(int i=0;i<xquery_left.size();i++)
        //System.out.println(xquery_left.get(i).getTextContent());
        //System.out.println("RETURN\t"+xquery_left);
        return xquery_left;
    }
}
