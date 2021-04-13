package practice.tree;

public class TreeUtil {
    public static void printTree(Tree tree) {
        if(tree != null) {
            printTree(tree.left);
            System.out.print(tree.data + "  ,  ");
            printTree(tree.right);
        }
    }
}
