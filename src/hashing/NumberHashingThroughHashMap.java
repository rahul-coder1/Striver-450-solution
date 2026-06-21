package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//[1,1,1,2,2,3] [1,2,3,20]
public class NumberHashingThroughHashMap {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int size = sc.nextInt();
		Map<Integer,Integer> mp = new HashMap<>();
		
		//pre-compute
		for(int i=0; i<size;i++) {
			int val=sc.nextInt();
			mp.put(val, mp.getOrDefault(val, 0)+1);
		}
		System.out.println("map:"+mp);
		
		int qSize = sc.nextInt();
		int[] qArr = new int[qSize];
		for(int i=0;i<qSize;i++) {
			qArr[i] = sc.nextInt();
		}
		NumberHashing.printArray("qArr", qArr);
		
		//fetching
		for(int i: qArr) {
			System.out.print(mp.getOrDefault(i, -1)+" ");
		}
		
		
	}
}



























