/**
 * Created by Siddhant on 31-Mar-18.
 */
public class QueueBetter {
    private int[] nums;
    private static final int   DEFAULT_SIZE = 10;
    private int start;
    private  int end;
    private int size;

    public QueueBetter(){
        this.nums= new int[QueueBetter.DEFAULT_SIZE];
        end=-1;
        start = 0;
        size = 0;
    }
    public void enqueue(int item){
        this.nums[++end] = item;
        this.size++;
    }

    public int dequeue(){
        int temp = this.nums[start++];
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
        return this.end+1 == this.nums.length;
    }
    public void display(){
        for (int i = this.start; i <= end; i++) {
            System.out.print(this.nums[i]+" , ");
        }
        System.out.println("END");
    }
}
