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
        if(nums[start] > nums[end]) {
            if(nums[start] > nums[middle]) {
                return smallestElement(nums, start, middle);
            } else {
                return smallestElement(nums, middle + 1, end);
            }
        } else {
            if(nums[end] > nums[middle]) {
                return smallestElement(nums, start, middle);
            } else {
                return smallestElement(nums, middle + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1,2,3}));
        System.out.println(findMin(new int[]{0,1,2,3}));
        System.out.println(findMin(new int[]{8,9,10,1,2,3,4,6,7}));
        System.out.println(findMin(new int[]{8,9,10,7}));

    }
}