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
    int count=0;

    public void countGreatest(TreeNode root, int max) {
        if(root==null) {
            return;
        }
        if(root.val>=max) {
            max=root.val;
            count++;
        }
        countGreatest(root.left, max);
        countGreatest(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        countGreatest(root, root.val);
        return count;
    }
}