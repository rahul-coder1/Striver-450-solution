package binarySearch1D;

public class SearchInSortedRotatedArr2 {
	//TC- logN average case, worst case = ~O(N/2)  ex - [3,1,3,3,3,3,3,3] while shrinking you subtract low and high 
    public static boolean search(int[] nums, int target) {
        int low=0,high=nums.length-1,mid=0;

        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target) return true;
            else if(nums[low]==nums[mid]&&nums[mid]==nums[high]){
                low+=1;high-=1;
                continue;
            }else if(nums[low]<=nums[mid]){ //left sorted
                if(nums[low]<=target && target<=nums[mid]) high=mid-1;
                else low=mid+1;
            }else{ //right sorted
                if(nums[mid]<=target&&target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }

        return false;
    }
    
	public static void main(String[] args) {
//		int[]nums= {4,5,6,7,0,1,2}; int target=0;
		int[]nums= {2,5,6,0,0,1,2}; int target=3;
		System.out.printf("%b", search(nums, target));
	}
}
