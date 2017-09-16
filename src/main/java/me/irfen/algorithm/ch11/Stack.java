package me.irfen.algorithm.ch11;

import java.util.Arrays;

public class Stack<E> {

	private int size = 0;
	private Object[] array;
	
	/**
	 * 默认初始化栈
	 */
	public Stack() {
		this(10);
	}
	
	/**
	 * 指定栈空间初始化
	 * @param initialCapacity
	 */
	public Stack(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new RuntimeException("初始化栈空间错误");
		}
		array = new Object[initialCapacity];
	}
	
	/**
	 * 入栈
	 * @param item
	 * @return
	 */
	public E push(E item) {
		ensureCapacityHelper(size + 1);
		array[size++] = item;
		return item;
	}

	/**
	 * 获取栈顶元素，但是没有出栈
	 * @return
	 */
	public E peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("栈里已经空啦");
		}
		return (E) array[size - 1];
	}
	
	/**
	 * 出栈，同时获取栈顶元素
	 * @return
	 */
	public E pop() {
		E item = peek();
		size --; // 直接使元素个数减1，不需要真的清除元素，下次入栈会覆盖旧元素值
		return item;
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
	
	/**
	 * 确保空间够用
	 * @param minCapacity
	 */
	private void ensureCapacityHelper(int minCapacity) {
		if (minCapacity > array.length) {
			// 说明需要的空间不够了
			grow();
		}
	}
	
	/**
	 * 涨空间
	 */
	private void grow() {
		int oldCapacity = array.length;
		int newCapacity = oldCapacity * 2;
		if (newCapacity < oldCapacity) {
			// 说明溢出了
			throw new OutOfMemoryError();
		} else {
			array = Arrays.copyOf(array, newCapacity);
		}
	}
}
