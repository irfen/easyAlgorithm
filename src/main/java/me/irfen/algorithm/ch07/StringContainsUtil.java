package me.irfen.algorithm.ch07;

import me.irfen.algorithm.ch01.HashTable;

public class StringContainsUtil {

	/**
	 * 暴力比对法
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean contains(String str1, String str2) {
		for (int i = 0; i < str2.length(); i++) {
			char b = str2.charAt(i);
			int count = 0;
			for (int j = 0; j < str1.length(); j++) {
				char a = str1.charAt(j);
				// 如果字符不等，则累加不等的个数
				if (a != b) {
					count++;
				}
			}
			// 如果最终不等的个数刚好等于str1字符串长度，
			// 说明都不等，也就是不包含
			if (count == str1.length()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 利用快排和双指针比对
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean contains2(String str1, String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		quickSort(c1, 0, c1.length - 1);
		quickSort(c2, 0, c2.length - 1);
		for (int p1 = 0, p2 = 0; p2 < c2.length; p2 ++) {
	        while ((p1 < c1.length) && (c1[p1] < c2[p2])) {
	            p1 ++;
	        }
	        // 如果超出长度或者找到大于的值都说明不包含
	        if ((p1 >= c1.length) || (c1[p1] > c2[p2])) {
	            return false;
	        }
	    }
	    return true;
	}
	
	/**
	 * 素数方式实现字符串包含
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean contains3(String str1, String str2) {
		// 素数数组
		int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 71, 73, 79, 83, 89, 97, 101};
		int all = 1; // 初始化为1
	    for (int i = 0; i < str1.length(); i ++) {
	        int x = prime[str1.charAt(i) - 'A'];
	        // 如果不包含，则累计
	        if (all % x != 0) {
	            all *= x;
	        }
	    }
	    for (int i = 0; i < str2.length(); i ++) {
	        int x = prime[str2.charAt(i) - 'A'];
	        // 依次判断是否包含str2中的字符
	        if (all % x != 0) {
	            return false;
	        }
	    }
		return true;
	}
	
	/**
	 * 散列表方式实现是否包含
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean contains4(String str1, String str2) {
		HashTable hashTable = new HashTable();
		for (int i = 0; i < str1.length(); i++) {
			// 依次把str1中的字符放入散列表
			// 散列表的值没用，随便放个1
			hashTable.put(str1.charAt(i), 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			int value = hashTable.get(str2.charAt(i));
			if (value != 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 使用位运算实现是否包含
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean contains5(String str1, String str2) {
		int result = 0;
		for (int i = 0; i < str1.length(); i ++) {
			result |= (1 << (str1.charAt(i) - 'A'));
		}
		for (int i = 0; i < str2.length(); i ++) {
			if ((result & (1 << (str2.charAt(i) - 'A'))) == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 递归排序
	 * @param src
	 * @param begin
	 * @param end
	 */
	private static void quickSort(char[] src, int begin, int end) {
		if (begin < end) {
			char key = src[begin];
			int i = begin;
			int j = end;

			while (i < j) {
				while (i < j && src[j] > key) {
					j--;
				}
				if (i < j) {
					src[i] = src[j];
					i++;
				}
				while (i < j && src[i] < key) {
					i++;
				}
				if (i < j) {
					src[j] = src[i];
					j--;
				}
			}

			src[i] = key;

			quickSort(src, begin, i - 1);
			quickSort(src, i + 1, end);
		}

	}
}
