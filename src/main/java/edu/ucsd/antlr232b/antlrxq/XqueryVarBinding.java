package edu.ucsd.antlr232b.antlrxq;
public class XqueryVarBinding {
    
    public XqueryVariable var;
    public XqueryXpath xpath_var;
    XqueryVarBinding(XqueryVariable input_var,XqueryXpath input_xpath_var)
    {
        var = input_var;
        xpath_var = input_xpath_var;
        
    }	
}
