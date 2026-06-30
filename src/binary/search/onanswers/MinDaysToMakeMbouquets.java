package binary.search.onanswers;

public class MinDaysToMakeMbouquets {
	//TC log(max-min+1)*N
	public static int minDays(int[] bloomDay, int m, int k) {
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		for(int i:bloomDay) {
			if(i<min) min=i;
			if(i>max) max=i;
		}
		if((long)m*k>bloomDay.length) return -1;
		int low=min, high=max, mid=0;
		while(low<=high) {
			mid=low+(high-low)/2;
			if(possible(bloomDay,m,k,mid)) high=mid-1;
			else low=mid+1;
		}
		
		return low;
	}
	
	public static boolean possible(int[]arr, int m, int k, int mid) {
		int flowers=0,bq=0;
		for(int i: arr) {
			if(i<=mid) {
				flowers++;
				if(flowers==k) {
					bq++;
					if(bq==m) return true;
					flowers=0;
				}
			}else flowers=0;
		}
		return false;
	}
	
	public static void main(String[] args) {
//		int[] bloomDay = {1,10,3,10,2}; int m = 3, k = 1;
//		int[] bloomDay = {1,10,3,10,2}; int m = 3, k = 2;
		int[] bloomDay = {7,7,7,7,12,7,7}; int m = 2, k = 3;
		System.out.println(minDays(bloomDay, m, k));
	}
}
	