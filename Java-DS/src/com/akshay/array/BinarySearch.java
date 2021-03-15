package com.akshay.array;

public class BinarySearch {

    //# Approach 1 good
    private static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }
    private static int binarySearch(int[] arr, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        int middle = left + (right-left)/2;
        if(arr[middle] == target) {
            return middle;
        } else if(arr[middle] > target) {
            return binarySearch(arr, target, left, middle - 1);
        } else {
            return binarySearch(arr, target, middle + 1, right);
        }
    }

    //# Approach 2 good
    private static int binarySearchWithoutRecursion(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right-left)/2;
            if(arr[middle] == target) {
                return middle;
            } else if(arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,4,6,8,10,18,34};
        int target = 10;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchWithoutRecursion(arr, target));


        target = 100;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchWithoutRecursion(arr, target));


        target = 1;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchWithoutRecursion(arr, target));


    }
}
