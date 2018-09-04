package com.corejava.strings;

public class UniqueCharacters {
	public static void main(String[] args) {
		String str = "hello";
		System.out.println("Has '" + str + "' unique characters? " + uniqueCharacters(str));
		
		String str2 = "prime";
		System.out.println("Has '" + str2 + "' unique characters? " + uniqueCharacters(str2));
	}
	
	//Key Idea: Use a double loop and compare every character of the 
	//          string to every other character of the string
	private static boolean uniqueCharacters(String str) {
		for(int i = 0; i < str.length() - 1; i++)
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		
		return true;
	}

}
