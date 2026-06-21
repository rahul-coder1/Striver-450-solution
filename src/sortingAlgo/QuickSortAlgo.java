package sortingAlgo;

public class QuickSortAlgo {
	
	static void swap(int[] arr, int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int partition(int[]arr, int low, int high) {
		int i=low, j=high;
		int pivot = arr[low];
		while(i<j) {
			while(arr[i]<=pivot && i<=high-1)
				i++;
			while(arr[j]>pivot && j>=low+1)
				j--;
			if(i<j)
				swap(arr,i,j);
		}
		swap(arr,low,j);
		return j;
	}
	
	static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int partitionIdx = partition(arr, low, high);
			quickSort(arr,low, partitionIdx-1);
			quickSort(arr,partitionIdx+1, high );
		}
	}
	
	public static void main(String[] args) {
//		int arr[] = {10,9,8,7,6,1,0,3,2,5,4};
		int arr[] = {3,2,2,1,0,0};
		quickSort(arr,0,arr.length-1);
		for(int i: arr) {
			System.out.print(i+" ");
		}
		
		int[] x = new int[4];
		System.out.println("x:"+x[2]);
	}
}

























