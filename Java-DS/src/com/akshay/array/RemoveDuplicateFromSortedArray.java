package com.akshay.array;

// MS:  Remove duplicates and keep the list unique from a Sorted Array
public class RemoveDuplicateFromSortedArray {

    private static void removeDuplicateFromSortedArray(int[] a) {
        System.out.println();
        System.out.println("Before Removing duplicate");
        printArray(a, a.length);
        int j = 0;
        int i;
        for(i = 0; i < a.length-1; i++) {
            if(a[i] != a[i+1]) {
                a[j] = a[i];
                j++;
            }
        }
        a[j] = a[i];
        j++;
        System.out.println("After Removing duplicate");
        printArray(a, j);
    }

    private static void printArray(int[] a, int lastIndex) {
        for(int i = 0; i < lastIndex; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    public static void main(String[] args) {
        removeDuplicateFromSortedArray(new int[]{1, 2, 2, 3, 4, 4, 5, 6,6,6,6,6,7,8,9});
        removeDuplicateFromSortedArray(new int[]{1, 2, 2, 3, 4, 4, 5, 6,6,6,6,6,7,8});
    }
}
