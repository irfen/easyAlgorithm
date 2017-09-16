package me.irfen.algorithm.ch03;

public class ShellSort {

	private int[] array;
	
	public ShellSort(int[] array) {
		this.array = array;
	}
	
	public void sort() {
		int temp;
		for (int k = array.length / 2; k > 0; k /= 2) {
			for (int i = k; i < array.length; i++) {
				for (int j = i; j >= k; j -= k) {
					if (array[j - k] > array[j]) {
						temp = array[j - k];
						array[j - k] = array[j];
						array[j] = temp;
					}
				}
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
