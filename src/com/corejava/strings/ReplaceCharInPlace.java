package com.corejava.strings;

public class ReplaceCharInPlace {
	public static void main(String[] args) {
		char[] arr = {'I', ' ', 'a', 'm', ' ', 'a', ' ', 'p', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'e', 'r', '!', 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int length = 18;
		
		System.out.print("Initial Array: " );
		printArray(arr, length);

		// Pass 1: First count the number of spaces;
		int count = countSpaces(arr, length);
		
		// Pass 2: Start copying from the the end of the input string
		// and replace spaces with replacement string.
		int finalLength = replace(arr, length, ' ', count, "%20");
		
		System.out.print("Final Array: " );
		printArray(arr, finalLength);
	}
	
	private static int countSpaces(char[] arr, int length) {
		int count = 0;
		for(int i = 0; i < length; i++) {
			if(arr[i] == ' ') {
				++count;
			}
		}
		return count;
	}
	
	private static int replace(char[] arr, int length, char ch, int count, String replaceStr) {
		int extraSpaceRequired = count * (replaceStr.length() - 1);
		int finalLength =  extraSpaceRequired + length;
		for(int i = finalLength, j = length; i >= 0; i--, j--) {
			if(arr[j] != ch) {
				arr[i] = arr[j];
			}
			else {
				for(int k = replaceStr.length() - 1; k >= 0; k--, i--) {
					arr[i] = replaceStr.charAt(k);
				}
				i++;
			}
		}
		return finalLength;
	}
	
	private static void printArray(char[] arr, int length) {
		for(int i= 0; i < length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}	
}
