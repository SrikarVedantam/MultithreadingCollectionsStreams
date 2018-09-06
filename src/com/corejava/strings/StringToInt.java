package com.corejava.strings;

public class StringToInt {

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + " value: " + stringToInt(str));

		str = "-24123";
		System.out.println(str + " value: " + stringToInt(str));
		
		str = "";
		System.out.println(str + " value: " + stringToInt(str));

		str = null;
		System.out.println(str + " value: " + stringToInt(str));
	}

	public static int stringToInt(String str) {
		int result = 0;
		int unit = 1;
		if (str != null && !str.isEmpty()) {
			// calculate the last index
			int i = str.length() - 1;
			// Traverse the string from last index through the second index
			while (i > 0) {
				result = ((str.charAt(i) - '0') * unit) + result;
				unit = unit * 10;
				i--;
			}

			// The first character can be either '-' or '+' or any digit
			if (str.charAt(i) == '-') {
				result = -1 * result;
			} else if (str.charAt(i) == '+') {
				; // Do nothing
			} else {
				result = ((str.charAt(i) - '0') * unit) + result;
			}
		}
		return result;
	}

}
