package com.akshay.array;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/


public class FindMinElementInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        return smallestElement(nums, 0, nums.length-1);
    }

    private static int smallestElement(int[] nums, int start, int end) {
        if(start >= end) {
            return nums[end];
        }
        int middle = (end + start)/2;

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if(middle < end && nums[middle] > nums[middle + 1]) {
            return nums[middle + 1];
        }

        // Check if mid itself is minimum element
        if(start < middle && nums[middle] < nums[middle-1]) {
            return nums[middle];
        }

        // Decide whether we need to go to left half or right half
        if(nums[end] > nums[middle]) {
            return smallestElement(nums, start, middle-1);
        } else {
            return smallestElement(nums, middle + 1, end);
        }
//        if(nums[start] > nums[end]) {
//            if(nums[start] > nums[middle]) {
//                return smallestElement(nums, start, middle);
//            } else {
//                return smallestElement(nums, middle + 1, end);
//            }
//        } else {
//            if(nums[end] > nums[middle]) {
//                return smallestElement(nums, start, middle);
//            } else {
//                return smallestElement(nums, middle + 1, end);
//            }
//        }
    }


    public static int findMinWithoutRecursion(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if(nums[0] < nums[end]) {
            return nums[0];
        }

        if(nums.length == 1) {
            return nums[0];
        }

        while(start < end) {
            int middle = start + (end - start)/2;
            if(nums[middle] > nums[middle + 1]) {
                return nums[middle + 1];
            } else if(nums[middle - 1] > nums[middle]) {
                return nums[middle];
            } else if(nums[middle] > nums[start]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return nums[start];
    }




    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1,2,3}));
        System.out.println(findMin(new int[]{0,1,2,3}));
        System.out.println(findMin(new int[]{8,9,10,1,2,3,4,6,7}));
        System.out.println(findMin(new int[]{8,9,10,1, 2}));
        System.out.println(findMin(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(findMin(new int[]{2,3,4,5,6,1}));
        System.out.println(findMin(new int[]{8,9,10,1, 2,4,5,6,7}));
        System.out.println(findMin(new int[]{7, 18, 26, 6}));
        System.out.println(findMin(new int[]{11,11,12,1,1,3,4,4,5,6,7,9,10}));
        System.out.println(findMin(new int[]{1}));

        System.out.println("Without Recursion below...");
        System.out.println(findMinWithoutRecursion(new int[]{1,2,3}));
        System.out.println(findMinWithoutRecursion(new int[]{0,1,2,3}));
        System.out.println(findMinWithoutRecursion(new int[]{8,9,10,1,2,3,4,6,7}));
        System.out.println(findMinWithoutRecursion(new int[]{8,9,10,1, 2}));
        System.out.println(findMinWithoutRecursion(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(findMinWithoutRecursion(new int[]{2,3,4,5,6,1}));
        System.out.println(findMinWithoutRecursion(new int[]{8,9,10,1, 2,4,5,6,7}));
        System.out.println(findMinWithoutRecursion(new int[]{7, 18, 26, 6}));
        System.out.println(findMinWithoutRecursion(new int[]{11,11,12,1,1,3,4,4,5,6,7,9,10}));
        System.out.println(findMinWithoutRecursion(new int[]{1}));





    }
}