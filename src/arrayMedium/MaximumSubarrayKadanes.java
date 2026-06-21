package arrayMedium;

public class MaximumSubarrayKadanes {
	//TC-O(N)
	static int maxSubArray(int[] nums) {
		int maxSum=Integer.MIN_VALUE; int sumTillThatPoint=0;
		for(int i: nums) {
			sumTillThatPoint+=i;
			maxSum = Math.max(maxSum, sumTillThatPoint);
			if(sumTillThatPoint<0) {
				sumTillThatPoint=0;
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
//		int arr[]= {-2,1,-3,4,-1,2,1,-5,4};
		int arr[]= {5,4,-1,7,8};
		System.out.println(maxSubArray(arr));
	}
}
