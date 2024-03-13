package com.leetcode.trees;

import com.leetcode.top75.tree.MaxDepthSubTree_104;

import java.util.ArrayList;
import java.util.List;

public class RangeSumBST_938 extends TreeNode {
    /**
     * Definition for a binary tree node.
     */
    public static void main(String[] args) {
        /*
                                            10
                            5                               15
                    3               7                               18


         */

        TreeNode r1r2 = new TreeNode(18);
        TreeNode r1 = new TreeNode(15, null, r1r2);

        TreeNode l1l2 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(7);
        TreeNode l1 = new TreeNode(5, l1l2, l1r2);

        TreeNode root = new TreeNode(10, l1, r1);
        int out = rangeSumBSTList(root, 7, 15);
        System.out.println(out==32);


        rangeSumBST(root, 7, 15);
        System.out.println(sum==32);
    }

    public static int rangeSumBSTList(TreeNode root, int low, int high) {
        if (root == null) return 0;
        List<Integer> nums = new ArrayList<>();
        rangesumList(root, low, high, nums);
        return nums.stream().reduce(0, (a, b) -> a + b);
    }

    static void rangesumList(TreeNode node, int low, int high, List<Integer> nums) {
        if (node == null) return;

        if (node.val >= low && node.val <= high) {
            nums.add(node.val);
        }

        rangesumList(node.left, low, high, nums);
        rangesumList(node.right, low, high, nums);


    }



    static int sum = 0 ;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        rangesum(root, low, high);
        return sum;
    }

    static  void rangesum(TreeNode node , int low, int high) {
        if(node == null) return ;

        if(node.val >= low && node.val <= high) {
            sum+= node.val;
        }
        if(node.val > low) {
            rangesum(node.left, low, high);
        }
        if(node.val < high) {
            rangesum(node.right, low, high);
        }

    }

}
