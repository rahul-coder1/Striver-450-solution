package binary.search.minOfMaxOrMaxofMin;

public class SplitArrayLargestSum {
	//TC - N*log(sum-max+1)
    public static int countSubArrays(int arr[], long minSum){
        long currentSum=0; int subArray=1;
        for(int i=0;i<arr.length;i++){
            if(currentSum+arr[i]<=minSum) currentSum+=arr[i];
            else{
                currentSum=arr[i];
                subArray+=1;
            }
        }
        return subArray;
    }
    public static int splitArray(int[] nums, int k) {
        long low=nums[0],high=0,mid=0;

        if(k>nums.length) return -1; //edge case

        for(int i:nums){
            if(i>low) low=i;
            high+=i;
        }

        while(low<=high){
            mid=low+(high-low)/2;
            int subArrays=countSubArrays(nums,mid);
            if(subArrays>k) low=mid+1;
            else high=mid-1;
        }

        return (int) low;
    }
    
    public static void main(String[] args) {
//		int[] nums = {7,2,5,10,8}; int k = 2;
		int[] nums = {1,2,3,4,5}; int k = 2;
		System.out.println(splitArray(nums,k));
	}
}












