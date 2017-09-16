package me.irfen.algorithm.ch04;

import me.irfen.algorithm.ch01.ArrayList;

public class BlockSearch {

	private int[] index;
	
	private ArrayList[] list;
	
	/**
	 * 初始化索引表
	 * @param index
	 */
	public BlockSearch(int[] index) {
		if (index != null && index.length != 0) {
			this.index = index;
			this.list = new ArrayList[index.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList();
			}
		} else {
			throw new Error("index cannot be null or empty.");
		}
	}
	
	/**
	 * 插入元素
	 * @param value
	 */
	public void insert(int value) {
		int i = binarySearch(value);
		list[i].add(value);
	}
	
	/**
	 * 查找元素
	 * @param data
	 * @return
	 */
	public boolean search(int data) {
		int i = binarySearch(data);
		for (int j = 0; j < list[i].size(); j++) {
			if (data == list[i].get(j)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 打印每块元素
	 */
	public void printAll() {
		for (int i = 0; i < list.length; i++) {
			ArrayList l = list[i];
			System.out.println("ArrayList " + i + ":");
			for (int j = 0; j < l.size(); j++) {
				System.out.println(l.get(j));
			}
		}
	}
	
	/**
	 * 二分查找定位索引位置
	 * @param data 要插入的值
	 * @return
	 */
	private int binarySearch(int data) {
		int start = 0;
		int end = index.length;
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (index[mid] > data) {
				end = mid - 1;
			} else {
				// 如果相等，也插入在后面
				start = mid + 1;
			}
		}
		return start;
	}
}
