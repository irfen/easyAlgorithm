package me.irfen.algorithm.ch02;

public class ArrayQueueTest {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);
		System.out.println(queue.put("A")); // true
		System.out.println(queue.put("B")); // true
		System.out.println(queue.put("C")); // true
		System.out.println(queue.put("D")); // false
		
		System.out.println(queue.isFull());// true，当前队列已经满了，并且D元素没有入队成功
		System.out.println(queue.size()); // 3，队列中有三个元素
		
		System.out.println(queue.peek()); // A，获取队头元素，不出队
		System.out.println(queue.poll()); // A
		System.out.println(queue.poll()); // B
		System.out.println(queue.poll()); // C
		
		System.out.println(queue.isEmpty()); // true，当前队列为空队
	}
}
