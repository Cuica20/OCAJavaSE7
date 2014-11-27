package Java7.Map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FrequentlyUseMethodHashMap {

	static HashMap<String, Integer> countMap = new HashMap<String, Integer>();
	
	/**
	 * 2. Print HashMap
	 */
	public static void printMap(Map map){
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			it.remove();
		}
	}
	
	public static void main(String[] args) {

		//HashMap is very useful when a counter is required
		if (countMap.keySet().contains("key")){
			countMap.put("key", countMap.get("key"+1));
		} else {
			countMap.put("key", 1);
		}
		
		/**
		 * 1. Loop Through HashMap
		 */
		Iterator it = countMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		/**
		 * 3. Sort HashMap by Value
		 */
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		//add a lot of entries
		countMap.put("a", 10);
		countMap.put("b", 20);
		
		ValueComparator vc = new ValueComparator(countMap);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(vc);
		
		sortedMap.putAll(countMap);
		printMap(sortedMap);
		
		/**
		 * Convert a Map to List
		 * In Java, Map interface provee 3 vistas de collections:
		 * - key set
		 * - value set
		 * - key - value
		 */
		// key set
		List keyList = new ArrayList(map.keySet());
		// value set
		List valueList = new ArrayList(map.values());
		// key - value
		List entryList = new ArrayList(map.entrySet());
		
		/**
		 * Iterate over each Entry in a Map
		 */
		for(Entry entry: map.entrySet()) {
			  // get key
			//K key = entry.getKey();
			  // get value
			//V value = entry.getValue();
		}
		
		/**
		 * Sort a Map on the keys
		 */
		
	}
}

class ValueComparator implements Comparator<String> {

	/**
	 * 3. Sort HashMap by Value
	 */
	Map<String, Integer> base;
	
	public ValueComparator(Map<String, Integer> base) {
		this.base = base;
	}
	
	@Override
	public int compare(String a, String b) {
		
		if(base.get(a) >= base.get(b)) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
