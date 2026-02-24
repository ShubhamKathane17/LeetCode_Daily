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

// brute force - converting each path from root to leaf into binary string and then converting that binary string to decimal using Integer.parseInt()
// tc - O(n^2) - we have to traverse O(h * n) if the tree is balanced then the tc = O(n log n)  & if the tree is skewed then tc goes to O(n ^ 2)
class Solution {
    int sum = 0;
    public void solve(TreeNode root, String curr){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(curr + String.valueOf(root.val), 2);
        }
        solve(root.left, curr + String.valueOf(root.val));
        solve(root.right, curr + String.valueOf(root.val));
    }
    public int sumRootToLeaf(TreeNode root) {
        solve(root, "");     
        return sum;
    }
}

// optimal - using dfs to convert each path to convert into decimal on the go using (curr = curr * 2 + root.val)
// tc - O(n) - each node is visited at most once
class Solution {
    public int dfs(TreeNode root, int curr){
        if(root == null){
            return 0;
        }
        curr = curr * 2 + root.val;
        if(root.left == null && root.right == null){
            return curr;
        }
        return dfs(root.left, curr) + dfs(root.right, curr);
        
    }
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);     
    }
}
