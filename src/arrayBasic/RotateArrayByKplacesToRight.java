package arrayBasic;

public class RotateArrayByKplacesToRight {
	public void rotate(int[] nums,int left,int right){
        while(left<right){
	        int temp=nums[left];
	        nums[left] = nums[right];
	        nums[right] = temp;
	        left++; right--;
        }
	}
	public void rotate(int[] nums, int k) {
	    k = k%nums.length; //since k is no. of times to rotate an array which can be > len(arr) itself
	    rotate(nums,0,nums.length-1);
	    rotate(nums,0,k-1);
	    rotate(nums,k,nums.length-1);
	}
}


// [1,2,3,4,5,6,7], k=2 -> [6,7,1,2,3,4,5]
//Intution -> [7,6,5,4,3,2,1], then divide the array in to parts with k as partition index
// [6,7][1,2,3,4] then merge and you will get the rotated array