package me.irfen.algorithm.ch06;

import me.irfen.algorithm.ch02.ArrayQueue;
import me.irfen.algorithm.ch02.Stack;

public class MatrixGraph {

	// 通过下标映射元素值
	private int[] mapping;
	// 图的二维数组
	private int[][] matrix;
	
	/**
	 * 初始化图的顶点
	 * @param vertexes 顶点数组
	 */
	public MatrixGraph(int[] vertexes) {
		int length = vertexes.length;
		mapping = new int[length];
		matrix = new int[length][length];
		for (int i = 0; i < length; i++) {
			mapping[i] = vertexes[i];
		}
	}
	
	/**
	 * 添加边
	 * @param start
	 * @param end
	 */
	public void addEdge(int start, int end) {
		int x = -1;
		int y = -1;
		// 寻找坐标
		for (int i = 0; i < mapping.length; i++) {
			if (x != -1 && y != -1) {
				break;
			}
			if (start == mapping[i]) {
				x = i;
			}
			if (end == mapping[i]) {
				y = i;
			}
		}
		// 判断顶点是否存在
		if (x == -1 || y == -1
				|| x > mapping.length - 1 || y > mapping.length - 1) {
			throw new IndexOutOfBoundsException("边的顶点不存在");
		}
		// 增加边
		matrix[x][y] = 1;
	}
	
	/**
	 * 添加具有权值的边
	 * @param start
	 * @param end
	 * @param value
	 */
	public void addEdge(int start, int end, int value) {
		int x = -1;
		int y = -1;
		// 寻找坐标
		for (int i = 0; i < mapping.length; i++) {
			if (x != -1 && y != -1) {
				break;
			}
			if (start == mapping[i]) {
				x = i;
			}
			if (end == mapping[i]) {
				y = i;
			}
		}
		// 判断顶点是否存在
		if (x == -1 || y == -1
				|| x > mapping.length - 1 || y > mapping.length - 1) {
			throw new IndexOutOfBoundsException("边的顶点不存在");
		}
		// 增加边
		matrix[x][y] = value;
	}
	
	/**
	 * 邻接矩阵深度优先遍历
	 */
	public void depthFirstTravel() {
		System.out.println("邻接矩阵的深度优先遍历：");
		// 初始化栈
		Stack stack = new Stack(mapping.length);
		// 初始化各顶点访问状态
		int[] visited = new int[mapping.length];
		// 从未访问顶点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			// 访问起始顶点并入栈
			visited[unvisited] = 1;
			stack.push(unvisited);
			System.out.print(mapping[unvisited] + ",");
			while (!stack.isEmpty()) {
				// 获取栈顶元素不出栈
				int index = stack.peek();
				// 遍历找到未被访问的邻接顶点
				boolean found = false;
				for (int i = 0; i < mapping.length; i++) {
					// 不能是自己、未被访问、可到达
					if (index != i && visited[i] == 0 && matrix[index][i] > 0) {
						// 如果找到则访问并入栈
						visited[i] = 1;
						stack.push(i);
						System.out.print(mapping[i] + ",");
						found = true;
						break;
					}
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
	 * 邻接矩阵广度优先遍历
	 */
	public void breadthFirstTravel() {
		System.out.println("邻接矩阵的广度优先遍历：");
		// 初始化队列
		ArrayQueue queue = new ArrayQueue(mapping.length);
		// 初始化各顶点访问状态
		int[] visited = new int[mapping.length];
		// 从未访问顶点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			// 起始顶点入队
			queue.put(unvisited);
			while (!queue.isEmpty()) {
				// 出队顶点并访问
				int index = (Integer) queue.poll();
				if (visited[index] == 1) {
					continue;
				}
				System.out.print(mapping[index] + ",");
				// 标记被访问
				visited[index] = 1;
				// 遍历所有未被访问的邻接顶点，放入队列中
				for (int i = 0; i < mapping.length; i++) {
					// 不能是自己、未被访问、可到达
					if (index != i && visited[i] == 0 && matrix[index][i] > 0) {
						queue.put(i);
					}
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
		int length = mapping.length;
		int x = -1;
		for (int i = 0; i < length; i++) {
			if (mapping[i] == start) {
				x = i;
				break;
			}
		}
		if (x == -1) {
			throw new RuntimeException("未找到起始顶点");
		}

		int[] S = new int[length]; // 自动初始化为0，都属于未得到最短路径的顶点
		int[][] distance = matrix; // 存储v到u的最短距离
		int[] path = new int[length]; // 存储x到u最短路径时u的前一个顶点
		// 初始化path数组
		for (int i = 0; i < length; i++) {
			// 如果可达就赋值
			if (matrix[x][i] > 0) {
				path[i] = x;
			} else {
				// 不可达，赋值前一个顶点下标为-1
				path[i] = -1;
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
				System.out.println(mapping[x] + "-->" + mapping[i] + ": " + distance[x][i]);
				// 由于path存储的特性，可以逆序输出路径，如果有兴趣可以用栈实现正序输出
				System.out.print("逆序最短路径输出：");
				int index = i;
				while (index != -1) {
					System.out.print(mapping[index]);
					index = path[index];
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * 输出矩阵
	 */
	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
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
