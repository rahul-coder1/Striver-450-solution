package arrayBasic;

public class RemoveDuplicatesFromSortedArray {
	static int removeDuplicates(int[] nums) {
        int k=1, len = nums.length;
        for(int i=1; i<len;i++){
            if(nums[i-1]==nums[i])
                continue;
            else{
                nums[k]=nums[i]; 
                k++;
            }
        }
        return k;
    }
	
	//[0,0,1,1,1,2,2,3,3,4]
}
