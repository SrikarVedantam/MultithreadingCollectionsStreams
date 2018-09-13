package com.corejava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListsMerge {
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,3,5,7,9);
		List<Integer> list2 = Arrays.asList(2,4,6,8,10);
		System.out.println("List1: " + list1);
		System.out.println("List2:"  + list2);
		List<Integer> resultList = mergeLists(list1, list2);
		System.out.println("Result List: " + resultList);
	}

	private static <T extends Comparable<T>> List<T> mergeLists(List<T> list1, List<T> list2){
		List<T> resultList = new ArrayList<T>(list1.size() + list2.size());
		int i = 0, j = 0;
		while(i < list1.size() && j < list2.size()) {
			if(list1.get(i).compareTo(list2.get(j)) < 0) {
				resultList.add(list1.get(i++));
			}
			else {
				resultList.add(list2.get(j++));
			}
		}
		if(list1.size() == i) {
			while(j < list2.size()) {
				resultList.add(list2.get(j++));
			}
		}
		else {
			while(i < list1.size()) {
				resultList.add(list1.get(i++));
			}
		}
		return resultList;
	}
}
