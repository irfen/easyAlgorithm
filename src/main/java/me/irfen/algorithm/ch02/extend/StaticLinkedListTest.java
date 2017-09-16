package me.irfen.algorithm.ch02.extend;

public class StaticLinkedListTest {

	public static void main(String[] args) {
		StaticLinkedList link = new StaticLinkedList(10);
		link.insertFirst(2);
		link.insertFirst(1);
		link.insertLast(4);
		link.insertLast(5);
		link.insert(3, 1); // 在下标为1的元素之后插入元素
		link.printAll(); // 1,2,3,4,5
		link.deleteFirst();
		link.deleteLast();
		link.delete(1);
		link.printAll(); // 移除了头尾之后，剩下3个元素，移除下标为1的元素，只剩下两个元素2和4
		System.out.println(link.get(1).getData());
		link.deleteFirst();
		link.deleteFirst();
		System.out.println(link.size());// 从头部全部移出
		
	}
}
