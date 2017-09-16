package me.irfen.algorithm.ch07;

public class Reverse {

	public static String reverse(String str, int start, int end) {
		// 先转换为字符数组
		char[] array = str.toCharArray();
		// 初始化已完成反转第一个字符位置（默认为待反转外面）
		int finish = end + 1;
		// 如果已完成的首字符减到start，则说明反转完成
		while (finish > start) {
			char temp = array[start];
			for (int j = start + 1; j < finish; j++) {
				array[j - 1] = array[j];
			}
			array[finish - 1] = temp;
			finish --;
		}
		return String.valueOf(array);
	}
	
	/**
	 * 对换位置反转字符
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static String reverse2(String str, int start, int end) {
		char[] array = str.toCharArray();
		int mid = (end - start) / 2 + start;
		for (int i = 0; i <= mid - start; i++) {
			swap(array, start + i, end - i);
		}
		return String.valueOf(array);
	}
	
	/**
	 * 旋转字符串
	 * @param str
	 * @param index
	 * @return
	 */
	public static String rotate(String str, int index) {
		str = reverse2(str, 0, index);
		str = reverse2(str, index + 1, str.length() - 1);
		str = reverse2(str, 0, str.length() - 1);
		return str;
	}
	
	/**
	 * 字符数组指定位置的互换
	 * @param array
	 * @param left
	 * @param right
	 */
	private static void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
