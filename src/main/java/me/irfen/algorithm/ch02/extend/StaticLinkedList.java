package me.irfen.algorithm.ch02.extend;

public class StaticLinkedList {

    private Element[] elements;

    private int head;

    private int tail;

    private int unUsed;

    private int size;

    /**
     * 初始化操作
     * @param capacity
     */
    public StaticLinkedList(int capacity) {
        elements = new Element[capacity];
        unUsed = 0;
        for (int i = 0; i < capacity - 1; i++) {
            elements[i] = new Element();
            elements[i].setCur(i + 1);
        }
        elements[capacity - 1] = new Element();
        elements[capacity - 1].setCur(-1);
    }

    /**
     * 链表指定位置后面插入
     * @param data 要插入的值
     * @param index 链表位置（不是数组下标）
     */
    public void insert(int data, int index) {
        if (index == 0) {
            insertFirst(data);
        } else if (index == size) {
            insertLast(data);
        } else {
            checkFull();
            // 获取要插入元素的前一个元素
            Element preElement = get(index);
            // 获取一个未使用的元素作为要插入的元素
            Element unUsedElement = elements[unUsed];
            // 记录要插入元素的数组下标
            int temp = unUsed;
            // 把从备用链表中拿出来的元素的下一个元素的数组下标设为备用链表头
            unUsed = unUsedElement.getCur();
            // 把要插入元素的指针设为原本前一个元素的指针指向的下标值（链表插入操作）
            unUsedElement.setCur(preElement.getCur());
            // 把前一个元素的指针指向插入的元素下标
            preElement.setCur(temp);
            // 赋值
            unUsedElement.setData(data);
            // 链表长度加1
            size ++;
        }
    }

    /**
     * 链表前端插入
     * @param data
     */
    public void insertFirst(int data) {
        checkFull();
        Element unUsedElement = elements[unUsed];
        int temp = unUsed;
        unUsed = unUsedElement.getCur();
        unUsedElement.setCur(head);
        unUsedElement.setData(data);
        head = temp;
        size ++;
    }

    /**
     * 链表尾插入
     * @param data
     */
    public void insertLast(int data) {
        checkFull();
        Element unUsedElement = elements[unUsed];
        int temp = unUsed;
        unUsed = unUsedElement.getCur();
        elements[tail].setCur(temp);
        unUsedElement.setData(data);
        tail = temp;
        size ++;
    }

    /**
     * 链表头删除
     */
    public void deleteFirst() {
        checkEmpty();
        Element deleteElement = elements[head];
        int temp = head;
        head = deleteElement.getCur();
        deleteElement.setCur(unUsed);
        unUsed = temp;
        size --;
    }

    /**
     * 链表尾删除
     */
    public void deleteLast() {
        delete(size - 1);
    }

    /**
     * 删除指定位置元素
     * @param index 链表中的第几个元素（不是数组下标）
     */
    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
        } else {
            checkEmpty();
            Element pre = get(index - 1);
            int del = pre.getCur(); // 这个是数组的下标
            Element deleteElement = elements[del];
            pre.setCur(deleteElement.getCur());
            if (index == size - 1) {
                tail = index - 1;
            }
            deleteElement.setCur(unUsed);
            unUsed = del;
            size --;
        }
    }

    /**
     * 获取链表元素
     * @param index 链表的第几个元素（不是数组下标）
     * @return
     */
    public Element get(int index) {
    	checkEmpty();
        Element element = elements[head];
        for (int i = 0; i < index; i++) {
            element = elements[element.getCur()];
        }
        return element;
    }

    /**
     * 顺序打印所有元素值
     */
    public void printAll() {
        Element element = elements[head];
        System.out.println(element.getData());
        for (int i = 1; i < size; i++) {
            element = elements[element.getCur()];
            System.out.println(element.getData());
        }
    }

    public int size() {
        return size;
    }

    private void checkFull() {
        if (size == elements.length) {
            throw new IndexOutOfBoundsException("数组不够长了啊");
        }
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("现在链表为空哦");
        }
    }
}
