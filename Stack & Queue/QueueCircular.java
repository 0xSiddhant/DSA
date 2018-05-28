/**
 * Created by Siddhant on 31-Mar-18.
 */
public class QueueCircular {
    private int[] nums;
    private static final int   DEFAULT_SIZE = 10;
    private int start;
    private  int end;
    private int size;

    public QueueCircular(){
        this.nums= new int[QueueCircular.DEFAULT_SIZE];
        end=-1;
        start = 0;
        size = 0;
    }
    public void enqueue(int item){
        this.end = (this.end +1 )% this.nums.length;
        this.nums[end] = item;
        this.size++;
    }

    public int dequeue(){
        int temp = this.nums[start];
        this.start = (this.start+1)% this.nums.length;
        this.size--;
        return temp;
    }

    public int peek(){
        return this.nums[this.start];
    }

    public boolean isEmpty(){
        return this.size==0;
    }
    public boolean isFull(){
        return this.size == this.nums.length;
    }
    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print(this.nums[(start+i)%nums.length]+" , ");
        }
        System.out.println("END");
    }
}
