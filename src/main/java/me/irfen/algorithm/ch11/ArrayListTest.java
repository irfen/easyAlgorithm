package me.irfen.algorithm.ch11;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list.indexOf("a"));
		System.out.println(list.contains("a"));
		System.out.println(list.get(1));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.clear();
		System.out.println(list.isEmpty());
	}
}
