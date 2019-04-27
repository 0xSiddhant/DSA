package BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

import org.w3c.dom.Node;

public class BinaryTree {
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data,Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	private Node root;
	private int size =0;
	BinaryTree(){
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s,null,false);
	}
	private Node takeInput(Scanner s, Node parent, boolean isLeftOrRight) {
		
		// left ==true  right == false;
		
		if(parent == null) {
			System.out.println("Enter the data for root node");
		}else {
			if(isLeftOrRight) {
				System.out.println("Enter the data for left child of "+parent.data);
				
			}else {
				System.out.println("Enter the data for right child of "+parent.data);
			}
		}
		
		int nodeData = s.nextInt();
		Node node = new Node(nodeData,null,null);
		this.size++;
		boolean choice = false;
		System.out.println("Do you have left child of "+nodeData);
		choice = s.nextBoolean();
		
		if(choice) {
			node.left = takeInput(s,node,true);
		}
		
		choice = false;
		System.out.println("Do you have right child of "+nodeData);
		choice = s.nextBoolean();
		if(choice) {
			node.right = takeInput(s,node,false);
		}
		
		return node;
	}
	
	
	public void display() {
		this.display(this.root);
	}
	private void display(Node node) {
		String str ="";
		if(node.left != null)
			str+= node.left.data+" => ";
		else
			str += "END =>";
		
		str += node.data;
		
		if(node.right != null) 
			str +=" <= "+ node.right.data;
		else
			str += "<= END";
		
		System.out.println(str);
		if(node.left != null)
			display(node.left);
		if(node.right != null)
			display(node.right);
	}
	
	public int height() {
		return this.height(this.root);
	}
	private int height(Node node) {
		if(node == null)
			return -1;
		return Math.max(height(node.left),height(node.right)) + 1;
	}
	
	
	public void mirrorTree() {
		mirrorTree(this.root);
	}
	private void mirrorTree(Node node) {
		if(node == null)
			return;
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		mirrorTree(node.left);
		mirrorTree(node.right);
	}
	
	// Tree Traversal........
	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}
	private void preOrder(Node node) {
		if(node == null)
			return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}
	private void postOrder(Node node) {
		if(node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+ " ");
				
	}
	
	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}
	private void inOrder(Node node) {
		
		if(node == null)
			return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	public void levelOrder() {
		// aka  ==================  BREADTH FIRST SEARCH......
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			Node rm = queue.removeFirst();
			System.out.print(rm.data+" ");
			if(rm.left != null)
				queue.addLast(rm.left);
			if(rm.right != null)
				queue.addLast(rm.right);
		}
	}
}
