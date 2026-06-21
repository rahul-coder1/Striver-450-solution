package arrayBasic;

public class CheckArrayIsSortedAndRotated {
	
	//TC O(2N)
	static boolean check(int[] nums) {
        int len = nums.length;
        int count=0;
        for(int i=0; i<2*len-1;i++){
            if(nums[i%len]<=nums[(i+1)%len])
                count+=1;
            else
                count=0;
            if(count==len-1)
                return true;
        }

        return len==1;
    }
}
