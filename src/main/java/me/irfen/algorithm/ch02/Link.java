package me.irfen.algorithm.ch02;

public class Link {

	private int size = 0;
	
	private Node first;
	
	private Node last;

	/**
	 * 链表的初始化
	 */
	public Link() {
	}
	
	/**
	 * 链表后部插入
	 * @param data
	 */
	public void addLast(int data) {
		if (size == 0) {
			// 为空初始化前后元素
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			last.setNext(node);
			last = node; // 把最后插入的元素设置为链表尾元素
		}
		size ++;
	}
	
	/**
	 * 链表头部插入
	 * @param data
	 */
	public void addFirst(int data) {
		if (size == 0) {
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			node.setNext(first); // 把元素的下一个位置的指针指向头元素
			first = node; // 把刚插入的元素设置为链表头元素
		}
		size ++;
	}
	
	/**
	 * 链表指定位置后面插入
	 * @param data 需要插入的数据
	 * @param index 下标从0开始
	 */
	public void add(int data, int index) {
		if (size > index) {
			if (size == 0) {
				// 为空初始化前后元素
				fillStart(data);
				size ++;
			} else if (index == 0) {
				addFirst(data);
			} else if (size == index + 1) {
				// 往最后加的话直接调用addLast
				addLast(data);
			} else {
				Node temp = get(index);
				Node node = new Node();
				node.setData(data);
				node.setNext(temp.getNext());
				temp.setNext(node);
				size ++;
			}
		} else {
			throw new IndexOutOfBoundsException("链表没有那么长哦~");
		}
	}
	
	/**
	 * 删除链表头部元素
	 */
	public void removeFirst() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素的呦~");
		} else if (size == 1) {
			// 只剩一个的时候需要清楚first和last
			clear();
		} else {
			Node temp = first;
			first = temp.getNext();
			temp = null; // 帮组空间回收
			size --;
		}
	}
	
	/**
	 * 删除链表尾部元素
	 */
	public void removeLast() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素的呦~");
		} else if (size == 1) {
			// 只剩一个的时候需要清楚first和last
			clear();
		} else {
			Node temp = get(size - 2); // 获取最后元素之前的一个元素
			temp.setNext(null); // 帮组空间回收
			size --;
		}
	}
	
	/**
	 * 删除链表中间的元素
	 * @param index
	 */
	public void removeMiddle(int index) {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素的呦~");
		} else if (size == 1) {
			// 只剩一个的时候需要清楚first和last
			clear();
		} else {
			if (index == 0) {
				removeFirst();
			} else if (size == index - 1) {
				removeLast();
			} else {
				Node temp = get(index - 1); // 获取要删元素之前的一个元素
				Node next = temp.getNext();
				temp.setNext(next.getNext());
				next = null; // 帮组空间回收
				size --;
			}
		}
	}
	
	/**
	 * 获取指定下标元素
	 * @param index
	 * @return
	 */
	public Node get(int index) {
		Node temp = first;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	/**
	 * 打印所有元素数据
	 */
	public void printAll() {
		// 当然也可以用do...while实现
		Node temp = first;
		System.out.println(temp.getData());
		for (int i = 0; i < size - 1; i++) {
			temp = temp.getNext();
			System.out.println(temp.getData());
		}
	}
	
	/**
	 * 反转链表
	 */
	public void reverse() {
		Node temp = first;
		last = temp;
		Node next = first.getNext();
		for (int i = 0; i < size - 1; i++) {
			Node nextNext = next.getNext(); // 下下个
			next.setNext(temp);
			temp = next;
			next = nextNext;
		}
		last.setNext(null);
		first = temp;
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * 在链表插入第一个元素的时候，头尾元素都是一个元素
	 * @param data
	 */
	private void fillStart(int data) {
		first = new Node();
		first.setData(data);
		last = first;
	}
	
	/**
	 * 在元素只有一个的时候清除first和last元素
	 */
	private void clear() {
		first = null;
		last = null;
		size = 0;
	}
	
}
