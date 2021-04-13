package com.akshay.list;

import java.util.Arrays;
import java.util.Comparator;

public class Test implements Comparator<Test> {
    int disSize;
    public static void main(String[] args) {
        Test[] va = {new Test(60), new Test(200), new Test(60)};
        Arrays.sort(va, va[0]);
        int index = Arrays.binarySearch(va, new Test(40), va[0]);
        System.out.print(index + " " );
        index = Arrays.binarySearch(va, new Test(80), va[0]);
        System.out.print(index);
    }

    public Test(int d) {
        disSize = d;
    }

    @Override
    public int compare(Test a, Test b) {
        return b.disSize - a.disSize;
    }
}
