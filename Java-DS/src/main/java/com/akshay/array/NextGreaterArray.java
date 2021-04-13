package com.akshay.array;

import java.util.Stack;

public class NextGreaterArray {

    private static void printNextGreaterArray(int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);
        int element, next;
        for(int i = 1; i < a.length; i++) {
            next=a[i];
            if(!stack.isEmpty()) {
                element = stack.pop();
                while(element < next) {
                    System.out.println(element + "  --->  " + next);
                    if(stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }

                if(next < element) {
                    stack.push(element);
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "   --->   " + "-1");
        }

    }

    public static void main(String[] args) {
        printNextGreaterArray(new int[]{1,2,3,4,5});
        System.out.println();
        printNextGreaterArray(new int[]{5,4,3,2,5});
    }


}
