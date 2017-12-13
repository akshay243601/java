package com.akshay.stack;

import java.util.Stack;

public class ImplementQueueUsingStack {

	static Stack<Integer> in = new Stack<>();
	static Stack<Integer> out = new Stack<>();

	public static void enQueue(int value) {
		in.push(value);
	}

	public static void deQueue() {
		if (!isEmpty()) {
			if (out.isEmpty()) {
				while (!in.isEmpty()) {
					out.add(in.pop());
				}
			}
			int x = out.pop();
			System.out.println(x);
		}
	}

	public static boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	}
	
	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		enQueue(6);
		enQueue(7);
		
		deQueue();
		deQueue();
		deQueue();
		deQueue();
		deQueue();

		enQueue(8);
		enQueue(9);
		
		
		deQueue();
		deQueue();
		deQueue();
		
		

	}

}
