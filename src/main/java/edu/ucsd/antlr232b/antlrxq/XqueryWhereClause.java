package edu.ucsd.antlr232b.antlrxq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;

public class XqueryWhereClause {
    public XqueryCondition condition;
    public XqueryWhereClause(XqueryCondition input_condition)
    {
        condition = input_condition;
    }
    public boolean evaluate_where(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node) throws TransformerException, IOException
    {
        return this.condition.evaluate_condition(evaluator_hashmap, node);
    }
}
