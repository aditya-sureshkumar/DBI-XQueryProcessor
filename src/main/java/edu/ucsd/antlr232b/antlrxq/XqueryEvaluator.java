package edu.ucsd.antlr232b.antlrxq;


import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import edu.ucsd.antlr232b.antlrxq.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class XqueryEvaluator
{
    
    public static String prettyFormat(String input, int indent)
    {
        try
        {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // simple exception handling, please review it
        }
    }
    static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    static void print_tree(Node node,int number_of_tabs)
    {
        if(node.getChildNodes().getLength() == 0  && node.getNodeType()==Node.TEXT_NODE)
        {
            System.out.println("\t" + node.getNodeValue().toString());
        }
        else
        {
            System.out.println();
            for(int j=0;j<number_of_tabs;j++)
                System.out.print("\t");
            System.out.print("<" + node.getNodeName().toString());
            for(int k=0;k<node.getAttributes().getLength();k++)
            {
                System.out.print(" " + node.getAttributes().item(k).getNodeName()
                                 + "=" + "\"" + node.getAttributes().item(k).getNodeValue() + "\"");
            }
            System.out.print(">");
            
            NodeList child_list = node.getChildNodes();
            for(int i=0;i<child_list.getLength();i++)
            {
                print_tree(child_list.item(i),number_of_tabs+1);
            }
            for(int j=0;j<number_of_tabs;j++)
                System.out.print("\t");
            System.out.println("</" + node.getNodeName().toString() + ">");
        }
    }
    public static void main(String[] args) throws Exception
    {
        HashMap<Object, ArrayList<Node>> evaluator_hashmap = new HashMap<Object, ArrayList<Node>>();
        
        String queryasString = readFile("input.txt", StandardCharsets.UTF_8);
        
        //String queryasString="for $s in document(\"sample.xml\")/class/student let $y:=document(\"sample.xml\")/class return	$s,$y";
        //String queryasString="document(\"sample.xml\")//student/(firstname,lastname)";
        //String queryasString="for $a	in document(\"sample.xml\")/class/student, $b in $a/firstname, $c in $a/lastname where $b=\"dinkar\" return ($a,$b,$c)";
        
        ANTLRInputStream input = new ANTLRInputStream(queryasString);
        
        XqueryLexer lexer = new XqueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        XqueryParser parser = new XqueryParser(tokens);
        parser.removeErrorListeners();
        ParseTree tree = parser.r(); // begin parsing at rule 'r'
        System.out.println("Parse Tree for the query:\n");
        System.out.println(tree.toStringTree(parser));
        
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                                                        parser.getRuleNames()),tree);
        viewr.setScale(1);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
        
        
        
        
        ParseTreeWalker walker=new ParseTreeWalker();
        XqueryBuilder builder = new XqueryBuilder();
        walker.walk(builder,tree);
        
        XqueryMain xqm=(XqueryMain) builder.get_xquery_instance();
        
        
        long startTime = System.nanoTime();
        System.out.println("evaluator before");
        System.out.println("evaluator" + xqm);
        xqm.evaluate_xquery(evaluator_hashmap, null);
        System.out.println("evaluator" + xqm);
        System.out.println("evaluator after");
        
        xqm.return_mainlist();
        
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime);
        
        ArrayList<Node> xquery_list = evaluator_hashmap.get(xqm);
        System.out.print("\nResult nodes:\n"+xquery_list);
        //for(int i=0;i<xquery_list.size();i++)
        //System.out.println(xquery_list.get(i));
        System.out.print("\nNumber of nodes in Result :\t"+xquery_list.size());
        
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            
            e.printStackTrace();
        }
        
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("result");
        doc.appendChild(rootElement);
        
        
        for(int i=0;i<xquery_list.size();i++)
        {
            Node nw= (Node) doc.adoptNode(xquery_list.get(i));
            rootElement.appendChild(nw);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("intermediate_file.xml"));
        transformer.transform(source, result);
        
        String output = readFile("intermediate_file.xml", StandardCharsets.UTF_8);
        //System.out.println(prettyFormat(output, 4));
        PrintWriter out = new PrintWriter("output_file.xml");
        out.println(prettyFormat(output, 4));
        out.close();
        
        //for(int i=0;i<xquery_list.size();i++)
        //	print_tree(xquery_list.get(i),0);
        
        System.out.println("Running time is " + duration);
        
    }
}