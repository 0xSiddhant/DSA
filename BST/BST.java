package BST;


public class BST {

	private class Node {
		int data;
		Node left;
		Node right;

	}

	private Node root;

	public BST(int[] arr) {

		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lw, int hi) {

		if (lw > hi) {
			return null;
		}
		// mid
		int mid = (lw + hi) / 2;
		Node nn = new Node();
		nn.data = arr[mid];

		nn.left = construct(arr, lw, mid - 1);
		nn.right = construct(arr, mid + 1, hi);

		return nn;
	}
	
	public void display() {
		display(this.root);
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

	public boolean find(int item) {
		return find(this.root,item);
	}
	private boolean find(Node node, int item) {

		if(node == null)	
			return false;
		
		if(item < node.data) {
			return find(node.left,item);
		}else if(item > node.data) {
			return find(node.right,item);
		}else {
			return true;
		}
	}
	
	public int max() {
		return max(this.root);
	}
	private int max(Node node) {
		if(node.right == null)
			return node.data;
		return max(node.right);
	}
	
	public void insert(int item) {
		insert(this.root,item);
	}
	private void insert(Node node, int item) {
		if(item > node.data) {
			if(node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			}
			else {
				insert(node.right,item);
			}
		}
		else{
			if(node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			}else {
				insert(node.left,item);
			}
		}
	}

	public void remove(int item) {
		remove(this.root,null ,false,item);
	}
	private void remove(Node node, Node parent, boolean isLeftChild, int item) {
		
		// If element not present in tree
		if(node == null)
			return;
		
		if(item>node.data)
			remove(node.right,node,false,item);
		else if(item < node.data)
			remove(node.left, node, true , item);
		else {
			//case 1:			LEAF NODE
			if(node.left == null && node.right == null) {
				if(isLeftChild)
					parent.left = null;
				else
					parent.right = null;
			}
			//case 2:
			else if(node.left == null && node.right != null) {
				if(isLeftChild) {
					parent.left = node.right;
				}else {
					parent.right = node.right;
				}
			}
			//case 3:
			else if(node.left != null && node.right == null) {
				if(isLeftChild) {
					parent.left = node.left;
				}else {
					parent.right = node.left;
				}
			}
			// case 4:
			else {
				int max = max(node.left);
				node.data = max; 
				remove(node.left, node, true, max);
			}
		}
	}
}
