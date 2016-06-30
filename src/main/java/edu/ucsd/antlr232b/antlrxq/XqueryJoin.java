package edu.ucsd.antlr232b.antlrxq;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import static edu.ucsd.antlr232b.antlrxq.XQueryUtils.makeElem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XqueryJoin {

	public XqueryMain xquery_left;
	public XqueryMain xquery_right;
	public ArrayList<String> left_list;
	public ArrayList<String> right_list;
	
	XqueryJoin(XqueryMain xql,XqueryMain xqr,ArrayList<String> al,ArrayList<String> ar)
	{
		xquery_left=xql;
		xquery_right=xqr;
		left_list=al;
		right_list=ar;
	}
	
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
	
	public ArrayList<Node> evaluate_xqueryjoin(HashMap<Object, ArrayList<Node>> evaluator_hashmap,Node node) throws TransformerException, IOException
	{
		HashMap<String, ArrayList<Node>> left_join_map = new HashMap<String, ArrayList<Node>>();
		HashMap<String, ArrayList<Node>> right_join_map = new HashMap<String, ArrayList<Node>>();
		this.xquery_left.evaluate_xquery(evaluator_hashmap, node);
		
		this.xquery_right.evaluate_xquery(evaluator_hashmap, node);
		ArrayList<Node> final_join_list = new ArrayList<Node>();
		
		ArrayList<Node> xquery_left =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_left);
		ArrayList<Node> xquery_right =(ArrayList<Node>) evaluator_hashmap.get(this.xquery_right);
		
		System.out.println("left size " + xquery_left.size());
		System.out.println("right size " + xquery_right.size());
		for(int i=0;i<xquery_left.size();i++)
		{
			
			HashMap<String,String> node_data = new HashMap<String,String>();
			String key = "";
			NodeList children = xquery_left.get(i).getChildNodes();
			for(int j=0;j<children.getLength();j++)
			{
				node_data.put(children.item(j).getNodeName().toString(), children.item(j).getTextContent().toString());
			}
			for(int k=0;k<left_list.size();k++)
			{
				key += node_data.get(left_list.get(k));
				key += ",";
			}
			ArrayList<Node> original_value = left_join_map.get(key);
			if(original_value == null)
			{
				ArrayList<Node> new_value = new ArrayList<Node>();
				new_value.add(xquery_left.get(i));	
				left_join_map.put(key, new_value);
				//System.out.println("new value" + new_value);
			}
			else
			{
				original_value.add(xquery_left.get(i));
				left_join_map.put(key, original_value);
				//System.out.println("original value"  + original_value);
			}
		}
		for(int i=0;i<xquery_right.size();i++)
		{
			HashMap<String,String> node_data = new HashMap<String,String>();
			String key = "";
			NodeList children = xquery_right.get(i).getChildNodes();
			for(int j=0;j<children.getLength();j++)
			{
				node_data.put(children.item(j).getNodeName().toString(), children.item(j).getTextContent().toString());
			}
			for(int k=0;k<right_list.size();k++)
			{
				key += node_data.get(right_list.get(k));
				key += ",";
			}
			ArrayList<Node> original_value = right_join_map.get(key);
			if(original_value == null)
			{
				ArrayList<Node> new_value = new ArrayList<Node>();
				new_value.add(xquery_right.get(i));	
				right_join_map.put(key, new_value);
			}
			else
			{
				original_value.add(xquery_right.get(i));
				right_join_map.put(key, original_value);
			}
		}
		int cnt1 = 0;
		int cnt2 = 0;
		for(Map.Entry<String, ArrayList<Node>> left_entry : left_join_map.entrySet())
		{
			//System.out.println("Map " + left_entry.getKey() + " " + left_entry.getValue());
			String left_key = left_entry.getKey();
			ArrayList<Node> left_value = left_entry.getValue();
			cnt2 = 0;
			for(Map.Entry<String, ArrayList<Node>> right_entry : right_join_map.entrySet())
			{
				String right_key = right_entry.getKey();
				ArrayList<Node> right_value = right_entry.getValue();
				if(left_key.equals(right_key))
				{
					for(int i=0;i<left_value.size();i++)
					{
						for(int j=0;j<right_value.size();j++)
						{
							//System.out.println(cnt1 + " " + cnt2 + " " + i + " " + j);
							ArrayList<Node> temp = new ArrayList<Node>();
							NodeList left_children = left_value.get(i).getChildNodes();
							NodeList right_children = right_value.get(i).getChildNodes();
							for(int k=0;k<left_children.getLength();k++)
							{
								temp.add(left_children.item(k));
							}
							for(int k=0;k<right_children.getLength();k++)
							{
								temp.add(right_children.item(k));
							}
							//temp.add(left_value.get(i));
							//temp.add(right_value.get(j));
							//System.out.println("temp list " + temp);
							Node cur_node = makeElem("tuple",temp);
							final_join_list.add(cur_node);
						}
					}
				}
				cnt2 += 1;
			}
			cnt1 += 1;
		}
		/*
		System.out.println("start");
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
	    
		
		for(int i=0;i<final_join_list.size();i++)
		{
			Node nw= (Node) doc.adoptNode(final_join_list.get(i));
			rootElement.appendChild(nw);
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("intermediate_file2.xml"));
		transformer.transform(source, result);

		String output = readFile("intermediate_file2.xml", StandardCharsets.UTF_8);
		//System.out.println(prettyFormat(output, 4));
		PrintWriter out = new PrintWriter("output_file2.xml");
		out.println(prettyFormat(output, 4));
		out.close();
		*/
		
		//for(int i=0;i<final_join_list.size();i++)
			//System.out.println(final_join_list.get(i).getTextContent());
		return final_join_list;
	}
	
}

