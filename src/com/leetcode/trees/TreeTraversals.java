package com.leetcode.trees;

public class TreeTraversals {


    // LDR Left Data Right
    static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print("   "+ root.val);  // add to global list
        inorder(root.right);
    }


    //DLR -- data left right
    static void preorder(TreeNode root) {
        if(root == null) return;
        System.out.print("   "+ root.val);
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(TreeNode root) {
        //LRD  left right data

        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print("   "+ root.val);

    }

    public static void main(String[] args) {
// root = [2,1,3]
//  root = [5,1,4,null,null,3,6]
        TreeNode r1l2 = new TreeNode(3);
        TreeNode r1r2 = new TreeNode(6);


        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(4, r1l2, r1r2);

        TreeNode root = new TreeNode(5, l1, r1);
        System.out.println(" PreOrder D L R");
        preorder(root);

        System.out.println(" In Order L D R");
        inorder(root);

        System.out.println(" Post Order L R D");
        postorder(root);

    }
}
