package me.irfen.algorithm.ch08;

public class MaxSumSubArrayTest {

	public static void main(String[] args) {
		int[] array = {3, -6, 1, 2, 3, -1, 2, -5, 1, 2};
		MaxSumSubArray.find1(array);
		MaxSumSubArray.find2(array);
		MaxSumSubArray.find3(array);
		
		int[][] matrix = {{-1, 2, -1, 3, -4}, {2, 3, 4, -5, 1}, {1, -1, 5, -3, -2}};
		System.out.println(MaxSumSubArray.maxSumSubMatrix(matrix));
	}
}
