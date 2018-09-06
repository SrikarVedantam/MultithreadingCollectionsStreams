package com.corejava.strings;

public class ReplaceChar {
	public static void main(String[] args) {
		String orig = "I am a programmer!";
		System.out.println("Original string: " + orig);
		System.out.println("String after character replacement: " + replaceChar(orig, ' ', "%20"));
	}
	
	private static String replaceChar(String input, char replaceCh, String replaceStr) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == replaceCh) {
				result.append(replaceStr);
			}
			else {
				result.append(input.charAt(i));
			}
			
		}
		return result.toString();
	}

}
