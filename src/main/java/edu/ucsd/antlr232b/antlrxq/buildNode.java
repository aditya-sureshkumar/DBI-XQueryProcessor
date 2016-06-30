package edu.ucsd.antlr232b.antlrxq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.misc.Pair;

public class buildNode {
	String name;
	ArrayList<Pair<buildNode,buildEdge>> adjacency_list;
	buildNode parent;
	ArrayList<String>rewrite_list;
	
	
	public buildNode(String inputname)
	{
		name = inputname;
		adjacency_list = new ArrayList<Pair<buildNode,buildEdge>>();
		parent = null;
		rewrite_list = new ArrayList<String>();
	}

	public void add_egde(buildNode dest_node, buildEdge edge)
	{
		Pair<buildNode,buildEdge> cur_pair = new Pair<buildNode,buildEdge>(dest_node, edge);
		this.adjacency_list.add(cur_pair);
		if(edge.name != "join")
		{
			dest_node.parent = this;
			//this.parent = dest_node;
		}
		
		else
		{
			Pair<buildNode,buildEdge> cur_pair2 = new Pair<buildNode,buildEdge>(this, edge);
			dest_node.adjacency_list.add(cur_pair2);
			//System.out.println(this.name + " " + dest_node.name);
			this.rewrite_list.add(this.name);
			dest_node.rewrite_list.add(dest_node.name);
		}
	}

	public ArrayList<buildEdge> get_edges()
	{
		ArrayList<buildEdge> edges = new ArrayList<buildEdge>();
		for(int i=0;i<this.adjacency_list.size();i++)
		{
			Pair<buildNode,buildEdge> cur_pair = this.adjacency_list.get(i);
			edges.add(cur_pair.b);
			
		}
		return edges;
	}
	
	public ArrayList<Pair<buildNode,buildEdge>> get_neighbours()
	{
		return adjacency_list;
	}
	
	public void rewrite_for()
	{
		System.out.print("\n\nfor ");
		Queue<buildNode> queue = new LinkedList<buildNode>();
		String for_string = "";
		queue.add(this);
		while(!queue.isEmpty())
		{
			buildNode cur_node = queue.remove();
			//System.out.print(" " + cur_node.name + " in ");
			for_string += " " + cur_node.name + " in ";
			if(cur_node.parent != null)
			{
				//System.out.print(cur_node.parent.name);
				for_string += cur_node.parent.name;
				for(int i=0;i<cur_node.parent.adjacency_list.size();i++)
				{
					if(cur_node.parent.adjacency_list.get(i).a == cur_node)
					{
						//System.out.print("/" + cur_node.parent.adjacency_list.get(i).b.name + ",");
						for_string += "/" + cur_node.parent.adjacency_list.get(i).b.name + ","  + "\n" ;
						break;
					}
				}
			}
			
			for(int j=0;j<cur_node.adjacency_list.size();j++)
			{
				if(cur_node.adjacency_list.get(j).b.name != "equality" && cur_node.adjacency_list.get(j).b.name != "join")
					queue.add(cur_node.adjacency_list.get(j).a);
			}
			//System.out.println();
		}
		System.out.println(for_string.substring(1,for_string.length()-2));
	}
	
	public void rewrite_where()
	{
		Queue<buildNode> queue = new LinkedList<buildNode>();
		queue.add(this);
		while(!queue.isEmpty())
		{
			buildNode cur_node = queue.remove();
			for(int j=0;j<cur_node.adjacency_list.size();j++)
			{
				if(cur_node.adjacency_list.get(j).b.name != "join")
				{
					if(cur_node.adjacency_list.get(j).b.name == "equality")
					{
						System.out.print(" \nwhere " + cur_node.adjacency_list.get(j).a.parent.name + " eq " + cur_node.adjacency_list.get(j).a.name);
					}
					else
						queue.add(cur_node.adjacency_list.get(j).a);
				}
			}
		}
	}
	
	public void rewrite_return()
	{
		System.out.print("\n\nreturn ");
		System.out.print(" <tuple> {");
		Queue<buildNode> queue = new LinkedList<buildNode>();
		queue.add(this);
		Set<String> set = new HashSet<String>();
		set.add(this.name);
		System.out.print("<" + this.name.substring(1, this.name.length())  +">");
		System.out.print("{" + this.name +  "}");
		System.out.print("</" + this.name.substring(1, this.name.length())  +">");
		while(!queue.isEmpty())
		{
			buildNode cur_node = queue.remove();
			for(int i=0;i<cur_node.adjacency_list.size();i++)
			{
				if(cur_node.adjacency_list.get(i).b.name == "join")
				{
					if(!set.contains(cur_node.name))
					{
						System.out.println();
						System.out.print("<" + cur_node.name.substring(1, cur_node.name.length())  +">");
						System.out.print("{" + cur_node.name +  "}");
						System.out.print("</" + cur_node.name.substring(1, cur_node.name.length())  +">");
						//set.add(cur_node.name);
					}
				}
				else
				{
					queue.add(cur_node.adjacency_list.get(i).a);
					//set.add(cur_node.adjacency_list.get(i).a.name);
				}
			}
		}
		System.out.print("} </tuple>, ");
	}



	public void join_list(ArrayList<String> visited,ArrayList<ArrayList<String>> print_list)
	{
		Queue<buildNode> queue = new LinkedList<buildNode>();
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> print_list_to_be_added = new ArrayList<String>();
		ArrayList<String> visited_to_be_added = new ArrayList<String>();
		boolean is_visited_empty = false;
		boolean to_be_added = true;
		
		if(visited.isEmpty())
			is_visited_empty = true;
		
		queue.add(this);
		while(!queue.isEmpty())
		{
			to_be_added = true;
			buildNode cur_node = queue.remove();
			for(int i=0;i<cur_node.adjacency_list.size();i++)
			{
				if(cur_node.adjacency_list.get(i).b.name == "join")
				{
					
					if(is_visited_empty)
					{
						//System.out.println("CHECK" + cur_node.name.substring(1,cur_node.name.length()) );
						temp.add(cur_node.name.substring(1,cur_node.name.length()));
						//System.out.println("CHECK" + cur_node.name);
						visited.add(cur_node.name);
						//System.out.println("CHECK" + cur_node.adjacency_list.get(i).a.name);
						visited.add(cur_node.adjacency_list.get(i).a.name);
					}
					else
					{
						for(int j=0;j<visited.size();j++)
						{
							if(visited.get(j).equals(cur_node.name))
							{
								temp.add(cur_node.name.substring(1,cur_node.name.length()));
								to_be_added = false;
							}
						}
						if(to_be_added)
						{
							print_list_to_be_added.add(cur_node.name.substring(1,cur_node.name.length()));
							visited_to_be_added.add(cur_node.name.substring(1,cur_node.name.length()));
							visited_to_be_added.add(cur_node.adjacency_list.get(i).a.name);
						}
					}
				}
				else
					queue.add(cur_node.adjacency_list.get(i).a);
			}
		}
		//System.out.println(" temp " + temp + " visited " + visited);
		print_list.add(temp);
		if(is_visited_empty == false)
		{
			System.out.println();
			for(int k=0;k<print_list.size();k++)
			{
				System.out.print(print_list.get(k));
				if(k < print_list.size() - 1)
					System.out.print(",");
			}
			
			visited.clear();
			visited.addAll(visited_to_be_added);
			visited_to_be_added = new ArrayList<String>();
			print_list.clear();
			print_list.add(print_list_to_be_added);
		}
	}
}

