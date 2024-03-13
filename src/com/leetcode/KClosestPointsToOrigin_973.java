package com.leetcode;

import java.util.*;

public class KClosestPointsToOrigin_973 {

    public static void main(String[] args) {
        int[][] points ={{0,1},{1,0}};
        System.out.println(new KClosestPointsToOrigin_973().kClosest(points, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        // add points to the priority Queue and sort based on distance from origin
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (p1, p2) ->
                calculateDistanceFromOrigin(p1[0],p1[1]) - calculateDistanceFromOrigin(p2[0],p2[1]));
        int[][] result = new int[k][2];
        for(int[] n : points) {
            minHeap.add(n);
        }

        for(int i = 0 ; i < k ; i++) {
            result[i] = minHeap.remove();
        }
        return result;
    }

    int calculateDistanceFromOrigin(int x, int y) {
        return y*y + x*x;
    }
        public int[][] kClosest1(int[][] points, int k) {
            Map<Integer,Integer> distanceMap = new HashMap<>();
            for(int i = 0 ; i < points.length ; i++) {
                distanceMap.put(i, calculateDistanceFromOrigin(points[i][0], points[i][1]));
            }

            System.out.println("distanceMap : "+ distanceMap);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>( (i,j) -> distanceMap.get(i).compareTo(distanceMap.get(j)));

            for(int i = 0 ; i < points.length; i++) {
                minHeap.add(i);
            }

            int[][] result = new int[k][2];
            for(int i = 0 ; i < k; i++) {
                int index = minHeap.remove();
                result[i]=points[index];
            }
            return result;
        }


    }
