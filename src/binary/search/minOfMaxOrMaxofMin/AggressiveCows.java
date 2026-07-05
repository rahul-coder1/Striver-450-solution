package binary.search.minOfMaxOrMaxofMin;

import java.util.Arrays;


//AGGRCOW - Aggressive cows
public class AggressiveCows {
	public static boolean checkPossibility(int[] stall, int cows, int dist) {
		int possibleCows=1;//as one cow is always possible and already placed at arr[0]
		int lastPlaced=stall[0];
		for(int i=1;i<stall.length;i++) {
			if(stall[i]-lastPlaced>=dist) {
				possibleCows++;
				lastPlaced=stall[i];
			}
			if(possibleCows>=cows) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
//		int stall[] = {1, 2, 4, 8, 9}; int k = 3;
		int stall[] = {10, 1, 2, 7, 5}; int k = 3;
		Arrays.sort(stall);
		int low=1,high=stall[stall.length-1]-stall[0], mid=0;
		while(low<=high){
			mid=low+(high-low)/2;
			if(checkPossibility(stall,k,mid)) low=mid+1;
			else high=mid-1;
		}
		System.out.printf("Largest min distance:%d",high);
	}
}

























