package me.irfen.algorithm.ch05;

public class HeapSortTest {

	public static void main(String[] args) {
		// 1.构建堆
		Heap heap = new Heap(100);
		// 2.依次添加元素
		int[] array = {9, 18, 34, 15, 29, 66, 12, 48};
		for (int i = 0; i < array.length; i++) {
			heap.insert(array[i]);
		}
		// 3.排序并输出排序后元素
		heap.sort();
	}
}
