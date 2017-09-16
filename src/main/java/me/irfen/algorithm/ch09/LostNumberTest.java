package me.irfen.algorithm.ch09;

import me.irfen.algorithm.ch08.RandomArray;

public class LostNumberTest {

	public static void main(String[] args) {
		// 初始化100个数字
		int[] arrayOld = new int[100];
		for (int i = 0; i < arrayOld.length; i++) {
			arrayOld[i] = i + 1;
		}
		// 打乱顺序
		RandomArray.random2(arrayOld);
		// 只填充前99个数，缺失的数字为乱序100个数中最后一个元素
		int[] array1 = new int[99];
		int[] array2 = new int[99];
		int[] array3 = new int[99];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = arrayOld[i];
			array2[i] = arrayOld[i];
			array3[i] = arrayOld[i];
		}
		LostNumber.find1(array1);
		LostNumber.find2(array2);
		LostNumber.find3(array3);
		LostNumber.find4(array3);
	}
}
