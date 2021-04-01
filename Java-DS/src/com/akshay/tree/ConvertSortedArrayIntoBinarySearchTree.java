package com.akshay.tree;

public class ConvertSortedArrayIntoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }

        int middle = l + (r-l)/2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBSTHelper(nums, l, middle-1);
        node.right = sortedArrayToBSTHelper(nums, middle+1, r);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayIntoBinarySearchTree _instance = new ConvertSortedArrayIntoBinarySearchTree();
        TreeNode bst = _instance.sortedArrayToBST(new int[] {-10,-3,0,5,9});
    }
}
