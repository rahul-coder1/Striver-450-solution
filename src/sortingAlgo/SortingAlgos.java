package sortingAlgo;

import java.util.Arrays;

public class SortingAlgos {
	
	static void printArray(int[] arr) {
		System.out.println();
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	static void swap(int[] arr,int a, int b) {
		int temp=arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static void selectionSort(int arr[]) {
		printArray(arr);
		int n=arr.length;
		for(int i=0;i<=n-2;i++) {
			int min = i;
			for(int j=i+1;j<=n-1;j++) {
				if(arr[j]<arr[min]) min=j;
			}
			swap(arr,i,min);
		}
		printArray(arr);
	}
	
	static void bubbleSort(int[] arr) {
		printArray(arr);
		int n=arr.length;
		outer:for(int i=n-1; i>=0;i--) {
			boolean didSwap=false;
			inner:for(int j=0;j<=i-1;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
					didSwap=true;
				}
			}
			System.out.println("runs:"+(n-i));
			if(!didSwap) {
				System.out.println("breaking outer");
				break outer;
			}
		}
		printArray(arr);
	}
	
	static void insertion_sort(int[] arr) {
		int n=arr.length;
		printArray(arr);
		for(int i=0;i<=n-1;i++) {
			int j=i;
			while(j>0 && arr[j-1]>arr[j]) {
				swap(arr,j-1,j);
				j--;
			}
		}
		printArray(arr);
	}
	
	public static void main(String[] args) {
		int[] arr = {5,4,3,0,1,14,10,9,15,90,89,9,9};
		int[] arr2 = {1,2,3,4,5};
//		selectionSort(arr);
//		bubbleSort(arr2);
		insertion_sort(arr);
	}
}

























