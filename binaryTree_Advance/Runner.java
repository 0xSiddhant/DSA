package com.binaryTree;

public class Runner {

    // 10 true 20 true 40 false false true 50 false false true 30 true 60 false false false
    public static void main(String[] args) {
        /*BinaryTree tree = new BinaryTree();

        tree.populate();
        tree.display();*/
        //System.out.println(tree.find(50));
        //System.out.println(tree.diameter());
        //tree.mirrorTree();
        //tree.display();

        //tree.preOrder(tree.root);

        int[] in = {40,20,50,10,60,30};
        int[] pre = {10,20,40,50,30,60};
        int[] post = {40,50,20,60,30,10};

        BinaryTree homeMade = BinaryTree.fromInPre(in,pre);
        homeMade.display();

        BinaryTree postWala = BinaryTree.fromInPost(in,post);
        postWala.display();

    }
}
