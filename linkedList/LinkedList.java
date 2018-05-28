package linkedList;

/**
 * Created by Siddhant on 07-Apr-18.
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int item){
        Node temp = new Node(item,head);
        head = temp;
        size++;
        if(size == 1)
            tail = head;
    }

    public int deleteFirst(){
        int val = head.data;
        head = head.next;
        size--;
        if(size == 0)
            tail = null;
        return val;
    }

    public void insertLast(int item){
        if(size==0){
            insertFirst(item);
            return;
        }
        Node temp = new Node(item,null);
        tail.next = temp;
        tail = temp;
        size++;
    }

    public  int deleteLast(){
        if(size == 1)
            return deleteFirst();

        int val = tail.data;
        Node prev = getNodeByIndex(size-2);
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }


    public void insert(int index,int item){
        if(index == 0){
            insertFirst(item);
            return;
        }
        if(index == size-1){
            insertLast(item);
            return;
        }
        Node prev = getNodeByIndex(index-1);
        Node temp = new Node(item,prev.next);
        prev.next=temp;
        size++;
    }
    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        else if(index == size-1){
            return deleteLast();
        }
        else{
            Node prev = getNodeByIndex(index-1);
            int val = prev.next.data;
            prev.next=prev.next.next;
            size--;
            return val;
        }
    }


    private Node getNodeByIndex(int index){
        Node temp = head;
        for (int i = 1; i <=index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int findItem(int item){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.data == item)
            {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public void printForward(){
        printForward(head);
    }
    private void printForward(Node node){
        if(node == null)
            return;
        System.out.print(node.data +", ");
            printForward(node.next);

    }
    public void printBackward(){
        printBackward(head);
    }
    public  void printBackward(Node node){
        if(node == null)
            return;

        printBackward(node.next);
        System.out.print(node.data+", ");
    }

    public void reverse(){
        reverse(head);
    }

    private void reverse(Node node) {
        if(node.next == null){
            head = node;            // head == tail here
            return;
        }
        reverse(node.next);
        tail.next = node;       // tail start traversing and head took place of tail
        tail = node;
        node.next = null;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            builder.append(temp.data+" ,");
            temp = temp.next;
        }
        builder.append(" END");
        return builder.toString();
    }

    private static class Node{
        public Node(int data){
            this.data = data;
        }
        public Node(int data,Node next){
            this.data= data;
            this.next = next;
        }
        private int data;
        private Node next;
    }

}
