package me.irfen.algorithm.ch07;

public class StringUtilsTest {

	public static void main(String[] args) {
		System.out.println(StringUtils.isPalindrome("abcba"));
		System.out.println(StringUtils.isPalindrome("abccba"));
		System.out.println(StringUtils.isPalindrome("abdbd"));
		
		System.out.println(StringUtils.longestPalindrome("abcdefgfedcgcda"));
		
		System.out.println(StringUtils.toInt("-12345"));
		System.out.println(StringUtils.toInt("12345"));
		
		System.out.println(StringUtils.toInt("-1234567890"));
		System.out.println(StringUtils.toInt("-2147483648"));
		
		System.out.println(StringUtils.toInt("1234567890"));
		System.out.println(StringUtils.toInt("2147483647"));
		
		System.out.println(StringUtils.toInt("2157483647"));
		System.out.println(StringUtils.toInt("-2147484648"));
	}
}
