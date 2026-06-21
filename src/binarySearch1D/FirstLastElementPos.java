package binarySearch1D;

public class FirstLastElementPos {
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
    	int[]nums = {5,7,7,8,8,10}; int target = 8;
    	int lb = lowerBound(nums,target);
        if(lb==nums.length || nums[lb]!=target) System.out.println("-1,-1");;
        System.out.printf("%d %d",lb,upperBound(nums,target)-1);
	}
    
    
    
    
    
    
}
