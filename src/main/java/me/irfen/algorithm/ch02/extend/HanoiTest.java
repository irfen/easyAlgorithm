package me.irfen.algorithm.ch02.extend;

public class HanoiTest {

	public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            // 只有一个圆盘需要移动的时候移动完结束
            move(A, C);
            return;
        }
        // 先把A上的n-1个圆盘移动到B上
        hanoi(n - 1, A, C, B);
        // 把A上最后一个圆盘移动到C上
        move(A, C);
        // 接下来递归，把B上的n-1个圆盘移动到C上
        hanoi(n - 1, B, A, C);
    }

	/**
	 * 把A最上面的圆盘移动到C上去
	 * @param A
	 * @param C
	 */
    private static void move(char A, char C) {
        System.out.println(A + "-->" + C);
    }

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }
}
