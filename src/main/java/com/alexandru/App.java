package com.alexandru;

import com.alexandru.Algorithms.DataStructures.AdjacencyList;
import com.alexandru.Algorithms.Exceptions.MyExceptions;
import com.alexandru.Algorithms.MST.Kruskal;
import com.alexandru.Algorithms.MST.Prim;
import com.alexandru.Algorithms.Traversal.BFS;
import com.alexandru.Algorithms.Traversal.DFS;

import java.io.IOException;
import java.util.Scanner;

public class App
{
	public static void main(String[] args) throws IOException
	{
		int starVert;

		String fileName = "src/main/resources/myGraph.txt";
		AdjacencyList myList = new AdjacencyList(fileName);

		BFS bfs = new BFS(myList.getAdjacencyList(), myList.getVertexAmount());
		DFS dfs = new DFS(myList.getAdjacencyList(), myList.getVertexAmount());

		System.out.println("\n///// Adjacency List /////\n");

		// print the adjacency list
		myList.printAdj();

		System.out.println();
		System.out.println("||| ================================================================ |||");
		System.out.println();

		System.out.println("///// Breadth-First Search /////\n");

		try
		{
			bfs.breadthFirstSearch(3);
		} catch (MyExceptions myExceptions)
		{
			myExceptions.printStackTrace();
		}

		System.out.println();
		System.out.println("||| ================================================================ |||");
		System.out.println();
		System.out.println("///// Depth-First Search /////\n");

		dfs.dfsRecursive(3);

		Scanner textScanner = new Scanner(System.in);

		System.out.print("\nEnter starting vertex: ");
		starVert = textScanner.nextInt();

		Prim graph = new Prim(fileName);

		graph.display();
		graph.MSTPrim(starVert);
		graph.showMST();

		Kruskal graph2 = new Kruskal(fileName);

		graph2.MSTKruskal();
		graph2.showMST();
	}
}
