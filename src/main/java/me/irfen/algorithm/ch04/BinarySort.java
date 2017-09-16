package me.irfen.algorithm.ch04;

public class BinarySort {

	private int[] array;
	
	public BinarySort(int[] array) {
		this.array = array;
	}
	
	public void sort() {
		if (array == null) {
			throw new RuntimeException("array is null");
		}
		if (array.length > 0) {
			for (int i = 1; i < array.length; i++) {
				int temp = array[i];
				// 二分查找插入位置
				int insertIndex = binarySearch(i - 1, temp);
				if (i != insertIndex) {
					// 移动需要移动的元素
					for (int j = i - 1; j >= insertIndex; j --) {
						array[j] = array[j - 1];
					}
					// 插入元素
					array[insertIndex] = temp;
				}
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	/**
	 * 二分查找定位插入索引
	 * @param maxIndex 有序区最大索引
	 * @param data 要找的值
	 * @return
	 */
	private int binarySearch(int maxIndex, int data) {
		int start = 0;
		int end = maxIndex;
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] > data) {
				end = mid - 1;
			} else {
				// 如果相等，也插入在后面
				start = mid + 1;
			}
		}
		return start;
	}
}
