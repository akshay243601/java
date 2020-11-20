package com.akshay.array;

public class FindKthLargestElement {

    private static int getKthLarElement(int[] arr, int k) {
        if(arr == null || arr.length <  k) {
            return -1;
        }
        return getKthLarElement(arr, 0, arr.length-1, k);
    }

    private static int getKthLarElement(int[] arr, int l, int r, int k) {
        int index =  partition(arr, l, r);
        if(index == k - 1) {
            return arr[index];
        }
        if(index < k) {
            return getKthLarElement(arr, index + 1, r, k);
        } else {
            return getKthLarElement(arr, l, index - 1, k);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int pIndex = l;
        for(int i = l; i <= r; i++) {
            if(a[i] < pivot) {
                int temp = a[pIndex];
                a[pIndex] = a[i];
                a[i] = temp;
                pIndex++;
            }
        }

        int temp = a[pIndex];
        a[pIndex] = a[r];
        a[r] = temp;
        return pIndex;
    }


    public static void main(String[] args) {
        System.out.println(getKthLarElement(new int[]{2,4,6,1,7,3}, 1));
        System.out.println(getKthLarElement(new int[]{2,4,6,1,7,3}, 2));
        System.out.println(getKthLarElement(new int[]{2,4,6,1,7,3}, 3));
        System.out.println(getKthLarElement(new int[]{2,4,6,1,7,3}, 4));
        System.out.println(getKthLarElement(new int[]{2,4,6,1,7,3}, 5));

        System.out.println(getKthLarElement(new int[]{10,4,5,1,2,3}, 2));
        System.out.println(getKthLarElement(new int[]{10,4,5,1,2,3}, 4));
        System.out.println(getKthLarElement(new int[]{10,4,5,1,2,3}, 6));
    }
}
