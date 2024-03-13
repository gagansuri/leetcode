package com.general;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
        maxHeap.add(4);
        maxHeap.add(7);

        maxHeap.add(11);
        maxHeap.add(0);

        maxHeap.add(9);
        maxHeap.add(1);

        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());

    }
    public static void minHeap(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(4);
        minHeap.add(7);

        minHeap.add(11);
        minHeap.add(0);

        minHeap.add(9);
        minHeap.add(1);

        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());

    }
}
