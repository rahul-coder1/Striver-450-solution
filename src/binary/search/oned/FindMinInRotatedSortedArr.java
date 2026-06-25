package binary.search.oned;

public class FindMinInRotatedSortedArr {
	
	public static int findMin(int[]nums) {
		int low=0,mid=0,high=nums.length-1;
		int ans=Integer.MAX_VALUE;
		
		while(low<=high) {
			mid=low+(high-low)/2;
			/*
			a little optimization, not needed, after the half which is sorted is eliminated
			then the other half either low=mid+1, or high-mid-1 will be the sorted 
			other half their low will be that half min, so compare the two mins
			ex- [3,1,2]
			*/
			if(nums[low]<=nums[high]) {
				ans=Math.min(ans, nums[low]);
				break;
			}else if(nums[low]<=nums[mid]) {
				ans=Math.min(ans,nums[low]);
				low=mid+1;
			}else {
				ans=Math.min(ans, nums[mid]);
				high=mid-1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[]nums= {3,1,2}; //important example
//		int[]nums= {4,5,6,7,0,1,2}; 
		System.out.println(findMin(nums));
	}
}











