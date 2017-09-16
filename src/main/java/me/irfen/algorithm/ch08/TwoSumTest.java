package me.irfen.algorithm.ch08;

public class TwoSumTest {

	public static void main(String[] args) {
		int[] array = {1, 3, 7, 5, 15, 9};
		int sum = 10;
		TwoSum.find1(array, sum);
		TwoSum.find2(array, sum);
		TwoSum.find3(array, sum); // 其实这里数组已经被排序过了
		TwoSum.find4(array, sum);
	}
}
