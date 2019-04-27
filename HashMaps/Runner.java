package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Runner {

	public static void main(String[] args) throws Exception{
		HashTable<String, Integer> map = new HashTable<>(4);
		map.put("USA",300);
		map.put("China",250);
		map.put("India", 200);
		map.display();
		System.out.println("]n \n");
		map.put("Swedan", 175);
		map.put("UK", 150);
		map.display();
		System.out.println("\nssss\n");
		map.put("Japan", 180);
		map.display();
		System.out.println("\nrehash\n");
		map.put("South Korea", 241);
		
		map.display();
	/*	map.put("India", 500);
		System.out.println();
		map.display();
		
		System.out.println(map.get("USA"));
		System.out.println(map.get("RSA"));
		
		System.out.println(map.remove("India"));
		map.display();*/
		
		
		// Some problems on HashMap
		arrayInterSection();
		charMaxFrequency();
		stringAnagram();
	}

	private static void stringAnagram() {
		String str1 = "triangle";
		String str2 = "inntegral";
		Map<Character,Boolean> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			map.put(str1.charAt(i), false);
		}
		for(int i=0;i<str2.length();i++) {
			if(map.containsKey(str2.charAt(i)))
				map.put(str2.charAt(i), true);
		}
		boolean ans = true;
		for(Map.Entry<Character, Boolean> entry: map.entrySet()) {
			if(!entry.getValue())
				ans = false;
		}
		if(ans)
			System.out.println("Anagram");
		else
			System.out.println("Not an Anagram");		
	}

	private static void charMaxFrequency() {
		String str = "aabbbbabbccsddaca";
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				int val = map.get(str.charAt(i));
				map.put(str.charAt(i), val+1);
			}else
			map.put(str.charAt(i), 1);
		}
		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		char maxchar = '\0';
		int max = 0;
		for(Map.Entry<Character, Integer> entry: entries) {
			if(entry.getValue() > max) {
				max =entry.getValue();
				maxchar =entry.getKey();
			}
			System.out.println(entry.getKey() +" => "+entry.getValue());
		}
		System.out.println(maxchar);		
	}

	private static void arrayInterSection() {
		int arr[] = new int[] {5,1,2,3,6,7,9};
		int brr[] = new int[] {3,4,5,2,7,8,1,9};
		
		Map<Integer,Boolean> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], false);
		}
		for (int i = 0; i < brr.length; i++) {
			if(map.containsKey(brr[i])) {
				map.put(brr[i], true);
			}
		}
		ArrayList<Integer> l = new ArrayList<>();
		Set<Map.Entry<Integer,Boolean>> entries  = map.entrySet();
		for(Map.Entry<Integer, Boolean> entry: entries) {
			if(entry.getValue()) {
				l.add(entry.getKey());
			}
		}
		System.out.println(l);
	}
}
