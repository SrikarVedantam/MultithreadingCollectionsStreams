package com.corejava.collections;

import java.util.Stack;

public class BalancedStringChecker {
	public static void main(String[] args) {
		String input = "()[] {([])}";
		System.out.println("Is '" + input + "' balanced? " + isBalanced(input));
		
		input = "}{";
		System.out.println("Is '" + input + "' balanced? " + isBalanced(input));
	}

	private static boolean isBalanced(String input) {
		boolean result = true;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			// Just push all the opening braces
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}
			// If a right brace is encountered, check if the top of the stack has
			// corresponding left brace.
			else if (ch == ')') {
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
			} else if (ch == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else if (ch == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return result;
	}

}
