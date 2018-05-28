package com.genericTree;
import java.util.*;

public class GenericTree {
    private Node root;

    public void populate(){
        System.out.print("Please Enter value of root ");
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        this.root = new Node(data);
        populate(root,s);
    }
    public void populate(Node node,Scanner s){
        System.out.printf("How many children you want to add for %d: ", node.data);
        int nums = s.nextInt();
        for (int i = 0; i < nums; i++) {
            System.out.printf("Enter the value of child no. %d of node %d ",i,node.data);
            int value = s.nextInt();
            populate(node.addChild(value),s);
        }
    }

    public  int count(){
        return count(root);
    }
    private int count(Node node){
        int c = 1;
        for (int i = 0; i < node.children.size(); i++) {
            c += count(node.children.get(i));
        }
        return c;
    }

    public boolean find(int item){
        return find(root,item);
    }

    private boolean find(Node node,int item) {
        if(node.data == item)
            return true;
        for (int i = 0; i < node.children.size(); i++) {
            if(find(node.children.get(i), item)) {
                return true;
            }
        }
        return false;
    }


    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        System.out.println(indent+node.data);
        for (int i = 0; i < node.children.size(); i++) {
            display(node.children.get(i),indent+"\t");
        }

    }

    public int depth(){
        return depth(root);
    }

    private int depth(Node node) {
        int max=0;
        if(node.children.isEmpty())
            return 0;

        for (int i = 0; i < node.children.size(); i++) {
            int d = depth(node.children.get(i));
            if(d>max)
                max = d;
        }

        return max+1;
    }

    public void printDepth(int expected){
        printDepth(root,expected,0);
    }
    private void printDepth(Node node,int expected,int current){
        if(expected == current) {
            System.out.println(node.data);
            return;
        }
        for (int i = 0; i < node.children.size(); i++) {
            printDepth(node.children.get(i),expected,current+1);
        }
    }

    public  int maimumSum(){
        return maximunSum(root);
    }
    private int maximunSum(Node node){
        if(node.children.isEmpty())
            return node.data;

        int sum = node.data;
        for (int i = 0; i < node.children.size(); i++) {
            sum = node.children.get(i).data;
        }
        for (int i = 0; i < node.children.size(); i++) {
            int val = maximunSum(node.children.get(i));
            if(val>sum){
                sum = val;
            }
        }
        return sum;
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        System.out.println(node.data);
        for (int i = 0; i < node.children.size(); i++) {
            preOrder(node.children.get(i));

        }
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        for (int i = 0; i < node.children.size(); i++) {
            postOrder(node.children.get(i));
        }
        System.out.println(node.data);
    }

    public  void preOrderByStack(){
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.empty()){
            Node temp = stack.pop();
            System.out.println(temp.data);
            for (int i = temp.children.size()-1 ; i >=0 ; i--) {
                stack.push(temp.children.get(i));
            }
        }

    }

    public  void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.println(temp.data);
            queue.addAll(temp.children);
        }
    }



    private class Node {
        private int data;
        private List<Node> children;
        // private  Node parent;

        public Node(){
            this.children = new ArrayList<>();
        }

        public Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }

        public Node addChild(int data){
            Node temp = new Node(data);
            this.children.add(temp);
            return temp;
        }
    }
}
