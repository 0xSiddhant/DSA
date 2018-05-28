/**
 * Created by Siddhant on 31-Mar-18.
 */
public class Stack {
    protected   int[] nums;
    private static final int DEFAULT_SIZE = 10;
    private int top;

    public Stack(){
        this(Stack.DEFAULT_SIZE);
       /* this.nums = new int[Stack.DEFAULT_SIZE];
        this.top=-1;*/
    }
    public  Stack(int size){
        this.nums = new int[size];
        this.top=-1;
    }
    public void push(int item){
        this.nums[++top] = item;
    }
    public int pop()
    {
        return this.nums[top--];
    }
    public int top(){
        return this.nums[top];
    }

    public boolean isEmpty(){
        /*if(top == -1)
            return true;
        else
            return false;*/
        return this.top == -1;
    }

    public boolean isFull()
    {
        return this.top + 1 == this.nums.length;
    }

    public void display(){
        for (int i = 0; i <= this.top; i++) {
            System.out.print(this.nums[i]+" , ");
        }
        System.out.println(" END");
    }

    //      Dispaly or toString..
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i =0;i<=this.top;i++)
        {
            builder.append(nums[i]+", ");
        }
        builder.append("END");
        return builder.toString();
    }
}
