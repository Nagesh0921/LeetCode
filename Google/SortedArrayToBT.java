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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0, end = nums.length-1;
        return convertBST(start, end, nums);
    }
    
    public TreeNode convertBST(int start, int end, int[] nums){
        if (end < start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertBST(start, mid-1, nums);
        node.right = convertBST(mid+1, end, nums);
        return node;
    }
}

//Time Complexity O(N) and Space Complexity O(N+LogN). LogN is for recurssive stack.
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
//Memory Usage: 38.8 MB, less than 43.06% of Java online submissions for Convert Sorted Array to Binary Search Tree.
