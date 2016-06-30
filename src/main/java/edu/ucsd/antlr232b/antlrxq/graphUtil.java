package edu.ucsd.antlr232b.antlrxq;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class graphUtil
{
	public static ArrayList<String> get_node_order_util(ArrayList<ArrayList<String>> node_order,boolean[] node_order_truth,ArrayList<ArrayList<String>> original_order)
	{
		
		ArrayList<String> final_string_order = new ArrayList<String>();
		node_order_truth[0] = true;
		final_string_order.add(node_order.get(0).get(0));
		final_string_order.add(node_order.get(0).get(1));
		System.out.println("original order " + original_order);
		System.out.println("node order" + node_order);
		for(int i=0;i<node_order.size();i++)
		{
			if(node_order_truth[i] == false)
			{
				boolean is_first_elem_present = false;
				boolean is_second_elem_present = false;
				for(int j=0;j<final_string_order.size();j++)
				{
					if(node_order.get(i).get(0).equals(final_string_order.get(j)))
						is_first_elem_present = true;
					if(node_order.get(i).get(1).equals(final_string_order.get(j)))
						is_second_elem_present = true;
				}
				if(is_first_elem_present == true && is_second_elem_present == false)
				{
					final_string_order.add(node_order.get(i).get(1));
					node_order_truth[i] = true;
					i = 0;
				}
				if(is_first_elem_present == false && is_second_elem_present == true)
				{
					final_string_order.add(node_order.get(i).get(0));
					node_order_truth[i] = true;
					i = 0;
				}
				else if(is_first_elem_present == true && is_second_elem_present == true)
				{
					node_order_truth[i] = true;
				}
				else if(is_first_elem_present == false && is_second_elem_present == false)
				{
					node_order_truth[i] = false;
				}
			}
			else
				continue;
		}
		System.out.println("final order " + final_string_order);
		return final_string_order;
		
	}
	public static ArrayList<String> get_node_order(ArrayList<ArrayList<String>> node_order,ArrayList<ArrayList<String>> original_order)
	{
		boolean[] node_order_truth = new boolean[node_order.size()];
		for(int i=0;i<node_order_truth.length;i++)
		{
			node_order_truth[i] = false;
		}
		ArrayList<String> final_string_order = get_node_order_util(node_order,node_order_truth,original_order);
		return final_string_order;
		
	}
	
	static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	public static void main(String args[]) throws IOException
	{
		
		buildGraph graph = new buildGraph();
		String query = readFile("input.txt", StandardCharsets.UTF_8);
						
		String[] query_parts = query.split("\n");
		String keyword = "";
		buildNode root_element = null;
		String return_string = "";
		ArrayList<buildNode> where_left_list = new ArrayList<buildNode>(); 
		ArrayList<buildNode> where_right_list = new ArrayList<buildNode>(); 
		for(int i=0;i<query_parts.length;i++)
		{
			String[] sub_query_parts  = query_parts[i].split(" ");

			buildNode prev_node1 = null;
			buildNode prev_node2 = null;
			boolean eq_flag = false;
			for(int j=0;j<sub_query_parts.length;j++)
			{
				if(sub_query_parts[j].equals("for"))
				{
					keyword = "for";
				}
				else if(sub_query_parts[j].equals("in"))
				{
					keyword = "in";
				}
				else if(sub_query_parts[j].equals("where"))
				{
					keyword = "where";
					eq_flag = false;
				}
				else if(sub_query_parts[j].equals("return"))
				{
					keyword = "return";
					return_string += "return";
				}
				else
				{
					if(keyword.equals("return"))
					{
						return_string += sub_query_parts[j];
					}
					else if(keyword.equals("for"))
					{
						buildNode cur_node = new buildNode(sub_query_parts[j]);
						prev_node1 = cur_node;
						graph.add_node(cur_node);
					}
					else if(keyword.equals("in"))
					{
						if(sub_query_parts[j].charAt(sub_query_parts[j].length() - 1) == ',')
						{
							sub_query_parts[j] = sub_query_parts[j].substring(0, sub_query_parts[j].length()-1);
							keyword = "for";
						}
						
						String[] node_name  = sub_query_parts[j].split("/",2);
						buildNode cur_node = null;
						if(graph.is_node_present(node_name[0]))
						{
							cur_node = graph.get_node(node_name[0]);
							buildEdge cur_edge = new buildEdge(node_name[1]);
							cur_node.add_egde(prev_node1,cur_edge);
						}
						else
						{
							cur_node = new buildNode(node_name[0]);
							buildEdge cur_edge = new buildEdge(node_name[1]);
							cur_node.add_egde(prev_node1,cur_edge);
							graph.add_node(cur_node);
						}
						if(root_element == null)
							root_element = cur_node;
					}
					else if(keyword.equals("where"))
					{
						if(sub_query_parts[j].equals("eq"))
						{
							eq_flag = true;
						}
						else if(sub_query_parts[j].equals("and"))
						{
							keyword = "where";
							eq_flag = false;
						}
						else if(eq_flag == false)
						{
							prev_node1 = graph.get_node(sub_query_parts[j]);
							if(prev_node1  == null)
							{
								
								buildNode cur_node = new buildNode(sub_query_parts[j]);
								graph.add_node(cur_node);
								where_left_list.add(cur_node);
							}
							else
							{ 
								where_left_list.add(prev_node1);
							}
						}
						else
						{
							prev_node2 = graph.get_node(sub_query_parts[j]);
							if(prev_node2  == null)
							{
								buildNode cur_node = new buildNode(sub_query_parts[j]);
								graph.add_node(cur_node);
								where_right_list.add(cur_node);
							}
							else
							{
								where_right_list.add(prev_node2);
							}
						}
					}
						
				}
			}

		}
		
		/*for(int i=0;i<where_left_list.size();i++)
		{
			System.out.println(where_left_list.get(i).name + " check "  + where_right_list.get(i).name);
		}*/
		
		for(int i=0;i<where_left_list.size();i++)
		{
			buildEdge cur_edge;
			if(where_right_list.get(i).name.charAt(0) != '$')
				cur_edge = new buildEdge("equality");
			else
			{
				cur_edge = new buildEdge("join");
				ArrayList<String>temp = new ArrayList<String>();
				ArrayList<String>temp2 = new ArrayList<String>();
				buildNode left_node = where_left_list.get(i);
				buildNode right_node = where_right_list.get(i);
				
				temp2.add(left_node.name);
				temp2.add(right_node.name);
				graph.original_order.add(temp2);
				while(left_node.parent != root_element)
					left_node = left_node.parent;
				while(right_node.parent != root_element)
					right_node = right_node.parent;
				temp.add(left_node.name);
				temp.add(right_node.name);
				graph.node_order.add(temp);
			}
			where_left_list.get(i).add_egde(where_right_list.get(i), cur_edge);
		}
		//System.out.println("node order " + graph.node_order );
		ArrayList<String> final_string_order = get_node_order(graph.node_order,graph.original_order);
		int cur_size = root_element.adjacency_list.size();
		String join = "";
		ArrayList<String> elem_name = new ArrayList<String>();
		for(int i=0;i<cur_size-1;i++)
		{
			join += "join(";
		}
		System.out.print("for $tuple in " + join);
		ArrayList<buildNode> final_node_order = new ArrayList<buildNode>();
		//System.out.println(final_string_order);
		for(int i=0;i<final_string_order.size();i++)
		{
			for(int j=0;j<root_element.adjacency_list.size();j++)
			{
				if(root_element.adjacency_list.get(j).a.name.equals(final_string_order.get(i)))
				{
					final_node_order.add(root_element.adjacency_list.get(j).a);
					break;
				}
			}
		}
		
		
		for(int i=0;i<final_node_order.size();i++)
		{
			final_node_order.get(i).rewrite_for();
			final_node_order.get(i).rewrite_where();
			final_node_order.get(i).rewrite_return();			
			final_node_order.get(i).join_list(graph.visited,graph.print_list);
			/*
			if(i == 0)
				elem_name.add("{$tuple/" + root_element.adjacency_list.get(i).a.name + ",");
			else if(i == root_element.adjacency_list.size()-1)
				elem_name.add("$tuple/" + root_element.adjacency_list.get(i).a.name + "}");
			else
				elem_name.add("$tuple/" + root_element.adjacency_list.get(i).a.name + ",");
				*/
				
			
			if(i == root_element.adjacency_list.size()-1)
				System.out.println(")");
			else if(i >= 1)
				System.out.println("),");
		}
		/*System.out.println("\n return <triplet>");
		for(int i=0;i<elem_name.size();i++)
			System.out.print(elem_name.get(i));
		System.out.println("\n</triplet>");*/
		return_string = return_string.replaceAll("\\$", "\\$tuple/");
		System.out.print(return_string);
		
	}
}


