package com.akshay.stack;

import java.util.Stack;

public class CheckExpressionIsValid {

	public static boolean isValidExpression(String exp) {
		boolean isValid = true;

		Stack<Character> stack = new Stack<>();
		for (char c : exp.toCharArray()) {
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else if (c == ']') {
				if (stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == '}') {
				if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == ')') {
				if (stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		if (!stack.isEmpty()) {
			isValid = false;
		}
		return isValid;
	}

	public static void main(String[] args) {
		System.out.println(isValidExpression("123*5(76*4){}{}({[]})"));
	}
}
