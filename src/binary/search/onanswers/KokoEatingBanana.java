package binary.search.onanswers;

public class KokoEatingBanana {
	public static int findMax(int[] piles) {
		int max=Integer.MIN_VALUE;
		for(int i: piles) {
			if(i>max) max=i;
		}
		return max;
	}
	
	public static long findTotalHours(int[] piles, int mid) { //mid here is banana/hour i.e speed
		long totalHrs=0;
		for(int i:piles) {
			totalHrs+=(i+mid-1)/mid;
		}
		//System.out.printf(totalHrs+" ");
        return totalHrs;
	}
	
	public static int minEatingSpeed(int[] piles, int h) {
		int low=1,high=findMax(piles),mid=0;
		while(low<=high) {
			mid=low+(high-low)/2;
			//System.out.printf(mid+" ");
			if(findTotalHours(piles, mid)<=h) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		return low;
	}
	
	public static void main(String[] args) {
		int[]piles = {805306368,805306368,805306368};
		int h = 1000000000;
		System.out.println(minEatingSpeed(piles, h));
	}
}










