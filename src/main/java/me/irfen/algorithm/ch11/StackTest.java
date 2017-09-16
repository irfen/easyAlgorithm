package me.irfen.algorithm.ch11;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("a");
		s.push("b");
		System.out.println(s.pop());
		System.out.println(s.peek());
	}
}
