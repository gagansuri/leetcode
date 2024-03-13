package com.leetcode;

public class LowestBalancedSubstring_2609 {
    public static void main(String[] args) {
        String s = "01000111";
        s = "011";
        System.out.println(findTheLongestBalancedSubstring(s));

    }

        public static int findTheLongestBalancedSubstring(String s) {
            int max = 0 ;
            for(int i = 0 ; i <s.length();i++) {
                if(s.charAt(i) == '0') {
                    int zeroCount = 0, oneCount = 0;
                    int j = i;
                    while(j < s.length() && s.charAt(j) == '0') {
                        j++; zeroCount++;
                    }

                    while(j < s.length() && s.charAt(j) == '1' && oneCount < zeroCount) {
                        j++; oneCount++;
                    }

                    if(zeroCount == oneCount) {
                        max = Math.max(max, zeroCount+oneCount);
                    }

                }
            }
            return max;
        }
    }

