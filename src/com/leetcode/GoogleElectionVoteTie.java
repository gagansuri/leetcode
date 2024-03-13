package com.leetcode;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GoogleElectionVoteTie {
    public static void main(String[] args) {
        int[] points = {3,5,6,4};

        int[] points2 = {10,15,5, 8 , 7 , 6 , 9 , 12,3,25};
        int sum = 0 ;
        for(int i = 0 ; i < points.length;i++) {
            sum+= points[i];
        }
        int target = sum / 2;
        System.out.println(isSubsetSum(points2,10,target));
    }

    static boolean isSubsetSum(int set[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        /*if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);*/

        // Else, check if sum can be obtained
        // by any of the following
        // (a) including the last element
        // (b) excluding the last element
        return isSubsetSum(set, n - 1, sum)
                || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    static List<Integer> findIfTieDP(int[] points) {
        int[] dp = new int[points.length+1];
        Arrays.fill(dp,-1);
        dp[0] = 0 ;
        for(int i = 0 ; i < points.length ; i++) {
            for(int j = dp.length - 1 ; j >= 0 ; j--) {
                if(dp[j]>=0 && dp[j+points[i]] < 0) {
                    dp[j+points[i]] = i ;
                }
            }
        }
        return null;
    }
    static List<Integer> findIfTie(int[] points) {
        int sum = 0 ;
        for(int i = 0 ; i < points.length;i++) {
            sum+= points[i];
        }
        int target = sum / 2;
        Map<Integer, List<Integer>> lookupSumLocations = new ConcurrentHashMap<>();
        int runningSum = 0 ;
        for(int i = 0 ; i < points.length; i++) {
            int num = points[i];
            if(!lookupSumLocations.containsKey(target - num)) {
                // add new sum
                // till now fetch all
                Set<Integer> sums = lookupSumLocations.keySet();
                for(int key : sums ) {
                    List<Integer> list = new ArrayList<>(lookupSumLocations.get(key));
                    list.add(i);
                    lookupSumLocations.put(key+num, list);
                }
                List<Integer> single = new ArrayList<>();
                single.add(i);
                lookupSumLocations.put(num,single);
            } else {
                List<Integer> result = lookupSumLocations.get(target - num);
                result.add(i);
                return result;

            }
        }
    return null;
    }
}
