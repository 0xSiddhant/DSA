package com.ds.segmentTree;

public class SegmentTree {

	private class Node {
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;
	}
	
	Node root;
	
	public SegmentTree(int ar[]) {
		this.root = constructTree(ar,0,ar.length-1);
	}
	private Node constructTree(int arr[], int si, int ei) {
		
		if(si == ei) {
			Node leafNode = new Node();
			leafNode.startInterval = si;
			leafNode.endInterval = ei;
			leafNode.data = arr[si];
			return leafNode;
		}
		
		Node node = new Node();
		node.startInterval = si;
		node.endInterval = ei;
		
		int mid = (si+ei)/2;
		
		node.left = constructTree(arr, si, mid);
		node.right = constructTree(arr, mid+1, ei);
		
		node.data = node.left.data + node.right.data;
		
		return node;
		
	}
	
	public void display() {
		display(this.root);
	}
	private void display(Node node) {
		String str = "";
		if(node.left != null) {
			str += "Interval=["+node.left.startInterval+" - "+node.left.endInterval+"] and data=["+node.left.data+"] => ";
		}else {
			str+= "NO LEFT CHILD => ";
		}
			
		str += "Interval=["+node.startInterval+" - "+node.endInterval+"] and data=["+node.data+"]";
		
		if(node.right != null) {
			str += " <= Interval=["+node.right.startInterval+" - "+node.right.endInterval+"] and data=["+node.right.data+"]";
		}else {
			str+= " <= NO RIGHT CHILD";
		}
		System.out.println(str);
		if(node.left != null)
			display(node.left);
		if(node.right != null)
			display(node.right);
	}
	
	public int query(int qsi,int qei) {
		return query(this.root,qsi,qei);
	}
	private int query(Node node, int qsi, int qei) {
		// node is completely lying inside query so will directly contribute to ans
		if(node.startInterval>= qsi && node.endInterval <= qei) {
			return node.data;
		}else if(node.startInterval > qei || node.endInterval < qsi) {
			// node is completely outside the ans
			// return the default value;
			return 0;
		}else {
			// overlapping case
			int leftans = this.query(node.left, qsi, qei);
			int rightans = this.query(node.right, qsi, qei);
			return leftans + rightans;
		}
	}
	
	public void update(int index, int newValue) {
		this.root.data = update(this.root, index, newValue);
	}
	private int update(Node node, int index, int newValue) {
		if(index >= node.startInterval && index <= node.endInterval) {
			if(index == node.startInterval && index == node.endInterval) {
				node.data = newValue;	
			}else {
				int leftValue = update(node.left,index,newValue);
				int rightValue = update(node.right,index,newValue);
				node.data = leftValue+ rightValue;
			}
		}
		return node.data;
	}
}
