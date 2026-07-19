package string.medium;

import java.util.*;

public class SortCharactersByFrequency {
	//TC - o(n+k*logk), SC - o(k), k is the distinct character
    public static String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> mp = new HashMap<>();
        record Pair(char character, int freq){}
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.freq(),a.freq()));
        for(char i:s.toCharArray()){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Character,Integer> entry: mp.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        while(!pq.isEmpty()){
            Pair element=pq.poll();
            int freq=element.freq();
            while(freq>0){
                res.append(element.character());
                freq-=1;
            }
        }

        return res.toString();
    }
    
    public static void main(String[] args) {
		String[] arr= {"Aabb","tree","cccaaa"};
		for(String str:arr)
			System.out.println(frequencySort(str));
	}
}























