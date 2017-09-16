package me.irfen.algorithm.ch02.extend;

import me.irfen.algorithm.ch02.Stack;

public class Stack2Queue {

	private Stack stack1;
	private Stack stack2;
	private int maxLength;
	
	public Stack2Queue(int capacity) {
		maxLength = capacity;
		stack1 = new Stack(capacity);
		stack2 = new Stack(capacity);
	}
	
	public boolean put(int item) {
		if (stack1.isFull() || maxLength == size()) {
			// 满了
			return false;
		}
		stack1.push(item);
		return true;
	}
	
	public int poll() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
	}
	
	public int size() {
		return stack1.size() + stack2.size();
	}
}
