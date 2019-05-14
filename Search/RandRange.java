

import java.util.Random;

public class RandRange {

	public static void main(String[] args) {
		
		Random r = new Random();
		int range = 20;
		int a[] = new int[range+1];
		int count = 0;
		while(count<= range) {
			int val = r.nextInt(range+1);
			a[val]++;
			if(!(a[val]>1)) {
				System.out.println(val);
				count++;
			}
		}
		for(int i : a)
			System.out.print(i+" ");
	}
	
}
