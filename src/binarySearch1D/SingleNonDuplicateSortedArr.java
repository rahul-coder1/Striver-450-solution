package binarySearch1D;

//TC- logN
public class SingleNonDuplicateSortedArr {
	//Approach 1 - use xor
	//Approach 2 below
	public static int singleNonDuplicate(int[] nums) {
		int n=nums.length;
		int low=0,high=n-1,mid=0;
		if(n==1) return nums[0];
		else if(nums[0]!=nums[1]) return nums[0];
		else if(nums[n-2]!=nums[n-1]) return nums[n-1];
		
		while(low<=high) {
			mid=low+(high-low)/2;
			if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]) return nums[mid];
			//left half
			else if((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid]==nums[mid+1])) low=mid+1;
			//right half
			else high=mid-1;
		}
		
		return -1;
	}
	
	public static void printArr(int[]arr) {
		for(int i:arr) {
			System.out.printf("%d ",i);
		}
	}
	
	public static void main(String[] args) {
		int[][]nums= {{3,3,7,7,10,11,11},{1,1,2,3,3,4,4,8,8}};
		for(int[] i: nums) {
			System.out.print("Array: ");
			printArr(i);
			System.out.printf("Unique element::%d ",singleNonDuplicate(i));
			System.out.println();
		}
//		System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
	}
}










