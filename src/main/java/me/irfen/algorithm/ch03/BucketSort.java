package me.irfen.algorithm.ch03;

public class BucketSort {

    private int[] buckets;
    private int[] array;

    public BucketSort(int range, int[] array) {
        this.buckets = new int[range];
        this.array = array;
    }

    /**
     * 排序
     */
    public void sort() {
        if (array != null && array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                buckets[array[i]] ++;
            }
        }
    }

    /**
     * 从大到小排序
     */
    public void print() {
        // 倒序输出数据
        for (int i = buckets.length - 1; i >= 0; i--) {
            // 元素中值为几，说明有多少个相同值的元素，则输出几遍
            for (int j = 0; j < buckets[i]; j ++) {
                System.out.println(i);
            }
        }
    }
}
