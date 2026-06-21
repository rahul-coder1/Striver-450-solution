package arrayBasic;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        //brute force will be sort and check the i+1==i element, O(nlogn)
        //optimal will be just do xor, since same numbers make it zero
    	//TC - O(N)
        int xorSingleNum = 0;
        for(int i:nums){
            xorSingleNum = xorSingleNum^i;
        }

        return xorSingleNum;
    }
    
    public static void main(String[] args) {
    	Map<Integer,Integer> mp = new HashMap<>();
    	System.out.println(mp.get(0));
	}
}
