package com.leetcode;

public class FindKthMissingPositiveNumber_1539 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,7,11};
        int k = 5;
        int[] nums1 = new int[]{1,2,3,4};
        int k1 = 2;

        System.out.println(findKthPositive(nums,k));
    }
        public static int findKthPositive(int[] arr, int k) {
            int count = 0 ;
            for(int i = 1, j = 0 ; i <= arr[arr.length -1] +k ;i++) {
                if(j < arr.length -1 && i != arr[j]) {
                    count++;
                } else if (j >= arr.length -1 ) {
                    count++;
                }else {
                    j++;
                }

                if(k == count) {
                    return i;
                }
                // 1 5 6 8 9 10
            }
            return -1;
        }
    }

