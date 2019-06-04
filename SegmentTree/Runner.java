package com.ds.segmentTree;

public class Runner {

	public static void main(String[] args) {

		int arr[] = {3,8,7,6,-2,-8, 4, 9};
		SegmentTree stree = new SegmentTree(arr);
		stree.display();
		
		System.out.println();
		System.out.println("Sum is "+stree.query(2, 6));
		System.out.println(stree.query(4, 5));
		System.out.println(stree.query(1, 5));
		
		stree.update(3, 14);
		stree.display();
		System.out.println(stree.query(2, 6));
	}

}
