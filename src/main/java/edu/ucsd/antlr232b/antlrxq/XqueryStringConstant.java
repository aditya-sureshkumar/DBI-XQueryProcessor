package edu.ucsd.antlr232b.antlrxq;

public class XqueryStringConstant {
    public String name;
    
    public XqueryStringConstant(String input_name)
    {
        name = input_name;
        name = name.replace("\"", "");
    }
}
