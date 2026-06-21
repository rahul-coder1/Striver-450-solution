package binarySearch1D;


//TC - O(logN)
public class LowerBound {
	
	public static int lowerBound(int[] arr, int target) {
		int res = arr.length;
		int low=0, high=arr.length-1, mid=0;
		
		while(low<=high){
			mid=low+(high-low)/2;
			if(arr[mid]>=target) {
				res=mid; high=mid-1;
			}else {
				low=mid+1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[]nums = {1,3,5,6};
		int target = 7;
		System.out.println(lowerBound(nums, target));
	}
}
