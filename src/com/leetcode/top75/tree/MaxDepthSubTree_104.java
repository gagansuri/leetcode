package com.leetcode.top75.tree;

public class MaxDepthSubTree_104 {
    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]


        /*
                        3
              9                 20
                           15       7
         */


        TreeNode r1l2  = new TreeNode(15);
        TreeNode r1r2  = new TreeNode(7);
        TreeNode r1  = new TreeNode(20, r1l2, r1r2);

        TreeNode l1  = new TreeNode(9);

        TreeNode root = new TreeNode(3, l1,r1);

        System.out.println(maxDepth(root));

    }

/**
 * Definition for a binary tree node.
 */
 static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left    =   maxDepth(root.left);
        int right   =   maxDepth(root.right);

        if(left > right) {
            return left+1;
        } else {
            return right+1;
        }

    }
}