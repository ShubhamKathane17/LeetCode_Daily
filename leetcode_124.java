// 124. Binary Tree Maximum Path Sum
// optimal approach using recursion to find the answer in the left subtree and the right subtree
// tc - O(n)
// asc - O(1) 
// sc - O(logn) - recursion stack -  depth of the binary tree or the recursion

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
    int maxSum;
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int koiEkAchha = root.val + Math.max(left, right);
        int onlyRootAchha = root.val;
        int neecheHiMilgyaAns = left + right + root.val;

        maxSum = Math.max(maxSum, Math.max(koiEkAchha, Math.max(onlyRootAchha, neecheHiMilgyaAns)));


        return Math.max(koiEkAchha, onlyRootAchha);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}
