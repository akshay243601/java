package practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTree {

    private static void printLevelTree(Tree tree) {
        if(tree != null) {
            Queue<Tree> queue = new LinkedList<>();
            queue.add(tree);
            while(!queue.isEmpty()) {
                Tree temp = queue.poll();
                System.out.print(temp.data + " --> ");
                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);
        tree.left.left.left = new Tree(8);
        TreeUtil.printTree(tree);

        System.out.println();
        printLevelTree(tree);

    }
}
