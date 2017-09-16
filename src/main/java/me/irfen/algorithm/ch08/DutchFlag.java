package me.irfen.algorithm.ch08;

public class DutchFlag {

	/**
	 * 荷兰国旗问题
	 * @param array
	 */
	public static void sort(int[] array) {
		int begin = 0;
		int end = array.length - 1;
		int current = 0;
		while (current <= end) {
			if (array[current] == 0) {
				swap(array, current, begin);
				begin ++;
				current ++;
			} else if (array[current] == 1) {
				current ++;
			} else if (array[current] == 2) {
				swap(array, current, end);
				end --;
			}
		}
		System.out.print("排序后结果：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	private static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
