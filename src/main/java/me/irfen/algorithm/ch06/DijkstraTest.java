package me.irfen.algorithm.ch06;

public class DijkstraTest {

	public static void main(String[] args) {
		int[] vertexes = {1, 2, 3, 4, 5, 6};
		MatrixGraph matrixGraph = new MatrixGraph(vertexes);
		matrixGraph.addEdge(1, 2, 16);matrixGraph.addEdge(2, 1, 16);
		matrixGraph.addEdge(1, 3, 1);matrixGraph.addEdge(3, 1, 1);
		matrixGraph.addEdge(1, 5, 12);matrixGraph.addEdge(5, 1, 12);
		matrixGraph.addEdge(1, 6, 15);matrixGraph.addEdge(6, 1, 15);
		matrixGraph.addEdge(2, 4, 2);matrixGraph.addEdge(4, 2, 2);
		matrixGraph.addEdge(2, 6, 8);matrixGraph.addEdge(6, 2, 8);
		matrixGraph.addEdge(3, 5, 5);matrixGraph.addEdge(5, 3, 5);
		matrixGraph.addEdge(4, 6, 3);matrixGraph.addEdge(6, 4, 3);
		matrixGraph.addEdge(5, 6, 8);matrixGraph.addEdge(6, 5, 8);
		matrixGraph.addEdge(4, 5, 9);matrixGraph.addEdge(5, 4, 9);
		matrixGraph.dijkstra(1);
		
		ListGraph listGraph = new ListGraph(vertexes);
		listGraph.addEdges(1, new int[]{2, 3, 5, 6}, new int[]{16, 1, 12, 15});
		listGraph.addEdges(2, new int[]{1, 4, 6}, new int[]{16, 2, 8});
		listGraph.addEdges(3, new int[]{1, 5}, new int[]{1, 5});
		listGraph.addEdges(4, new int[]{2, 5, 6}, new int[]{2, 9, 3});
		listGraph.addEdges(5, new int[]{1, 3, 4, 6}, new int[]{12, 5, 9, 8});
		listGraph.addEdges(6, new int[]{1, 2, 4, 5}, new int[]{15, 8, 3, 8});
		listGraph.dijkstra(1);
	}
}
