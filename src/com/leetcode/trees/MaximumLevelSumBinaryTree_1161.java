package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumBinaryTree_1161 {
    public static void main(String[] args) {
        /**
         *                                                          1
 *                                                      7                   0
         *                                      7           -8
         *
         */


        TreeNode l1l2 = new TreeNode(7);
        TreeNode l1r2 = new TreeNode(-8);
        TreeNode l1 = new TreeNode(7, l1l2, l1r2);

        TreeNode r1 = new TreeNode(0, null, null);

        TreeNode root = new TreeNode(1, l1, r1);
        int out = maxLevelSum(root);
        System.out.println(out);
    }

    public static int maxLevelSum(TreeNode root) {
        int maxLevelSum = Integer.MIN_VALUE;
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 0;
        int maximalLevel = -1;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int levelSum = 0 ;
            for(int i = 0 ; i < size;i++) {
                TreeNode node = queue.remove();
                //System.out.println("level : "+ level +" node val: "+node.val);
                levelSum += node.val;
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right !=null) {
                    queue.add(node.right);
                }
            }
            if(levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                maximalLevel = level;
            }
        }
        return maximalLevel;
    }
}
