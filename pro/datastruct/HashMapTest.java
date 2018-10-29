package datastruct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String,Integer> test = new HashMap<String,Integer>();
		
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("d", 4);
		
		Iterator<String> iter = test.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(test.get(key));
		}
		System.out.println("");
		
		for(String key : test.keySet()) {
			System.out.println(test.get(key));
		}
		System.out.println("");
		
		for(Map.Entry<String, Integer> entry : test.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println("");
	}
}
