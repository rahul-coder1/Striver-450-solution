package arrayBasic;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSumK {
	
	//TC - O(N*log(N)) - N for array traverse and log(N) for element lookup
	static int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> prevSum = new HashMap<>();
        int sum=0, maxlen=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k)
                maxlen = Math.max(maxlen,i+1);
            int rem = sum-k;
            //check if prefix sum exist
            if(prevSum.containsKey(rem)){
                int index = i-prevSum.get(rem);
                maxlen = Math.max(maxlen,index);
            }
            //if exist do not overwrite otherwise max len will decrease
            if(!prevSum.containsKey(sum)){
                prevSum.put(sum,i); // 1,0 3,1 4,2
            }
        }

        return maxlen;
    }
	
	public static void main(String[] args) {
		int[] nums = {10, 5, 2, 7, 1, 9};
		int k=15;
		int result = longestSubarray(nums,k);
		System.out.println("result:"+result);
	}
}















