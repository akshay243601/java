package com.akshay.tree;

public class CommonAncestorInBST {
    private static TreeNode getCommonAncestorBST(TreeNode node, int p, int q) {
        return getCommonAncestorBSTHelper(node, p, q);
    }
    private static TreeNode getCommonAncestorBSTHelper(TreeNode node, int p, int q) {
        if(node == null) {
            return null;
        }

        if(node.data > p && node.data > q) {
            return getCommonAncestorBSTHelper(node.left, p, q);
        } else if(node.data < p && node.data < q) {
            return getCommonAncestorBSTHelper(node.right, p, q);
        } else {
            if(isElementPresent(node, p) && isElementPresent(node, q)) {
                return node;
            }
            return null;
        }
    }

    private static boolean isElementPresent(TreeNode node, int value) {
        if(node == null) {
            return false;
        }

        if(node.data > value) {
            return isElementPresent(node.left, value);
        } else if(node.data < value) {
            return isElementPresent(node.right, value);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(15);
        root.right = new TreeNode(35);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(18);
        root.right.right = new TreeNode(40);

        // If Both are present
        TreeNode commonAns = getCommonAncestorBST(root, 40, 15);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);


        // If any one is not present
        commonAns = getCommonAncestorBST(root, 400, 35);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);


        // If both are not present
        commonAns = getCommonAncestorBST(root, 400, 350);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);


        // Special Case
        // if one is parent of another
        commonAns = getCommonAncestorBST(root, 15, 10);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);


    }


}
