package hashing;

import java.util.Arrays;
import java.util.Scanner;

public class NumberHashing {
	//[1,1,1,2,2,3] [1,2,3,20]
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		printArray("arr",arr);
		//pre-compute
		//assuming the max element is n, we will then create n+1 size array to include that element also
		int queryElements = sc.nextInt();
		int[] queryArr = new int[250_000_000];
		for(int i=0;i<queryElements;i++) {
			queryArr[i]=sc.nextInt();
		}
		printArray("queryArr",queryArr);
		int maxElement = Arrays.stream(queryArr).max().getAsInt();
		int[] hashArr = new int[maxElement+1];
		for(int i: arr) {
			hashArr[i]+=1;
		}
		printArray("hashArr",hashArr);
		//fetching
		for(int i:queryArr) {
			System.out.print(hashArr[i]+" ");
		}
		
	}
	
	static void printArray(String name,int arr[]) {
		System.out.print(name+":");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}































