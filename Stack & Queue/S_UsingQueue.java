import java.util.*;
import java.util.Queue;

/**
 * Created by Siddhant on 07-Apr-18.
 */
public class S_UsingQueue {
    private java.util.Queue<Integer> queue;
    public S_UsingQueue(){
        queue = new LinkedList();
    }

    public void push(int item){
        Queue<Integer> temp = new LinkedList<>();
        temp.add(item);
        while(!queue.isEmpty()){
            temp.add(queue.remove());
        }
        queue = temp;
    }
    public int pop()
    {
        return queue.remove();
    }
    public int top(){
        return queue.peek();
    }
    //      Dispaly or toString..
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Queue<Integer> temp = new LinkedList<>();
        while(!queue.isEmpty()){
            builder.append(queue.peek()+" ,");
        }
        builder.append("END");
        queue = temp;
        return builder.toString();
    }
}
