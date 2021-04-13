package com.akshay.dynamicProgramming;

public class NumberOfWaysToReachNthStair {

    //#Approach 1
    //k = 3. i.e. can climb 1 step, 2 step, or 3 step
    private static int getWays(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return getWays(n-3) + getWays(n-2) + getWays(n-1);
    }


    //#Approach 2 :: GOOD
    private static int getWaysUsingDP(int n) {
        int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        T[2] = 2;

        for (int i = 3; i < n+1; i++) {
            T[i] = T[i-1] + T[i-2] + T[i-3];
        }
        return T[n];
    }

    //Approach 3 If K steps Array is giving
    private static int getWaysUsingDPWithStpArray(int n, int[] steps) {
        int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        T[2] = 2;

        for (int i = 3; i < n+1; i++) {
            for (int j = 0; j < steps.length; j++) {
                if(i-steps[j] >= 0) {
                    T[i] = T[i] + T[i-steps[j]];
                }
            }
        }
        return T[n];
    }


    public static void main(String[] args) {
        System.out.println(getWays(4));
        System.out.println(getWaysUsingDP(4));
        int[] steps = {1, 2, 3};
        System.out.println(getWaysUsingDPWithStpArray(4, steps));


        System.out.println(getWays(5));
        System.out.println(getWaysUsingDP(5));
        System.out.println(getWaysUsingDPWithStpArray(5, steps));

        System.out.println(getWays(6));
        System.out.println(getWaysUsingDP(6));
        System.out.println(getWaysUsingDPWithStpArray(6, steps));


        System.out.println(getWays(7));
        System.out.println(getWaysUsingDP(7));
        System.out.println(getWaysUsingDPWithStpArray(7, steps));


    }
}
