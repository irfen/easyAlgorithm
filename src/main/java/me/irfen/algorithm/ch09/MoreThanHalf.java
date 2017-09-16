package me.irfen.algorithm.ch09;

import me.irfen.algorithm.ch01.HashTable;
import me.irfen.algorithm.ch03.QuickSort;

public class MoreThanHalf {

	/**
	 * 排序解法
	 * @param array
	 */
	public static void find1(int[] array) {
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		int count = 1; // 初始化为1，因为下面要忽略第一个元素开始累加
		// 这里从下标为1的元素开始
		for (int i = 1; i < array.length; i++) {
			// 如果不相同的话需要进行判断
			if (array[i] != array[i - 1]) {
				// 如果大于一半次数
				if (count > array.length / 2) {
					System.out.println("找到了，这个元素为" + array[i - 1]);
					return;
				} else {
					count = 1; // 重置为1，因为要把自己这次加上
				}
			} else {
				// 如果相同需要累加
				count++;
			}
		}
		if (count > array.length / 2) {
			// 如果遍历到最后，都是相同的，并且大于一半
			//说明最后的元素就是要找的元素
			System.out.println("找到了，这个元素为" + array[array.length - 1]);
		} else {
			// 说明这个数组中就没有元素出现次数超过一半
			System.out.println("没有找到");
		}
	}
	
	/**
	 * 借助散列表查找
	 * @param array
	 */
	public static void find2(int[] array) {
		// 如果数组元素只有一个的话，
		if (array.length == 1) {
			System.out.println("找到了，这个元素为" + array[0]);
			return;
		}
		HashTable hashTable = new HashTable();
		for (int i = 0; i < array.length; i++) {
			int count = hashTable.get(array[i]);
			if (count > 0) {
				count ++;
				// 说明存在，如果达成条件直接输出
				if (count > array.length / 2) {
					System.out.println("找到了，这个元素为" + array[i]);
					return;
				}
				hashTable.put(array[i], count);
			} else {
				hashTable.put(array[i], 1);
			}
		}
		System.out.println("没有找到");
	}
	
	/**
	 * O(n)时间复杂度解法
	 * @param array
	 */
	public static void find3(int[] array) {
		int t = array[0];
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == t) {
				n ++;
			} else {
				n --;
			}
			if (n == 0) {
				t = array[i];
				n = 1;
			}
		}
		System.out.println("找到了，这个元素为" + t);
	}
}
