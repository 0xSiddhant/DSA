/**
 * Created by Siddhant on 07-Apr-18.
 */
public class DynamicStack extends Stack {

    @Override
    public void push(int item) {
        if(this.isFull()){
            int[] temp = new int[nums.length*2];

            for (int i = 0; i < nums.length; i++) {
                temp[i] = nums[i];
            }

            nums = temp;
        }

        super.push(item);
    }
}
