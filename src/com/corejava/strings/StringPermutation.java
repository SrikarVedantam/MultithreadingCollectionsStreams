package com.corejava.strings;

import java.util.Arrays;

public class StringPermutation {
	public static void main(String[] args) {
		String str1 = "LIME";
		String str2 = "MILE";
		System.out.println("Is '" + str1 + "' a permutation of '" + str2 + "'? : " + isPermutation(str1 ,str2));
		
	}
	
	// Key idea: Extract the character arrays from input strings and sort them.
	//           Compare if the two sorted arrays of characters are equal.
	private static boolean isPermutation(String str1, String str2) {
		char[] str1Array = str1.toCharArray();
		Arrays.sort(str1Array);
		
		char[] str2Array = str2.toCharArray();
		Arrays.sort(str2Array);
		
		return Arrays.equals(str1Array, str2Array);
	}
}
