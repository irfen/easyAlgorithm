package me.irfen.algorithm.ch02;

import java.util.Arrays;

public class Stack {

	private int size = 0;
	
	private int[] array;
	
	public Stack() {
		this(10);
	}
	
	public Stack(int init) {
		if (init <= 0) {
			init = 10;
		}
		array = new int[init];
	}
	
	/**
	 * 入栈
	 * @param item 入栈元素的值
	 */
	public void push(int item) {
		if (size == array.length) {
			array = Arrays.copyOf(array, size * 2);
		}
		array[size++] = item;
	}
	
	/**
	 * 获取栈顶元素，但是没有出栈
	 * @return
	 */
	public int peek() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("栈里已经空啦");
		}
		return array[size - 1];
	}
	
	/**
	 * 出栈，同时获取栈顶元素
	 * @return
	 */
	public int pop() {
		int item = peek();
		size --; // 直接使元素个数减1，不需要真的清除元素，下次入栈会覆盖旧元素值
		return item;
	}
	
	/**
	 * 栈是否满了
	 * @return
	 */
	public boolean isFull() {
		return size == array.length;
	}
	
	/**
	 * 栈是否为空栈
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
