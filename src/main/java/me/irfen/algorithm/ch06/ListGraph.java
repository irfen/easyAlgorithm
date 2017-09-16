package me.irfen.algorithm.ch06;

import me.irfen.algorithm.ch01.HashTable;
import me.irfen.algorithm.ch02.ArrayQueue;
import me.irfen.algorithm.ch02.Stack;

public class ListGraph {

	// 图的顶点数组
	private ListGraphNode[] nodes;
	private HashTable value2index = new HashTable();
	
	/**
	 * 初始化图的顶点
	 * @param vertexes
	 */
	public ListGraph(int[] vertexes) {
		nodes = new ListGraphNode[vertexes.length];
		for (int i = 0; i < vertexes.length; i++) {
			nodes[i] = new ListGraphNode(i, vertexes[i], null);
			value2index.put(vertexes[i], i);
		}
	}
	
	/**
	 * 添加start到可到达的边
	 * @param start 起始顶点
	 * @param end 可到达的顶点的数组
	 */
	public void addEdges(int start, int[] end) {
		int index = value2index.get(start);
		if (index < 0) {
			throw new RuntimeException("未找到指定的起始顶点");
		}
		ListGraphNode node = nodes[index];
		for (int j = 0; j < end.length; j++) {
			int i = value2index.get(end[j]);
			if (i < 0) {
				throw new RuntimeException("未找到指定的到达顶点");
			}
			node.next = new ListGraphNode(i, end[j], null);
			node = node.next;
		}
	}
	
	/**
	 * 添加start到可到达的边
	 * @param start 起始顶点
	 * @param end 可到达的顶点的数组
	 * @param weights 对应的权值数组
	 */
	public void addEdges(int start, int[] end, int[] weights) {
		int index = value2index.get(start);
		if (index < 0) {
			throw new RuntimeException("未找到指定的起始顶点");
		}
		ListGraphNode node = nodes[index];
		for (int j = 0; j < end.length; j++) {
			int i = value2index.get(end[j]);
			if (i < 0) {
				throw new RuntimeException("未找到指定的到达顶点");
			}
			node.next = new ListGraphNode(i, end[j], weights[j], null);
			node = node.next;
		}
	}

	/**
	 * 邻接表深度优先遍历
	 */
	public void depthFirstTravel() {
		System.out.println("邻接表的深度优先遍历：");
		// 初始化栈
		Stack stack = new Stack(nodes.length);
		// 初始化各顶点访问状态
		int[] visited = new int[nodes.length];
		// 从未访问顶点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			visited[unvisited] = 1;
			stack.push(unvisited);
			System.out.print(nodes[unvisited].value + ",");
			while (!stack.isEmpty()) {
				// 获取栈顶元素不出栈
				int index = stack.peek();
				// 找到未被访问的邻接顶点
				boolean found = false;
				ListGraphNode node = nodes[index];
				while (node != null) {
					if (node.next != null && visited[node.next.index] == 0) {
						// 如果找到则访问并入栈
						visited[node.next.index] = 1;
						stack.push(node.next.index);
						System.out.print(node.next.value + ",");
						found = true;
						break;
					}
					node = node.next;
				}
				// 如果未找到则出栈元素
				if (!found) {
					stack.pop();
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}

	/**
	 * 邻接表广度优先遍历
	 */
	public void breadthFirstTravel() {
		System.out.println("邻接表的广度优先遍历：");
		// 初始化队列
		ArrayQueue queue = new ArrayQueue(nodes.length);
		// 初始化各顶点访问状态
		int[] visited = new int[nodes.length];
		// 从未访问顶点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			// 起始顶点入队
			queue.put(unvisited);
			while (!queue.isEmpty()) {
				// 出队顶点并访问
				int index = (Integer) queue.poll();
				System.out.print(nodes[index].value + ",");
				// 标记被访问
				visited[index] = 1;
				// 遍历所有未被访问的邻接顶点，放入队列中
				ListGraphNode node = nodes[index].next;
				while (node != null) {
					if (visited[node.index] == 0) {
						queue.put(node.index);
					}
					node = node.next;
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}

	/**
	 * dijkstra算法实现到各点的最短路径
	 * @param start
	 */
	public void dijkstra(int start) {
		int length = nodes.length;
		int x = value2index.get(start); // 根据哈希表获取对应的下标
		if (x == -1) {
			throw new RuntimeException("未找到起始顶点");
		}
		int[] S = new int[length]; // 自动初始化为0，都属于未得到最短路径的顶点
		int[][] distance = new int[length][length]; // 存储v到u的最短距离
		int[] path = new int[length]; // 存储x到u最短路径时u的前一个顶点
		// 初始化distance和path数组
		for (int i = 0; i < length; i++) {
			// 先初始化path都为-1
			path[i] = -1;
		}
		for (int i = 0; i < length; i++) {
			ListGraphNode node = nodes[i];
			node = node.next;
			while (node != null) {
				distance[i][node.index] = node.weight;
				if (x == i) {
					// 如果是x顶点的链表的话，初始化所有可达顶点的前一个顶点为x
					path[node.index] = x;
				}
				node = node.next;
			}
		}
		// 先把起始顶点加入到S
		S[x] = 1;
		for (int i = 0; i < length; i++) {
			// 首先需要寻找start顶点到各顶点最短的路径
			int min = Integer.MAX_VALUE;
			int v = 0;
			for (int j = 0; j < length; j++) {
				// S[j] == 1的话说明已经找到最短距离
				// 需要过滤掉不可达的情况
				if (S[j] != 1 && x != j && distance[x][j] != 0 && distance[x][j] < min) {
					min = distance[x][j];
					v = j;
				}
			}
			// v是目前x到各顶点最短的
			S[v] = 1;
			// 修正最短距离distance及最短距离path
			for (int j = 0; j < length; j++) {
				// 1.只修正未找到最短路径的
				// 2.修正后新顶点需要可达
				// 3.如果使用新的最短路径比原有路径短，或者以前不可达，使用新的最短路径可达了
				// 符合上面三点可以修正路径
				if (S[j] != 1 && distance[v][j] != 0
						&& (min + distance[v][j] < distance[x][j] || distance[x][j] == 0)) {
					// 说明加入了中间顶点之后找到了更短的路径
					distance[x][j] = min + distance[v][j];
					path[j] = v;
				}
			}
		}
		// 打印最短路径值
		for (int i = 0; i < length; i++) {
			if (distance[x][i] != 0) {
				System.out.println(nodes[x].value + "-->" + nodes[i].value + ": " + distance[x][i]);
				// 由于path存储的特性，可以逆序输出路径，如果有兴趣可以用栈实现正序输出
				System.out.print("逆序最短路径输出：");
				int index = i;
				while (index != -1) {
					System.out.print(nodes[index].value);
					index = path[index];
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * 打印出邻接表数据
	 */
	public void printListGraph() {
		for (int i = 0; i < nodes.length; i++) {
			ListGraphNode node = nodes[i];
			do {
				System.out.print(node.value);
				node = node.next;
			} while (node != null);
			System.out.println();
		}
	}

	/**
	 * 从访问标记数组中获取第一个发现的未被访问的顶点下标
	 * @param visited
	 * @return 都被访问了就返回-1
	 */
	private int getUnVisited(int[] visited) {
		int index = -1;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				index = i;
				break;
			}
		}
		return index;
	}
}
