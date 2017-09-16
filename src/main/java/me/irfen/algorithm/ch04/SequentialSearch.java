package me.irfen.algorithm.ch04;

public class SequentialSearch {

	private int[] array;
	
	public SequentialSearch(int[] array) {
		this.array = array;
	}
	
	/**
	 * 直接顺序查找
	 * @param key
	 * @return
	 */
	public int search(int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 哨兵方式顺序查找
	 * @param key
	 * @return
	 */
	public int search2(int key) {
		// 先判断是否等于下标为0的元素
		if (key == array[0]) {
			return 0;
		}
		// 临时保存array[0]的值
		int temp = array[0];
		// 赋值给下标为0的元素
		array[0] = key;
		int i = array.length - 1;
		// 倒序比较
		while(array[i] != key) {
			i --;
		}
		// 把array[0]原本的值赋回去
		array[0] = temp;
		// 比较到最后了也没有找到返回-1
		if (i == 0) {
			return -1;
		}
		// 找到了的话返回数组下标
		return i;
	}
}
