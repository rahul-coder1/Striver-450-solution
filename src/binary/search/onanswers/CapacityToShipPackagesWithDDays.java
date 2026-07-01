package binary.search.onanswers;

//LeetCode 1011
public class CapacityToShipPackagesWithDDays {
	
	public static int shipWithinDays(int[] weights, int days) {
		int max=Integer.MIN_VALUE; int totalWeight=0;
		for(int i: weights) {
			if(i>max)max=i;
			totalWeight+=i;
		}
		int low=max, high=totalWeight, mid=0;
		while(low<=high) {
			mid=low+(high-low)/2;
			if(checkCapacity(weights,days,mid)<=days) high=mid-1;
			else low=mid+1;
		}
		
		return low;
	}

	private static int checkCapacity(int[] w, int d, int mid) {
		int days=1; //stating with day one, if starting with 0 make sure to add 1 before return
		int weightSum=0;
		for(int i:w) {
			weightSum+=i;
//			if(days>d) return days; //early exit, if needed
			if(weightSum>mid) {
				days+=1; //send the ith weight package to next day
				weightSum=i;
			}
		}
		
		return days;
	}
	
	public static void main(String[] args) {
		int[]weights = {3,2,2,4,1,4}; int days = 3;
//		int[]weights = {1,2,3,4,5,6,7,8,9,10}; int days = 5;
		System.out.println(shipWithinDays(weights,days));
	}
}









