package binary.search.oned;

public class SearchInSortedRotatedArr {
	public static int search(int[] nums, int target) {
        int low=0, high=nums.length-1, mid=0;

        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[low]<=nums[mid]) //left half is sorted
            {
                if(nums[low]<=target && target<=nums[mid]) high=mid-1;
                else low=mid+1;
            }else{ //right half is sorted
                if(nums[mid]<=target && target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }

        return -1;
    }
	
	public static void main(String[] args) {
//		int[]nums= {4,5,6,7,0,1,2}; int target=0;
		int[]nums= {1}; int target=0;
		System.out.printf("%d", search(nums, target));
	}
}
