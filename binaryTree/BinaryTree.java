package com.binaryTree;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryTree {

    Node root;

    public static BinaryTree fromInPre(int[] in, int[] pre) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node();
        fromInPre(tree.root, in, pre);
        return tree;

    }

    private static void fromInPre(Node node, int[] in,int[] pre){
        node.data = pre[0];
        int point = findIndex(in,pre[0]);

        int[] firstIn = Arrays.copyOfRange(in,0,point);
        int[] secondIn = Arrays.copyOfRange(in,point+1, in.length);

        int[] firstPre = Arrays.copyOfRange(pre, 1, point+1);
        int[] secondPre = Arrays.copyOfRange(pre, point+1, pre.length);

        if(firstIn.length!=0){
            node.left = new Node();
            fromInPre(node.left, firstIn, firstPre);
        }
        if(secondIn.length != 0){
            node.right = new Node();
            fromInPre(node.right, secondIn, secondPre);
        }
    }
    private static int findIndex(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value)
                return i;
        }
        return -1;
    }

    public static BinaryTree fromInPost(int[] in, int[] post){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node();
        fromInPost(tree.root, in, post);
        return tree;
    }

    private static void fromInPost(Node node, int[] in, int[] post) {
        node.data = post[post.length-1];
        int point = findIndex(in, post[post.length-1]);

        int[] firstIn = Arrays.copyOfRange(in,0,point);
        int[] secondIn = Arrays.copyOfRange(in,point+1, in.length);

        int[] firstPost = Arrays.copyOfRange(post, 0, point);
        int[] secondPost = Arrays.copyOfRange(post, point, post.length-1);

        if(firstIn.length != 0){
            node.left = new Node();
            fromInPost(node.left, firstIn, firstPost);
        }
        if(secondIn.length != 0){
            node.right = new Node();
            fromInPost(node.right, secondIn, secondPost);
        }
    }


    public void populate(){
        Scanner s = new Scanner(System.in);
        this.root = new Node();

        populate(root,s);

    }

    private void populate(Node node, Scanner s) {
        System.out.print("Enter value of Node: ");
        node.data = s.nextInt();
        System.out.println("Want to enter left Node ?");
        if(s.nextBoolean()){
            node.left = new Node();
            populate(node.left,s);
        }
        System.out.println("Want to enter right Node ?");
        if(s.nextBoolean()){
            node.right = new Node();
            populate(node.right,s);
        }

    }

    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        if(node == null)
            return;

        System.out.println(indent+node.data);

        display(node.left,indent+"\t");
        display(node.right,indent+"\t");

    }

    public boolean find(int data){
        return find(root,data);
    }

    private boolean find(Node node, int data) {
        if(node == null)
            return false;
        /*if(node.data == data)
            return true;*/
        if((node.data == data) || find(node.left, data) || find(node.right, data)){
            return true;
        }
        return false;
    }

    public int diameter(){
        return depth(root.left) + depth(root.right) + 2;
    }
    private int depth(Node node){
        if(node == null)
            return -1;
        else
            return Math.max(depth(node.left), depth(node.right))+ 1;
    }

    public  void mirrorTree(){
        mirrorTree(root);
    }
    private void mirrorTree(Node node){
       if(node == null)
           return;

       Node temp = node.left;
       node.left = node.right;
       node.right = temp;

        mirrorTree(node.left);
        mirrorTree(node.right);

    }
    public void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
    public void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }



    private static class Node{
        private  int data;
        private Node left;
        private Node right;


    }
}
