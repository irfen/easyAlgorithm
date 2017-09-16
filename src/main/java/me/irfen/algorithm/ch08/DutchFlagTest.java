package me.irfen.algorithm.ch08;

public class DutchFlagTest {

	public static void main(String[] args) {
		int[] array1 = {1, 1, 0, 0, 2, 2, 1, 0, 1, 2, 1, 0, 2};
		int[] array2 = {0, 1, 0, 0, 2, 2, 1, 0, 1, 2, 1, 0, 1};
		DutchFlag.sort(array1);
		DutchFlag.sort(array2);
	}
}
