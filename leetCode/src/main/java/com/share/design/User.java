package com.share.design;

import java.util.List;

/**
 * @author Lgq create on 2020/9/10
 */
public class User {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public static void remove(List<User> list) {

        if (list.size() == 0) {
            return;
        }


    }






    public static int[] findTopK(int[] array, int k) {
        int heapArray[] = new int[k];
        for (int i = 0; i < k; i++) {
            heapArray[i] = array[i];
        }
        buildMaxHeap(heapArray);
        for (int i = k; i < array.length; i++) {
            if (array[i] < heapArray[0]) {
                heapArray[0] = array[i];//更新堆顶
                adjustMaxHeap(heapArray, 0, heapArray.length);
            }
        }
        return heapArray;
    }
    /**
     * 构建小顶堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(array, i, array.length);
        }
    }
    /**
     * 调整堆结构
     *
     * @param array
     * @param root   根节点
     * @param length
     */
    public static void adjustMaxHeap(int[] array, int root, int length) {
        int left = root * 2 + 1; //左节点下标，数组下标从0开始，所以加1
        int right = left + 1; //右节点下标
        int largest = root;// 存放三个节点中最大节点的下标
        if (left < length && array[left] > array[root]) { //左节点大于根节点，更新最大节点的下标
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {//右节点大于根节点，最大节点的下标
            largest = right;
        }
        if (root != largest) {
            swap(array, largest, root);
            adjustMaxHeap(array, largest, length);
        }
    }
    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
