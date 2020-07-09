package com.akshay.tree;

public class IsTreeSymetricOrMirrorTree {

    public boolean isSymmetric(TreeNode node) {
        if(node == null)
        {
            return true;
        }

        return isSymmetric(node, node);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        else if(node1 == null || node2 == null){
            return false;
        }

        if(
                node1.data == node2.data &&
                isSymmetric(node1.left, node2.right) &&
                isSymmetric(node1.right, node2.left))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}