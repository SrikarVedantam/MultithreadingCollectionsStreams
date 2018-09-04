package com.corejava.strings;

public class Palindrome {
	public static void main(String[] args) {
		String str = "abba";
		boolean isPalindrome = checkPalindrome(str);
		System.out.println("Is " + str + " a palindrome? " + isPalindrome);
	}
	
	private static boolean checkPalindrome(String str) {
		// Key Idea: Traverse the string from both ends and check if each character matches
		for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}