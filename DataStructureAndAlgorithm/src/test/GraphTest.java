package test;
import java.util.Arrays;

import graph.Graph;
import graph.Vertex;

public class GraphTest {

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		
		graph.addEdge(v1, v2, 4);
		graph.addEdge(v1, v3, 1);
		graph.addEdge(v2, v3, 1);
		graph.addEdge(v2, v4, 1);
		graph.addEdge(v2, v5, 1);
		
		int[][] adjm = graph.getAdjMat();
		for(int[] a: adjm) {
			System.out.println(Arrays.toString(a));
		}
		
//		graph.dfs();
//		graph.bfs();
//		graph.floyd(v1, v5);
		System.out.println("------------");
		graph.dijkstra(v4);
	}

}
