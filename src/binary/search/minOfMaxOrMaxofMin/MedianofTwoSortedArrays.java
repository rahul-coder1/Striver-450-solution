package binary.search.minOfMaxOrMaxofMin;

import java.util.ArrayList;
import java.util.List;

public class MedianofTwoSortedArrays {
	//Brute force
	//TC - O(n1+n2)
	public static double bruteFindMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1=nums1.length, n2=nums2.length;
		List<Integer> arr = new ArrayList<>();
		int i=0,j=0;
		while(i<n1 && j<n2) {
			if(nums1[i]<nums2[j]) arr.add(nums1[i++]);
			else arr.add(nums2[j++]);
		}
		
		while(i<n1) arr.add(nums1[i++]);
		while(j<n2) arr.add(nums2[j++]);
		
		int N = arr.size();
		if(N%2==1) return (double) arr.get(N/2);
		
		return (double)(arr.get(N/2)+arr.get(N/2-1))/2.0;
	}
}
