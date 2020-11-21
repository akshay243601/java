package com.akshay.tree;

public class IsTreeSymetricOrMirrorTree {

    public static boolean isSymmetric(TreeNode node) {
        if(node == null)
        {
            return true;
        }
        return isSymmetric(node, node);
    }

    public static boolean isSymmetric(TreeNode node1, TreeNode node2) {
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
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(tree.root));

    }
}