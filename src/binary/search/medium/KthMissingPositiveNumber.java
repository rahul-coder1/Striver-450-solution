package binary.search.medium;

public class KthMissingPositiveNumber {
	//TC - logN
    public static int findKthPositive(int[] arr, int k) {
    	int low=0;
    	int high=arr.length-1;
    	int mid=0;
    	int missingNsTillThisPoint=0;
    	
    	while(low<=high) {
    		mid=low+(high-low)/2;
    		missingNsTillThisPoint=arr[mid]-(mid+1);
    		if(missingNsTillThisPoint<k)low=mid+1;
    		else high=mid-1;
    	}
    	
    	return low+k; //or k+high+1
    }
    
	public static void main(String[] args) {
//		int[]arr  = {2,3,4,7,11}; int k = 5;
		int[]arr  = {1,2,3,4}; int k = 2;
		System.out.println(findKthPositive(arr,k));
	}
}
