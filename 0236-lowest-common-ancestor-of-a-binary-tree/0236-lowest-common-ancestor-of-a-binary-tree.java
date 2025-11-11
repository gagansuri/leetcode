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
    
    private TreeNode result = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
         lowestCommonAncestorR(root, p, q);
         return result;
    }
    
    public boolean lowestCommonAncestorR(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        //post order
        boolean left = lowestCommonAncestorR(root.left, p , q);
        boolean right = lowestCommonAncestorR(root.right, p, q);

        boolean curr = (root == p || root == q) ? true : false;

        if((left && right) || (left && curr) || (curr && right)) result  = root;

        return left || right || curr;

    }
}
   