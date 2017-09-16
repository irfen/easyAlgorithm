package me.irfen.algorithm.ch03;

public class InsertSort {

	private int[] array;

    public InsertSort(int[] array) {
        this.array = array;
    }
	
	public void sort() {
		if (array == null) {
			throw new RuntimeException("array is null");
		}
		int length = array.length;
		if (length > 0) {
			for (int i = 1; i < length; i++) {
				int temp = array[i];
				int j = i;
				for (; j > 0 && array[j - 1] > temp; j--) {
					array[j] = array[j - 1];
				}
				array[j] = temp;
			}
		}
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
