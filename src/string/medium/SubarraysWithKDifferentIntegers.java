package string.medium;

import java.util.*;

public class SubarraysWithKDifferentIntegers {
	//TC - 2*o(2n), SC - O(n)
	//HashMap solution is generic solution 
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
    
    //----------------------------------------------------------------------------------------------------------------
    
    //1 <= nums[i], k <= nums.length only then this solution is applicable
    //TC o(2n), SC - o(n)
    public int calculateDistinctSubarraysUsingArray(int[]nums,int k){
    	int l=0,r=0,n=nums.length;
    	int[] mp=new int[n+1];
    	int count=0, distinct=0; //distinct should be less than equal to k
    	while(r<n) {
    		mp[nums[r]]+=1;
    		if(mp[nums[r]]==1) distinct+=1; //since we only increase when 1st time encounter, rest is just duplicate
    		while(distinct>k) {
    			mp[nums[l]]-=1;
    			if(mp[nums[l]]==0) distinct-=1;
    			l++;
    		}
    		count+=(r-l+1);
    		r+=1;
    	}
    	
    	return count;
    }
    
    public int subarraysWithKDistinctArraySol(int[] nums, int k) {
        return calculateDistinctSubarrays(nums,k)-calculateDistinctSubarrays(nums,k-1);
    }
    
    //----------------------------------------------------------------------------------------------------------------
    
    public int calculateDistinctSubarrays3Pointer(int[]nums,int k){
    	int l_far=0,l_near=0,r=0;
    	int n = nums.length;
    	int count=0;
    	Map<Integer,Integer> freq = new HashMap<Integer, Integer>();
    	while(r<n) {
    		//adding the element to frequency map
    		freq.put(nums[r], freq.getOrDefault(nums[r], 0)+1);
    		
    		//handles invalid subArray
    		//handle the case when map size exceeds the k, that is more than k unique element present in map
    		while(freq.size()>k) {
    			freq.put(nums[l_near], freq.getOrDefault(nums[l_near], 0)-1);
    			if(freq.get(nums[l_near])==0)
    				freq.remove(nums[l_near]);
    			l_near+=1;
    			l_far=l_near;
    		}
    		
    		//finds the smallest valid window/subArray
    		while(freq.get(nums[l_near])>1) {
    			freq.put(nums[l_near], freq.getOrDefault(nums[l_near], 0)-1);
    			l_near+=1;
    		}
    		
    		//got the smallest subArray with left far pointer either behind the left near pointer or at same index
    		if(freq.size()==k) {
    			count += l_near-l_far+1; //
    		}
    		
    		r+=1;
    	}
    	
    	return count;
    }
    
  //----------------------------------------------------------------------------------------------------------------
    
    
    
    public static void main(String[] args) {
    	SubarraysWithKDifferentIntegers call = new SubarraysWithKDifferentIntegers();
    	int[] nums = {1,2,1,2,3}; 
    	int k = 2;
//    	System.out.println(call.subarraysWithKDistinct(nums, k));
//    	System.out.println(call.subarraysWithKDistinctArraySol(nums, k));
//    	System.out.println(call.calculateDistinctSubarrays3Pointer(nums, k));
    	
	}
}








