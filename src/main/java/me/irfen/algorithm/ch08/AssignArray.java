package me.irfen.algorithm.ch08;

public class AssignArray {

	/**
	 * 数组赋值
	 * @param a
	 */
	public static void assign(int[] a) {
		int[] b = new int[a.length];
		b[0] = 1; // 用作临时变量
		for (int i = 1; i < a.length; i++) {
			b[0] *= a[i - 1]; // 从前往后乘 得到Ba;
			b[i] = b[0]; // 此时b[i]为对应的Ba值
		}
		b[0] = 1; // 重置
		for (int i = a.length - 2; i > 0; i--) {
			b[0] *= a[i + 1]; // 从后往前 乘得到Bb;
			b[i] *= b[0]; // 把之前得到的Ba乘以这次得到的Bb
		}
		// 此时的b[0]就是a[2]*...a[n - 1]了
		b[0] *= a[1]; // 不要忘记算出b[0]，乘以a[1]就好
		
		System.out.print("赋值后结果：");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
			if (i != b.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
