package edu.ucsd.antlr232b.antlrxq;

import java.util.ArrayList;

public class buildGraph {
	ArrayList<buildNode> vertices;
	ArrayList<String> visited;
	ArrayList<ArrayList<String>> print_list;
	ArrayList<ArrayList<String>> node_order;
	ArrayList<ArrayList<String>> original_order;
	
	public buildGraph()
	{
		vertices = new ArrayList<buildNode>();
		visited = new ArrayList<String>();
		print_list = new ArrayList<ArrayList<String>>();
		node_order = new ArrayList<ArrayList<String>>();
		original_order = new ArrayList<ArrayList<String>>();
	}
	
	public void add_node(buildNode input_node)
	{
		vertices.add(input_node);
	}
	
	public int get_size()
	{
		return vertices.size();
	}
	
	public ArrayList<buildNode> get_vertices()
	{
		return vertices;
	}

	public boolean is_node_present(String inputname)
	{
		for(int i=0;i<vertices.size();i++)
		{
			if(vertices.get(i).name.equals(inputname))
				return true;
		}
		return false;
	}

	public buildNode get_node(String inputname)
	{
		for(int i=0;i<vertices.size();i++)
		{
			if(vertices.get(i).name.equals(inputname))
				return vertices.get(i);
		}
		return null;
	}

	public boolean is_same_subtree(buildNode left, buildNode right)
	{
		ArrayList<String> left_parent_list = new ArrayList<String>();
		ArrayList<String> right_parent_list = new ArrayList<String>();
		
		while(left.parent != null)
		{
			left_parent_list.add(left.name);
			left = left.parent;
		}
		while(right.parent != null)
		{
			right_parent_list.add(right.name);
			right = right.parent;
		}
		/*
		for(int i=0;i<left_parent_list.size();i++)
			System.out.print(left_parent_list.get(i) + " ");
		
		for(int i=0;i<right_parent_list.size();i++)
			System.out.print(right_parent_list.get(i) + " ");
			*/
		for(int i=0;i<left_parent_list.size();i++)
		{
			for(int j=0;j<right_parent_list.size();j++)
			{
				if(left_parent_list.get(i).equals(right_parent_list.get(j)))
					return true;
			}
		}
		return false;
	}


}

