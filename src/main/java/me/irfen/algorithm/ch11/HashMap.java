package me.irfen.algorithm.ch11;

import java.util.Arrays;

public class HashMap<K, V> {

	/**
	 * 默认散列表初始化长度（16）
	 */
	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

	/**
	 * 默认扩容因子
	 */
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	/**
	 * 散列表数组
	 */
	private Entry<K, V>[] table;
	
	/**
	 * 扩容因子
	 */
	final float loadFactor;
	
	private int size = 0; // 散列表元素个数
	private int use = 0; // 散列表使用数组元素数

	
	public HashMap() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public HashMap(int initCapacity) {
		this(initCapacity, DEFAULT_LOAD_FACTOR);
	}

	public HashMap(int initCapacity, float loadFactor) {
		this.table = new Entry[initCapacity];
		this.loadFactor = loadFactor;
	}

	/**
	 * 添加/修改
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		if (e == null) {
			// 不存在值，向链表添加，有可能需要扩容
			table[index] = new Entry<K, V>(key, value, null);
			size++;
			use++;
			// 不存在值，说明是个未用过的地址，需要判断是否需要扩容
			// 其实这里可以使用size判断，可以保持某一个数组元素下的链表不要太长
			if (use >= table.length * loadFactor) {
				resize();
			}
		} else {
			// 本身存在值，修改已有的值
			for (; e != null; e = e.next) {
				Object k = e.key;
				if (k == key || k.equals(key)) {
					e.value = value;
					return;
				}
			}
			// 不存在相同的值，直接往链表添加元素
			Entry<K, V> temp = table[index];
			Entry<K, V> newEntry = new Entry<K, V>(key, value, temp);
			table[index] = newEntry;
			size++;
		}
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public void remove(K key) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		Entry<K, V> pre = null;
		for (; e != null; pre = e, e = e.next) {
			K k = e.key;
			if (k == key || k.equals(key)) {
				if (pre == null) {
					// 说明删除的是第一个元素
					table[index] = null;
				} else {
					pre.next = e.next;
					size--;
				}
				return;
			}
		}
	}

	/**
	 * 获取
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		for (; e != null; e = e.next) {
			Object k = e.key;
			if (k == key || k.equals(key)) {
				return e.value;
			}
		}
		// 没有找到返回null
		return null;
	}
	
	/**
	 * 想想这里为什么不直接get之后判断是否为空呢
	 * @param key
	 * @return
	 */
	public boolean containsKey(K key) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		for (; e != null; e = e.next) {
			Object k = e.key;
			if (k == key || k.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 清空散列表
	 */
	public void clear() {
		Arrays.fill(table, null);
        size = 0;
        use = 0;
	}

	/**
	 * 获取散列表中元素个数
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 根据key，通过哈希函数获取位于散列表数组中的哪个位置
	 * 
	 * @param key
	 * @return
	 */
	private int hash(K key) {
		int hashCode = Math.abs(key.hashCode());
		hashCode %= table.length;
		return hashCode;
	}

	/**
	 * 扩容
	 */
	private void resize() {
		int newLength = table.length * 2;
		Entry<K, V>[] oldTable = table;
		table = new Entry[newLength];
		use = 0;
		for (int i = 0; i < oldTable.length; i++) {
			Entry<K, V> e = oldTable[i];
			while (null != e) {
				// 重新计算哈希值，放入新的地址中
				int index = hash(e.key);
				if (table[index] == null) {
					use++;
					table[index] = new Entry<K, V>(e.key, e.value, null);
				} else {
					Entry<K, V> temp = table[index];
					Entry<K, V> newEntry = new Entry<K, V>(e.key, e.value, temp);
					table[index] = newEntry;
				}
				e = e.next;
			}
		}
	}

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
