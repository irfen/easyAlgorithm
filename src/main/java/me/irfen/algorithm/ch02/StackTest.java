package me.irfen.algorithm.ch02;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack(1); // 为了方便看出效果，设定初始数组长度为1
		stack.push(1);
		stack.push(2);
		System.out.println(stack.size()); // 栈内元素个数为2，当前数组长度也为2
		stack.push(3);
		System.out.println(stack.size()); // 栈内元素个数为3，当前数组长度为4
		System.out.println(stack.peek()); // 获取栈顶元素，为3，但是没有出栈
		System.out.println(stack.size()); // 由于上面一行没有出栈，所以元素个数还是3
		System.out.println(stack.pop()); // 栈顶元素出栈，返回3
		System.out.println(stack.pop()); // 栈顶元素出站，返回2
		System.out.println(stack.size()); // 出了两次栈，当前元素个数为1
	}
}
