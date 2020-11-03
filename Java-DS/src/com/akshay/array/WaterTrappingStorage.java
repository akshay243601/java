package com.akshay.array;

// Expedia
public class WaterTrappingStorage {

    private static int waterStorageCapacity(int[] a) {
        int capacity = 0;
        if(a != null && a.length > 2) {
            int lMax = a[0];
            int rMax = a[a.length-1];
            int l = 0;
            int r = a.length-1;
            while(l < r) {
                if(a[l] < a[r]) {
                    if(a[l] < lMax) {
                        capacity = capacity + lMax - a[l];
                    } else {
                        lMax = a[l];
                    }
                    l++;
                } else {
                    if(a[r] < rMax) {
                        capacity = capacity + rMax - a[r];
                    } else {
                        rMax = a[r];
                    }
                    r--;
                }
            }
        }
        return capacity;
    }

    public static void main(String[] args) {
        System.out.println(waterStorageCapacity(new int[]{3,5,6,7,9}));
        System.out.println(waterStorageCapacity(new int[]{15, 3,9,11,15,1}));
    }

}
