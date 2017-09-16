package me.irfen.algorithm.ch05;

public class HeapTest {

	public static void main(String[] args) {
		Heap heap = new Heap(100);
		heap.insert(9);
		heap.insert(18);
		heap.insert(34);
		heap.insert(15);
		heap.insert(29);
		heap.insert(66);
		heap.insert(12);
		heap.insert(48);
		
		heap.printAll();
		
		heap.delete();
		heap.printAll();
	}
}
