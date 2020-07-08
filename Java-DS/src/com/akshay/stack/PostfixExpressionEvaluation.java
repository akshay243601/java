package com.akshay.stack;

import java.util.Stack;

public class PostfixExpressionEvaluation {

	public static void main(String[] args) {
		System.out.println(getPostFixValue("231*+9-"));
	}

	private static int getPostFixValue(String exp) {
		Stack<Integer> stack = new Stack<>();
		for (char c : exp.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(c - '0');
			} else {
				int val1 = stack.pop();
				int val2 = stack.pop();
				if (c == '+') {
					stack.push(val2 + val1);
				} else if (c == '-') {
					stack.push(val2 - val1);
				} else if (c == '*') {
					stack.push(val2 * val1);
				} else if (c == '/') {
					stack.push(val2 / val1);
				}
			}
		}
		return stack.pop();
	}
}
