package me.irfen.algorithm.ch02;

public class ArrayQueue {

    private final Object[] items;

    private int head = 0;

    private int tail = 0;

    /**
     * 初始化队列
     * @param capacity 队列长度
     */
    public ArrayQueue(int capacity) {
        this.items = new Object[capacity];
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean put(Object item) {
        if (head == (tail + 1) % items.length) {
            // 说明队满
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % items.length; // tail标记向后移动一位
        return true;
    }

    /**
     * 获取队列头元素，不出队
     * @return
     */
    public Object peek() {
        if (head == tail) {
            // 说明队空
            return null;
        }
        return items[head];
    }

    /**
     * 出队
     * @return
     */
    public Object poll() {
        if (head == tail) {
            // 说明队空
            return null;
        }
        Object item = items[head];
        items[head] = null; // 把没用的元素赋空值，当然不设置也可以，反正标记移动了，之后会被覆盖
        head = (head + 1) % items.length; // head标记向后移动一位
        return item;
    }
    
    public boolean isFull() {
    	return head == (tail + 1) % items.length;
    }
    
    public boolean isEmpty() {
    	return head == tail;
    }

    /**
     * 队列元素数
     * @return
     */
    public int size() {
        if (tail >= head) {
            return tail - head;
        } else {
            return tail + items.length - head;
        }
    }
    
}
