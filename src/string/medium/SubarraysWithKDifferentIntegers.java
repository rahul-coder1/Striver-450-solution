package string.medium;

import java.util.*;

public class SubarraysWithKDifferentIntegers {
	//TC - 2*o(2n), SC - O(n)
	public int calculateDistinctSubarrays(int[]nums,int k){
        int l=0,r=0,count=0;
        Map<Integer,Integer> mp = new HashMap<>();
        while(r<nums.length){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.size()>k){
                mp.put(nums[l],mp.getOrDefault(nums[l],0)-1);
                if(mp.get(nums[l])==0)
                    mp.remove(nums[l]);
                l+=1;
            }
            count=count+(r-l+1);
            r+=1;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return calculateDistinctSubarrays(nums,k)-calculateDistinctSubarrays(nums,k-1);
    }
    
    public static void main(String[] args) {
    	SubarraysWithKDifferentIntegers call = new SubarraysWithKDifferentIntegers();
    	int[] nums = {1,2,1,2,3}; 
    	int k = 2;
    	System.out.println(call.subarraysWithKDistinct(nums, k));
	}
}
