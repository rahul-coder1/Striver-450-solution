package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinMAxFreqElement {
	public static void main(String[] args) {
		Map<Integer,Integer> freqMap = new HashMap<>();
		freqMap.put(1, 5);
		freqMap.put(0, 5);
		freqMap.put(2, 9);
		freqMap.put(3, 3);
		freqMap.put(-1, 3);
		freqMap.put(4, 9);
		freqMap.put(6, 9);
		freqMap.put(5, 2);
		
		Map.Entry<Integer, Integer> maxEntry = freqMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
		Map.Entry<Integer, Integer> minEntry = freqMap.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);
		
		System.out.println("maxEntry:"+maxEntry);
		System.out.println("minEntry:"+minEntry);
	}
}
 	