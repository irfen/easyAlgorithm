package me.irfen.algorithm.ch06;

public class ListGraphNode {

	int index;
	/// 值
	int value;
	// 权值
	int weight;
	// 指向下一个节点的指针（引用）
	ListGraphNode next;
	
	public ListGraphNode(int value, ListGraphNode next) {
		this.value = value;
		this.next = next;
	}
	
	public ListGraphNode(int index, int value, ListGraphNode next) {
		this.index = index;
		this.value = value;
		this.next = next;
	}

	public ListGraphNode(int index, int value, int weight, ListGraphNode next) {
		this.index = index;
		this.value = value;
		this.weight = weight;
		this.next = next;
	}
	
}
