package me.irfen.algorithm.ch02.extend;

import me.irfen.algorithm.ch02.Link;

public class LinkReverseTest {

	public static void main(String[] args) {
		Link link = new Link();
		link.addLast(1);
		link.addLast(2);
		link.addLast(3);
		link.addLast(4);
		printAllElements(link);
		link.reverse();
		printAllElements(link);
	}
	
	private static void printAllElements(Link link) {
		for (int i = 0; i < link.size(); i++) {
			System.out.println(link.get(i).getData());
		}
	}
}
