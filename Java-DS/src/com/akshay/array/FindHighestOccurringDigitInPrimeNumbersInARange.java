package com.akshay.array;


import java.util.*;
import java.lang.*;
import java.io.*;

class FindHighestOccurringDigitInPrimeNumbersInARange {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter test cases count");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Enter test cases number : " + i);
            String arr = sc.nextLine();
            int s = Integer.parseInt(arr.split(" ")[0]);
            int e = Integer.parseInt(arr.split(" ")[1]);
            System.out.println(getRes(s, e));
        }
    }

    private static int getRes(int s, int e) {
        TreeMap<Integer, TreeSet<Integer>> res = new TreeMap<>();
        TreeMap<Integer, Integer> resCount = new TreeMap<>();
        boolean[] prime = new boolean[e+1];

        shelevePrimes(prime, e);
        for (int i = 0;i < prime.length;i++) {
            System.out.print(prime[i] + " ");
        }


        for(int i = s; i <= e; i++) {
            if(!prime[i]) {
                int num = i;
                int last;
                while(num > 0) {
                    last = num%10;
                    if(!resCount.containsKey(last)) {
                        resCount.put(last, 0);
                    }
                    resCount.put(last, resCount.get(last)+1);
                    num = num/10;
                }
            }
        }

        for(Map.Entry<Integer, Integer> x : resCount.entrySet()) {
            if(!res.containsKey(x.getValue())) {
                res.put(x.getValue(), new TreeSet<>());
            }
            res.get(x.getValue()).add(x.getKey());
        }

        return res.get(res.lastKey()).last();
    }


    private static void shelevePrimes(boolean[] prime, int end) {
        for(int i = 2; i*i <= end; i++) {
            if(prime[i] == false) {
                for(int j = 2*i; j <= end; j = i+j ) {
                    prime[j] = true;
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i < n/2; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

}