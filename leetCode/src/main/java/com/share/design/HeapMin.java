package com.share.design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Lgq create on 2020/9/10
 */
public class HeapMin {

    transient int hashSeed = 0;

    public static void print(int array[]) {


        //PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        //    @Override
        //    public int compare(Integer o1, Integer o2) {
        //        return o1 - o2;
        //    }
        //});

        //for (int num : array) {
        //    if (pq.size() < 10) {
        //        pq.offer(num);
        //        //如果堆顶元素 > 新数，则删除堆顶，加入新数入堆
        //    } else if (pq.peek() > num) {
        //        pq.poll();
        //        pq.offer(num);
        //
        //    }
        //}
        //int[] result = new int[10];
        //
        //for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
        //    result[i] = pq.poll();
        //}

    }


    public static void main(String[] args) {


        HashMap map = new HashMap<>();


        map.put("lv","11");
    }
}
