import java.util.ArrayList;
import java.util.HashMap;

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();
	
	HashMap<T, Integer> map = new HashMap<>();
	
	public void add(T item) {
		data.add(item);
		map.put(item, this.data.size()-1);
		upheapify(data.size()-1);
	}

	private void upheapify(int childIndex) {

		int parentIndex = (childIndex -1) /2;
		
		if(isLarger(data.get(childIndex), data.get(parentIndex)) > 0) {
			swap(childIndex,parentIndex);
			upheapify(parentIndex);
		}
	}
	
	private void swap(int i,int j) {
		T ith = data.get(i);
		T jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
		
		map.put(ith,j);
		map.put(jth, i);
	}
	
	public void display() {
		System.out.println(data);
	}
	
	public int size() {
		return this.data.size();
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public T remove() {
		swap(0,this.data.size()-1);
		T rv = this.data.remove(this.data.size()-1);
		downheapify(0);
		
		map.remove(rv);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi +1;
		int rci = 2 * pi + 2;
		
		int minIndex = pi;
		if(lci < this.data.size() && isLarger(data.get(lci), data.get(minIndex)) > 0) {
			minIndex = lci;
		}
		if(rci < this.data.size() && isLarger(data.get(rci), data.get(minIndex)) > 0) {
			minIndex = rci;
		}
		
		if(minIndex != pi) {
			swap(minIndex,pi);
			downheapify(minIndex);
		}
		
	}
	
	public T get() {
		return this.data.get(0);
	}
	
	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}
	
	public void updatePriority(T pair) {
		
		int index = map.get(pair);
		upheapify(index);
		
	}
}
