package binarySearch1D;

public class UpperBound {
	//same as LowerBound only change is arr[mid]>x;
	public static int upperBound(int[] arr, int target) {
		int res = arr.length;
		int low=0, high=arr.length-1, mid=0;
		
		while(low<=high){
			mid=low+(high-low)/2;
			if(arr[mid]>target) {
				res=mid; high=mid-1;
			}else {
				low=mid+1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[]nums = {3,5,8,15,16,16,19,20};
		int target = 16;
		System.out.println(upperBound(nums, target));
	}
}
