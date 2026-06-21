package sortingAlgo;

import java.util.ArrayList;

public class MergerSortAlgo {
	
	static void mergeSort(int arr[], int low,int high) {
		if(low == high) return;
		int mid = (low+high)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
	}
	
	static void merge(int arr[],int low, int mid, int high) {
		int right=mid+1; //pointer, left pointer is low
		int left = low;
		ArrayList<Integer> temp = new ArrayList<>();
		while(left<=mid && right <= high) {
			if(arr[left]<arr[right]) {
				temp.add(arr[left]);
				left++;
			}else {
				temp.add(arr[right]);
				right++;
			}
		}
		while(left<=mid) {
			temp.add(arr[left]);
			left++;
		}
		while(right<=high) {
			temp.add(arr[right]);
			right++;
		}
		
		for(int i=low; i<=high;i++) {
			arr[i] = temp.get(i-low);
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {10,9,8,7,6,1,0,3,2,5,4};
		mergeSort(arr,0,arr.length-1);
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
}




























