package me.irfen.algorithm.ch07;

public class ReverseTest {

	public static void main(String[] args) {
		System.out.println(Reverse.reverse("abcdefg", 0, 6));
		System.out.println(Reverse.reverse("abcdefg", 2, 4));
		System.out.println(Reverse.reverse2("abcdefg", 0, 6));
		System.out.println(Reverse.reverse2("abcdefg", 2, 4));
		
		System.out.println(Reverse.rotate("abcdefg", 3));
	}
}
