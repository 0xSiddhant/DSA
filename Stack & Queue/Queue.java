/**
 * Created by Siddhant on 31-Mar-18.
 */
public class Queue {
    private int[] nums;
    private static final int   DEFAULT_SIZE = 10;
    private  int end;

    public Queue(){
        this.nums= new int[Queue.DEFAULT_SIZE];
        end=-1;
    }
    public void enqueue(int item){
        this.nums[++end] = item;
    }

    public int dequeue(){
        int temp = this.nums[0];
        for (int i = 0; i < this.end; i++) {
            nums[i]=nums[i+1];
        }
        end--;
        return temp;
    }

    public int peek(){
        return this.nums[0];
    }

    public boolean isEmpty(){
        return this.end == -1;
    }
    public boolean isFull(){
        return this.end+1 == this.nums.length;
    }
    public void display(){
        for (int i = 0; i <= end; i++) {
            System.out.print(this.nums[i]+" , ");
        }
        System.out.println("END");
    }
}
