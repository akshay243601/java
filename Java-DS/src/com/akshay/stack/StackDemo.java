package com.akshay.stack;

public class StackDemo {

	public final int STACK_SIZE = 1000;
	public int[] stack = new int[STACK_SIZE];
	public int top = -1;

	public void push(int value) {
		if (top >= STACK_SIZE) {
			System.out.println("Stack Overflow");
		} else {

			stack[++top] = value;
		}
	}

	public void pop() {
		if (top < 0) {
			System.out.println("Stack underflow");
		} else {
			stack[top] = -1;
			--top;
		}
	}

	public static void main(String args[]) {
		StackDemo obj = new StackDemo();
		obj.push(4);
		obj.push(6);
		obj.push(21);
		obj.push(454);
		System.out.println("After Push");
		for (int i = 0; i <= obj.top; i++) {
			System.out.print(obj.stack[i] + "  ");
		}

		obj.pop();
		System.out.println();
		System.out.println("After pop");
		for (int i = 0; i <= obj.top; i++) {
			System.out.print(obj.stack[i] + "   ");
		}

		obj.pop();
		System.out.println();
		System.out.println("After pop");
		for (int i = 0; i <= obj.top; i++) {
			System.out.print(obj.stack[i] + "   ");
		}
		obj.push(24243);
		System.out.println();
		System.out.println("After Push");
		for (int i = 0; i <= obj.top; i++) {
			System.out.print(obj.stack[i] + "  ");
		}

	}

}
