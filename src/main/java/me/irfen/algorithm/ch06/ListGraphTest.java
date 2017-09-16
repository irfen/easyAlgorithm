package me.irfen.algorithm.ch06;

public class ListGraphTest {

	public static void main(String[] args) {
		int[] vertexes = {0, 1, 2, 3};
		ListGraph graph = new ListGraph(vertexes);
		graph.addEdges(0, new int[]{1, 2, 3});
		graph.addEdges(1, new int[]{2});
		graph.addEdges(3, new int[]{2});
		graph.printListGraph();
		
		int[] vertexes2 = {0, 1, 2, 3, 4, 5, 6};
		ListGraph graph2 = new ListGraph(vertexes2);
		graph2.addEdges(0, new int[]{1, 2});
		graph2.addEdges(1, new int[]{3, 4});
		graph2.addEdges(2, new int[]{5, 6});
		graph2.depthFirstTravel();
		graph2.breadthFirstTravel();
	}
}
