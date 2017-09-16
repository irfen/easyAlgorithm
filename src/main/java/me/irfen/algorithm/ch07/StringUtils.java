package me.irfen.algorithm.ch07;

public class StringUtils {

	/**
	 * 判断回文字符串
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome(String str) {
		if (str == null || str.length() == 0) {
			throw new RuntimeException("字符串为空");
		}
		int middle = (str.length() - 1) / 2;
		for (int i = 0; i <= middle; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 计算回文字符最大子串长度
	 * @param str
	 * @return
	 */
	public static int longestPalindrome(String str) {
	    if (str == null || str.length() < 1) {
	    	return 0;
	    }
	    int max = 0, current = 0, length = str.length();

	    // 循环每个字符为回文的中点
	    for (int i = 0; i < length; ++i) {
	    	// 考虑回文子串为奇数长度的情况
	        for (int j = 0; i - j >= 0 && i + j < length; j++) {
	        	// 如果不想等，则不继续累加回文子串长度
	            if (str.charAt(i - j) != str.charAt(i + j)) {
	            	break;
	            }
	            current = j * 2 + 1;
	        }
	        // 如果得到的长度比max大，则更新max
	        if (current > max) {
	        	max = current;
	        }
	        // 重置current（其实这里不重置也不影响后面的结果）
	        current = 0;
	        // 考虑回文子串为偶数长度的情况
	        for (int j = 0; (i - j >= 0) && (i + j + 1 < length); j++){
	            if (str.charAt(i - j) != str.charAt(i + j + 1)) {
	            	break;
	            }
	            current = j * 2 + 2;
	        }
	        if (current > max) {
	        	max = current;
	        }
	    }
	    return max;
	}
	
	public static int toInt(String str) {
		if (str == null || str.length() == 0) {
			throw new RuntimeException("字符串为空");
		}
		// 转换结果
		int result = 0;
		// 转换的字符
		int current = 0;
		// 整数的正负
		char sign = '+';
		// 如果首位是符号的话，赋值符号正负
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			sign = str.charAt(0);
			// 如果有符号，则转换内容截取掉首位字符
			str = str.substring(1);
		}
		// 是否需要判断溢出
		boolean judgeOverflow = true;
		if (str.length() > 10) {
			throw new RuntimeException("整型溢出了");
		} else if (str.length() < 10) {
			judgeOverflow = false;
		}
		for (int i = 0; i < str.length(); i++) {
			current = str.charAt(i) - '0';
			if (current > 9 || current < 0) {
				throw new RuntimeException("包含非整型数字字符");
			}
			if (judgeOverflow) {
				if (sign == '+'
						&& (result == 0 || result == Integer.MAX_VALUE / (int) Math.pow(10, 9 - i + 1))
						&& current > Integer.MAX_VALUE / (int) Math.pow(10, 9 - i) % 10) {
					System.err.println(current);
					throw new RuntimeException("整型溢出了");
				}
				if (sign == '-'
						&& (result == 0 || result == -(Integer.MIN_VALUE / (int) Math.pow(10, 9 - i + 1)))
						&& current > -(Integer.MIN_VALUE / (int) Math.pow(10, 9 - i) % 10)) {
					System.err.println(current);
					throw new RuntimeException("整型溢出了");
				}
			}
			result = result * 10 + current;
		}
		if (sign == '-') {
			result = - result;
		}
		return result;
	}
}
