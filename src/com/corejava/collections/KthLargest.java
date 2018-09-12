package com.corejava.collections;

import java.util.Arrays;
/*import java.util.Collections;
import java.util.List;*/

public class KthLargest {
	public static void main(String[] args) {
		Integer[] elements = {24, 87, 56, 21, 39, 45, 63};
		int k = 4;
		System.out.println(k + "th largest in the list: " + kthLargest(elements, k));
	}
	
	// Idea: Sort the numbers and return the 'k-1'st element.
	private static int kthLargest(Integer[] elements, int k) {
		/*List<Integer> numList = Arrays.asList(elements);
		Collections.sort(numList);
		return numList.get(k - 1);*/ 
		Arrays.sort(elements);
		return elements[k-1];
	}
}