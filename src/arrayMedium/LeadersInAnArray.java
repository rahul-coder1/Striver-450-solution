package arrayMedium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TC - O(N+N for reversing), SC- O(N)
public class LeadersInAnArray {
	//[1, 2, 5, 3, 1, 2]
	static List<Integer> leaders(int[] nums) {
		List<Integer> ls = new ArrayList<>();
		int maxFromBack = Integer.MIN_VALUE;
		for(int i=nums.length-1;i>=0;i--) {
			if(nums[i]>maxFromBack) {
				maxFromBack = nums[i];
				ls.add(nums[i]);
			}
		}
		
		return ls;
	}
	
	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<>();
		int[] arr= {1, 2, 5, 3, 1, 2};
		ls = leaders(arr);
		Collections.reverse(ls);
		for(int i=ls.size()-1;i>=0;i--) {
			System.out.print(ls.get(i)+" ");
		}
	}
}













