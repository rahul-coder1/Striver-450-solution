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
    
    //TC - o(n+k)~n, SC - o(n)
    public static String frequencySortOptimal(String s) {
    	List<Character>[] bucket = new ArrayList[s.length()+1];
    	Map<Character,Integer> mp=new HashMap<>();
    	StringBuilder res = new StringBuilder();
    	for(char i: s.toCharArray()) { //****** o(n)
    		mp.put(i,mp.getOrDefault(i, 0)+1);
    	}
    	for(Map.Entry<Character,Integer> entry:mp.entrySet()) {//****** o(k)
    		int count=entry.getValue(); //count will become the index of bucket
    		if(bucket[count]==null) bucket[count] = new ArrayList<>();
    		bucket[count].add(entry.getKey());
    	}
    	
    	for(int i=bucket.length-1;i>=1;i--) { //****** o(n)
    		if(bucket[i]!=null) {
    			for(char c : bucket[i]) { 
    				for(int j=0;j<i;j++) {
    					res.append(c);
    				}
    			}
    		}
    	}
    	
    	return res.toString();
    }
    
    public static void main(String[] args) {
		String[] arr= {"Aabb","tree","cccaaa"};
		for(String str:arr)
			System.out.println(frequencySortOptimal(str));
	}
}























