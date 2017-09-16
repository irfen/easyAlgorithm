package me.irfen.algorithm.ch03;

public class SortTest {

	public static void main(String[] args) {
//		testBucketSort();
//		testBubbleSort();
//		testQuickSort();
//		testInsertSort();
//		testShellSort();
		testSelectSort();
	}
	
	/**
	 * 桶排序
	 */
	private static void testBucketSort() {
		int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
		BucketSort bucketSort = new BucketSort(11, array);
		bucketSort.sort();
		bucketSort.print();
	}
	
	/**
	 * 冒泡排序
	 */
	private static void testBubbleSort() {
		int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
		BubbleSort bubbleSort = new BubbleSort(array);
		bubbleSort.sort2();
		bubbleSort.print();
	}
	
	/**
	 * 快速排序
	 */
	private static void testQuickSort() {
		int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		quickSort.print();
	}
	
	/**
	 * 插入排序
	 */
	private static void testInsertSort() {
		int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
		InsertSort insertSort = new InsertSort(array);
		insertSort.sort();
		insertSort.print();
	}
	
	/**
	 * 希尔排序
	 */
	private static void testShellSort() {
		int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
		ShellSort shellSort = new ShellSort(array);
		shellSort.sort();
		shellSort.print();
	}
	
	/**
	 * 简单选择排序
	 */
	private static void testSelectSort() {
		int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
		SelectSort selectSort = new SelectSort(array);
		selectSort.sort();
		selectSort.print();
	}
}
