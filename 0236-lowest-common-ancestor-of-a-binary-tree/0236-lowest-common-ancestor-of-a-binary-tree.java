/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p,q);
        return result;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        boolean current = (root == p || root == q);

        if((left && right) || (left && current) || (right && current)) {
            result = root;
        }
        return left || right || current; 
    }
    
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //postorder traversal
        // if root == null return
        /// if root  is equal to p or q , return root
        // go to left 
        // go to right
        // if both left are right are not null that is LCA

        if(root == null) return root;

        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,  p,  q);
        TreeNode right = lowestCommonAncestor(root.right,  p,  q);

        if(left !=null && right != null) return root; 

        if(left != null) return left;

        if(right != null) return right;
        return null;
    }
}