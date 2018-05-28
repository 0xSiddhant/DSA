package com.genericTree;

//10 2 20 2 30 0 40 0 50 0

public class Runner {
    public static void main(String[] args) {
        GenericTree tree = new GenericTree();

        tree.populate();
        System.out.println();
        tree.display();
        System.out.println(tree.count());
        System.out.println(tree.find(40));
        System.out.println(tree.depth());
        System.out.println();
        tree.printDepth(2);

        System.out.println(tree.maimumSum());
        System.out.println();
        tree.levelOrder();
    }
}
