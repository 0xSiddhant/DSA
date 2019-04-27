package HashMaps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemoHashMap {

	public static void main(String[] args) {

		HashMap<String, Integer> map =new HashMap<>();
		map.put("USA",300);
		map.put("China",250);
		map.put("India", 200);
		map.put("Swedan", 175);
		map.put("UK", 150);
		
		System.out.println(map);
		System.out.println(map.remove("Swedan"));
		System.out.println(map.get("India"));
		System.out.println(map.containsKey("USA"));
		
		System.out.println("************* KEYS *************");
		Set<String> keys= map.keySet();
		for(String key:keys)
			System.out.println(key);
		
		System.out.println("********** VALUES *********");
		Collection<Integer> values = map.values();
		for(Integer value: values)
			System.out.println(value);
		
		System.out.println("********* EntrySet ************");
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for(Map.Entry<String, Integer> entry: entries) {
			System.out.println(entry.getKey() +" => "+entry.getValue());
		}
	}

}
