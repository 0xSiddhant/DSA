/**
 * Created by Siddhant on 31-Mar-18.
 */
public class Q_UsingStack {
    private Stack data;
    private Stack temp;

    public  Q_UsingStack(){
        data = new Stack();
        temp = new Stack();

    }

    public  void enqueue(int item){
        data.push(item);

    }

    public  int dequeue(){
        while (!data.isEmpty()){
            temp.push(data.pop());
        }

        int x = temp.pop();
        while(!temp.isEmpty()){
            data.push(temp.pop());
        }
        return x;
    }

    public  int peek(){
        while (!data.isEmpty())
        {
            temp.push(data.pop());
        }
        int x = temp.top();
        while (!temp.isEmpty()){
            data.push(temp.pop());
        }
        return x;
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public boolean isFull(){
        return  data.isFull();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
