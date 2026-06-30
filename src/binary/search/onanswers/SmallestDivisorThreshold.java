package binary.search.onanswers;

public class SmallestDivisorThreshold {
	
	//TC log(max)*N
    public static int smallestDivisor(int[] nums, int threshold) {
    	int max=Integer.MIN_VALUE;
    	for(int i: nums) {
    		if(i>max) max=i;
    	}
    	int low=1, high=max, mid=0;
    	while(low<=high) {
    		mid=low+(high-low)/2;
    		if(check(nums,threshold,mid)) high=mid-1;
    		else low=mid+1;
    	}
    	
    	return low;
    }
	
    public static boolean check(int[] arr,int t, int mid) {
    	int minThres=0;
    	for(int i:arr) {
    		minThres+=ceilDiv(i, mid);
    		if(minThres>t) return false;
    	}
    	if(minThres<=t) return true;
    	return false;
    }
	public static int ceilDiv(int a, int b) {
		return (a+b-1)/b; //given that a>0,b>0
	}
	
	public static void main(String[] args) {
//		int[]nums = {1,2,5,9}; int threshold = 6;
		int[]nums = {44,22,33,11,1}; int threshold = 5;
		System.out.println(smallestDivisor(nums,threshold));
	}
}
