package com.akshay.tree;

public class TotalNumberOfBSTAndBinaryTree {

    // This will fail for even 7 because limit exceed
    //Total number of possible Binary Search Trees with n different keys (countBST(n)) = Catalan number Cn = (2n)! / ((n + 1)! * n!)
    private static int countBSTUsingFormula(int n) {
        return factorial(2*n)/(factorial(n+1) * factorial(n));
    }

    //Count BINARY SEARCH TREE
    private static int countBST(int n) {
        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;

        // Its a form of Catalan formula
        // T[4] = T[0]*T[3] + T[1]*T[2] + T[2]*T[1] + T[3]*T[0];
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                T[i]  = T[i] + T[j]*T[i-j - 1];
            }
        }

        return T[n];
    }

    //Count BINARY TREE
    //countBT = countBST * factorial(n)
    private static int countBT(int n) {
        return factorial(n) * countBST(n);
    }

    private static int factorial(int n) {
        if(n < 2) {
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(countBST(5));
        System.out.println(countBSTUsingFormula(5));
        System.out.println(countBT(5));


        System.out.println(countBST(6));
        System.out.println(countBSTUsingFormula(6));
        System.out.println(countBT(6));


        System.out.println(countBST(7));
        System.out.println(countBSTUsingFormula(7));
        System.out.println(countBT(7));

    }
}
