package com.leetcode.top75.tree;

import java.util.Set;
import java.util.TreeSet;

public class SmallestNumberInInfiniteSet_2336 {

    class SmallestInfiniteSet {

        private Set<Integer> removed;
        public SmallestInfiniteSet() {
            this.removed = new TreeSet<>();
        }

        public int popSmallest() {
            for(int i = 1 ; i < Integer.MAX_VALUE; i++) {
                if(!removed.contains(i)) {
                    removed.add(i);
                    return i;
                }
            }
            return -1;
        }

        public void addBack(int num) {
            removed.remove(num);
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
