package AVL_Tree;

public class AVLTree {

	private class Node{
		int data;
		Node left;
		Node right;
		// Balancing Factors
		int height;
		
		Node(int data){
			this.data = data;
			this.height = 1;
		}
	}
	
	private Node root;
	
	public void insert(int item) {
		this.root = insert(this.root,item);
	}

	private Node insert(Node node, int item) {
		if(node == null) {
			Node n  = new Node(item);
			return n;
		}
		if(item>node.data)
			node.right = insert(node.right,item);
		if(item<node.data)
			node.left = insert(node.left,item);
		
		node.height = Math.max(height(node.left), height(node.right))+1;
		int bf = bf(node);
		
		//LL Case
		if(bf>1 &&  item<node.left.data)
			return rightRotation(node);
		//RR Case
		if(bf<-1 && item>node.right.data)
			return leftRotation(node);
		//LR Case
		if(bf>1 && item>node.left.data) {
			node.left =leftRotation(node.left);
			return rightRotation(node);
		}
		// RL Case
		if(bf<-1 && item<node.right.data) {
			node.right = rightRotation(node.right);
			return leftRotation(node);
		}
		return node;
	}
	
	private Node leftRotation(Node node) {
		Node b = node.right;
		Node t = b.left;
		
		// Rotate
		b.left = node;
		node.right = t;
		
		node.height = Math.max(height(node.left),height(node.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right))+1;
		
		return b;
	}

	private Node rightRotation(Node node) {
		Node b = node.left;
		Node t = b.right;
		
		// Rotate
		b.right = node;
		node.left = t;
		
		// height update;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;
		
		return b;
	}

	private int height(Node node) {
		return node == null?0:node.height;
	}
	
	private int bf(Node node) {
		return node == null?0:(height(node.left)-height(node.right));
	}
	
	public void display() {
		display(root);
	}

	private void display(Node node) {
		
		if (node == null) {
			return;
		}

		// self work
		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " => " + node.data + " <= ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}
}
