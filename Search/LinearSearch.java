package com.ds.search;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l =linearSearch(new int[]{2,4,56,23,1,34,67,87},87);
		if(l!= -1)
			System.out.println("Item found at index "+l);
		else
			System.out.println("Item Not found");
	}

	private static int linearSearch(int[] is, int i) {
		
		for (int j = 0; j < is.length; j++) {
			if(is[j] == i)
				return j;
		}
		return -1;
	}

}
