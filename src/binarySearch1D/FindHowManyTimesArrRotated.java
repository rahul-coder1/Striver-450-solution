package binarySearch1D;

import java.util.ArrayList;
import java.util.List;

public class FindHowManyTimesArrRotated {
	//TC - logN
	public static int findKRotation(ArrayList<Integer> nums) {
        int low=0,mid=0,high=nums.size()-1;
		int ans=Integer.MAX_VALUE; int idx=-1;
		
		while(low<=high) {
			mid=low+(high-low)/2;
			/*
			a little optimization, not needed, after the half which is sorted is eliminated
			then the other half either low=mid+1, or high-mid-1 will be the sorted 
			other half their low will be that half min, so compare the two mins
			ex- [3,1,2]
			*/
			if(nums.get(low)<=nums.get(high)) {
                if(nums.get(low)<ans){
                    ans=nums.get(low); idx=low;
                }
				break;
			}else if(nums.get(low)<=nums.get(mid)) {
                if(nums.get(low)<ans){
                    ans=nums.get(low); idx=low;
                }
				low=mid+1;
			}else {
                if(nums.get(mid)<ans){
                    ans=nums.get(mid); idx=mid;
                }
				high=mid-1;
			}
		}
		
		return idx;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>(List.of(4, 5, 6, 7, 0, 1, 2, 3));
//		int[]nums= {4,5,6,7,0,1,2}; 
		System.out.println(findKRotation(nums));
	}
	
}























