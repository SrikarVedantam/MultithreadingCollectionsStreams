package com.corejava.strings;

public class StringBuilderDemo {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello World!");
		System.out.println("buffer = " + sb);
		System.out.println("length = " + sb.length());
		System.out.println("capacity = " + sb.capacity());
		
		sb.setCharAt(1, 'i');
		sb.setLength(2);
		System.out.println("buffer after = " + sb);
		
		sb.append(" Student!");
		String str = sb.toString();
		System.out.println("buffer string after appending = " + str);
	}
}
