package hashing;

import java.util.Scanner;

public class Characterhashing {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String s = sc.nextLine();
		int[] hashArr = new int[256];
		
		//pre-compute
		for(int i=0;i<s.length();i++) {
			hashArr[s.charAt(i)]+=1;
		}
		NumberHashing.printArray("hashArray", hashArr);
		//query array
		int qSize = sc.nextInt();
		int[] queryArr = new int[qSize];
		for(int i=0;i<qSize; i++) {
			queryArr[i] = sc.next().charAt(0);
		}
		NumberHashing.printArray("queryArr", queryArr);
		//fetching
		for(int i: queryArr) {
			System.out.print(hashArr[i]+" ");
		}
	}
}



























