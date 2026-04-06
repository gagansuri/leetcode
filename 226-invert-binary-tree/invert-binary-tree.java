/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode invertTree(TreeNode root){    
        if(root == null ) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null) invertTree(root.left);
        
        if(root.right != null) invertTree(root.right);

        return root;
    }
    public TreeNode invertTree1(TreeNode root) {
        // take swap left and right nodes and continue

        if(root == null) return null;

        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    
    }
    public TreeNode dfsTree(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            System.out.println("");

        }
        return null;
    }
}