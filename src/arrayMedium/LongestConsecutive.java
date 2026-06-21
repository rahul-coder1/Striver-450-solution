package arrayMedium;

import java.util.HashSet;
import java.util.Set;

//TC - O(N-Iteration+2N-whileLoop) SC - O(N)
public class LongestConsecutive {//[100,4,200,1,3,2]
	 static int longestConsecutive(int[] nums) {
		 Set<Integer> set = new HashSet<>(); // SC O(N)
		 int longest=1;
		 
		 if(nums.length==0)
			 return 0;
		 
		 for(int i: nums)
			 set.add(i); //O(N)
		 
		 for(int i: set) {
			 if(!set.contains(i-1)) {
				 int ele = i;
				 int count = 1;
				 while(set.contains(ele+1)) {
					 ele = ele+1;
					 count++;
				 }
				 longest = Math.max(longest, count);
			 }
		 }
		 
		 return longest;
	 }
	 
	 public static void main(String[] args) {
//		int arr[] = {100,4,200,1,3,2};
//		int arr[] = {0,3,7,2,5,8,4,6,0,1};
		int arr[] = {1,0,1,2};
		System.out.println(longestConsecutive(arr));
	}
}












