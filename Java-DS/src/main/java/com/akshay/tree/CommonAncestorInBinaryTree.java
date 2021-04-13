package com.akshay.tree;

public class CommonAncestorInBinaryTree {

    // Just to have a check is Both Nodes are exist or not
    static boolean isPExist = false;
    static boolean isQExist = false;

    private static TreeNode getCommonAncestor(TreeNode node, int p, int q) {
        TreeNode commonAns = getCommonAncestorHelper(node, p, q);
        if(isPExist && isQExist) {
            return commonAns;
        } else if(!isPExist && !isQExist) {
            return null;
        } else {
            //https://thecodingsimplified.com/find-lowest-common-ancestor-lca-in-binary-tree/
            // This is special handling in which we are checking if one node (p) is ancestor of another node(q) i
            int needToCheck = commonAns.data == p ? q : p;
            if (isElementPresent(commonAns, needToCheck)) {
                return commonAns;
            }
        }
        return null;
    }
    private static TreeNode getCommonAncestorHelper(TreeNode node, int p, int q) {
        if(node == null) {
            return null;
        }

        if(node.data == p) {
            isPExist = true;
            return node;
        }

        if(node.data == q) {
            isQExist = true;
            return node;
        }

        TreeNode leftAnc = getCommonAncestorHelper(node.left, p, q);
        TreeNode rightAnc = getCommonAncestorHelper(node.right, p, q);

        if(leftAnc != null && rightAnc != null) {
            return node;
        }

        return leftAnc != null ? leftAnc : rightAnc;
    }

    private static boolean isElementPresent(TreeNode node, int value) {
        if(node == null) {
            return false;
        }

        if(node.data == value) {
            return true;
        }

        return isElementPresent(node.left, value) || isElementPresent(node.right, value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        TreeNode commonAns = getCommonAncestor(root, 26, 3);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);

        isPExist = false;
        isQExist = false;
        commonAns = getCommonAncestor(root, 10, 6);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);


        isPExist = false;
        isQExist = false;
        commonAns = getCommonAncestor(root, 260, 300);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);


        isPExist = false;
        isQExist = false;
        commonAns = getCommonAncestor(root, 4, 6);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);

    }
}
