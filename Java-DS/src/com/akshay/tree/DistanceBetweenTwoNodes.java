package com.akshay.tree;

public class DistanceBetweenTwoNodes {
    // Just to have a check is Both Nodes are exist or not
    static boolean isPExist = false;
    static boolean isQExist = false;


    private static int getDistanceBetweenTwoNodes(TreeNode root, int p, int q) {
        if(root == null) {
            return -1;
        }

        TreeNode commonAns = getLeastCommonAncestor(root, p, q);
        if(commonAns == null) {
            return -1;
        }

        return getDistanceFromANode(commonAns, p) + getDistanceFromANode(commonAns, q);
    }

    private static TreeNode getLeastCommonAncestor(TreeNode node, int p, int q) {
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

    private static int getDistanceFromANode(TreeNode node, int value) {
        return getDistanceFromANode(node, value, 0);
    }
    private static int getDistanceFromANode(TreeNode node, int value, int distance) {
        if(node == null) {
            return -1;
        }

        if(node.data == value) {
            return distance;
        }

        int leftDis = getDistanceFromANode(node.left, value, distance + 1);
        if(leftDis != -1) {
            return leftDis;
        }

        return getDistanceFromANode(node.right, value, distance + 1);
    }


    public static void main(String[] args) {

        /**
         *              26
         *      10              3
         * 4         6               13
         *
         *
         *
         * ***/


        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(13);
        TreeNode commonAns = getLeastCommonAncestor(root, 26, 3);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);
        System.out.println(getDistanceBetweenTwoNodes(root, 26, 3));


        isPExist = false;
        isQExist = false;
        commonAns = getLeastCommonAncestor(root, 10, 6);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);
        System.out.println(getDistanceBetweenTwoNodes(root, 10, 6));


        isPExist = false;
        isQExist = false;
        commonAns = getLeastCommonAncestor(root, 260, 300);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);
        System.out.println(getDistanceBetweenTwoNodes(root, 260, 300));


        isPExist = false;
        isQExist = false;
        commonAns = getLeastCommonAncestor(root, 4, 6);
        System.out.println(commonAns == null ? "Not present" : commonAns.data);
        System.out.println(getDistanceBetweenTwoNodes(root, 4, 6));

    }
}
