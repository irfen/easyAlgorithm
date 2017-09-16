package me.irfen.algorithm.ch08;

public class ArraySort {

	/**
	 * 两次遍历填充法
	 * @param array
	 */
	public static void sort1(int[] array) {
		int[] result = new int[array.length];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				result[index++] = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0) {
				result[index++] = array[i];
			}
		}
		System.out.print("两次遍历填充法排序后结果：");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i != result.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	/**
	 * 借鉴简单插入排序思想
	 * @param array
	 */
	public static void sort2(int[] array) {
		int index = 0; // 分界index
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				// 如果是负数，就依次前移到分解处
				for (int j = i; j > index; j--) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
				// 分界指针后移
				index ++;
			}
		}
		System.out.print("借鉴简单插入排序的排序后结果：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	/**
	 * 借鉴快速排序思想
	 * @param array
	 */
	public static void sort3(int[] array) {
		int i = 0;
		int j = array.length - 1;
		while (i != j) {
			while (i < j && array[i] < 0) {
				i ++;
			}
			while (i < j && array[j] >= 0) {
				j --;
			}
			if (i < j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		System.out.print("借鉴快速排序的排序后结果：");
		for (int k = 0; k < array.length; k++) {
			System.out.print(array[k]);
			if (k != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
