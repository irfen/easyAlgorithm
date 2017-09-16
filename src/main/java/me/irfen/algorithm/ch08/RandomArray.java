package me.irfen.algorithm.ch08;

import java.util.Random;

public class RandomArray {

	/**
	 * 随便糊弄一下的解法
	 * @param array
	 */
	public static void random1(int[] array) {
		Random random = new Random();
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int j = random.nextInt(n);
			int k = random.nextInt(n);
			int temp = array[j];
			array[j] = array[k];
			array[k] = temp;
		}
		System.out.print("随机后结果：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	/**
	 * 借鉴简单插入排序思想
	 * @param array
	 */
	public static void random2(int[] array) {
		Random random = new Random();
		// 这里的i每次就是分界指针
		for (int i = 0; i < array.length; i++) {
			// 在未随机好部分随机获得一个元素下标
			int j = random.nextInt(array.length - i) + i;
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		System.out.print("随机后结果：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
