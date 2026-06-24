package binarySearch1D;

public class FindPeakElement {
	//TC- logN
    public static int findPeakElement(int[] nums) {
    	int low=1,n=nums.length,mid=0; int high=n-1;
    	if(n==1) return 0;
    	else if(nums[0]>nums[1]) return 0;
    	else if(nums[n-1]>nums[n-2]) return n-1;
    	
    	while(low<=high) {
    		mid=low+(high-low)/2;
    		if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return mid;
    		//peak is on right side since increasing slope
    		else if(nums[mid-1]<nums[mid]) low=mid+1;
    		//peak is left side
    		else high=mid-1;
    	}
    	
    	return -1;
    }
    
	public static void main(String[] args) {
		int[][]nums= {{1,2,3,1},{1,2,1,3,5,6,4}};
		for(int[] i: nums) {
			System.out.printf("peak index::%d ",findPeakElement(i));
			System.out.println();
		}
		
	}
}
