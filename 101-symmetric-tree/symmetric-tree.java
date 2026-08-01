// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//          mirror(root.left);
//          return isIdentical(root.left,root.right);
//     }
//       public boolean isIdentical(TreeNode p, TreeNode q) {
//     if(p==null && q==null) return true;
//     if(p==null || q ==null) return false;
//     if(p.val= q.val) return true;
//     if(!isIdentical(p.left,q.left)) return false;
//      if(!isIdentical(p.right,q.right)) return false;
//     return true;
        
//     }
//     void mirror(TreeNode root) {
//         if(root==null) return ;
//         // Node temp = root.left;
//         root.left = root.right;
//         root.right = temp;
//         mirror(root.left);
//         mirror(root.right);
        
        
//     }
// }
    
    class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isMirror(p.left, q.right) && 
               isMirror(p.right, q.left);
    }
}
