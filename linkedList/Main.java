package linkedList;

/**
 * Created by Siddhant on 07-Apr-18.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(10);
        list.insertFirst(20);
        System.out.println(list);
        list.insertLast(30);
        list.insertLast(40);
        System.out.println(list);

        list.deleteFirst();
        list.deleteLast();
        System.out.println(list);

        list.insert(0,50);
        list.insert(1,80);
        System.out.println(list);

        System.out.println(list.findItem(70));
        list.printForward();
        System.out.println();
        list.printBackward();
        System.out.println();

        list.reverse();
        System.out.println(list);
    }
}
