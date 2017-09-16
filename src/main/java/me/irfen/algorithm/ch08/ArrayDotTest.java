package me.irfen.algorithm.ch08;

public class ArrayDotTest {

	public static void main(String[] args) {
		int[] array = {4, 5, 6, 7, 1, 2, 3};
		int[] array2 = {1, 1, 1, 0, 0, 0, 1};
		ArrayDot.findDot1(array);
		ArrayDot.findDot1(array2);
		ArrayDot.findDot2(array);
		ArrayDot.findDot2(array2);
	}
}
