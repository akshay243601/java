package com.akshay.dynamicProgramming;


// 0, 1, 1, 2, 3, 5, 8, 13.....
public class FibonnaciSeries {
    static int getFibbanocci(int n) {
        int dp[] = {0, 1};
        if(n < 2) {
            return dp[n];
        }
        int counter = 2;
        int nextFib = dp[0] + dp[1];
        while(counter <= n) {
            nextFib = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = nextFib;
            counter++;
        }
        return nextFib;
    }

    public static void main(String[] args) {
        System.out.println(getFibbanocci(0));
        System.out.println(getFibbanocci(1));
        System.out.println(getFibbanocci(2));
        System.out.println(getFibbanocci(3));
        System.out.println(getFibbanocci(4));
        System.out.println(getFibbanocci(5));
        System.out.println(getFibbanocci(6));
        System.out.println(getFibbanocci(7));
    }
}
