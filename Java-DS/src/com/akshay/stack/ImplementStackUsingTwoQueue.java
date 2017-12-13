package com.akshay.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueue {

	static Queue<Integer> queue = new LinkedList<Integer>();

	private static Integer pop() {
		if (queue.isEmpty()) {
			System.out.println("Stack is Empty");
			return null;
		}
		int x = queue.poll();
		System.out.println(x);
		return x;
	}

	
	//While push just add new element in queue. It should 
	private static void push(int value) {

		int size = queue.size();
		queue.add(value);
		for (int i = 0; i < size; i++) {
			int x = queue.poll();
			queue.add(x);
		}
	}

	public static void main(String[] args) {
		push(4);
		push(8);
		push(9);
		push(12);
		push(14);
		push(16);
		push(19);
		
		pop();
		pop();
		pop();
		pop();
		pop();
		pop();
		pop();
		
		
		
		
	}

}
