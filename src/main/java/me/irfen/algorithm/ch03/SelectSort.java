package me.irfen.algorithm.ch03;

public class SelectSort {

	private int[] array;
	
	public SelectSort(int[] array) {
		this.array = array;
	}
	
	public void sort() {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				int temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
