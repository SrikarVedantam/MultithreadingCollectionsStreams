package com.corejava.collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniquePairs {
	public static void main(String[] args) {
		Scanner s = new Scanner("5\r\n" + 
				"john tom\r\n" + 
				"john mary\r\n" + 
				"john tom\r\n" + 
				"mary anna\r\n" + 
				"mary anna");
		int t = s.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}
		s.close();

		Set<String> set = new HashSet<>();
		for (int i = 0; i < t; i++) {
			set.add(pair_left[i] + "," + pair_right[i]);
			System.out.println(set.size());
		}
	}
}
