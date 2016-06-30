package edu.ucsd.antlr232b.antlrxq;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import edu.ucsd.antlr232b.antlrxq.*;

public class HelloRunner 
{
	public static void main(String[] args) throws Exception
	{
		
		String queryasString="document(\"dir/file.c\")//w";
		ANTLRInputStream input = new ANTLRInputStream(queryasString);
		
		XqueryLexer lexer = new XqueryLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		XqueryParser parser = new XqueryParser(tokens);
		parser.removeErrorListeners();
		ParseTree tree = parser.ap(); // begin parsing at rule 'r'
		ParseTreeWalker walker=new ParseTreeWalker();
		//walker.walk(new XqueryWalker(),tree);
		//System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		
		
	}
}