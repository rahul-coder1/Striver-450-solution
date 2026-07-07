package binary.search.minOfMaxOrMaxofMin;

import java.util.PriorityQueue;

public class MinimizeMaxDistancetoGasStation {
	
	//TC - K × O(N) + O(N) ~= O(KN), SC - O(N)
	public static double bruteMinMaxDist(int[] stations, int k) {
		int[] howMany= new int[stations.length-1];
		int n=stations.length;
		if(n<=1) return 0.0; //edge case
		for(int gasStn=1; gasStn<=k; gasStn++) {
			int maxIndex=-1; double maxSection=-1;
			for(int i=0;i<n-1;i++) {
				double diffBtwStn=stations[i+1]-stations[i];
				double sectionLength = diffBtwStn/(howMany[i]+1);
				if(sectionLength>maxSection) {
					maxSection=sectionLength;
					maxIndex=i;
				}
			}
			howMany[maxIndex]++;
		}
		
		double minMaxDistance=-1;
		for(int i=0;i<n-1;i++) {
			double diffBtwStn=stations[i+1]-stations[i];
			double sectionLength = diffBtwStn/(howMany[i]+1);
			if(sectionLength>minMaxDistance) minMaxDistance=sectionLength;
		}
		
		return minMaxDistance;
	}
	
	// TC: O((N+K)*log N)
	// SC: O(N)
	public static double betterMinMaxDist(int[] stations, int k) {
		//here for better solution we are going to use priorityQueue with max heap
		record Pair(double sectionLength, int index) {}
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.sectionLength(), a.sectionLength()));
		int[] howMany= new int[stations.length-1];
		int n=stations.length;
		if(n<=1) return 0.0; //edge case
		
		//O(N)*O(logN)
		for(int i=0;i<n-1;i++) {
			double gap = (double)stations[i+1]-stations[i];
			pq.offer(new Pair(gap,i));
		}
		
		//O(k)*O(logN)
		for(int gasStn=1;gasStn<=k;gasStn++) {
			int secIndex=pq.poll().index();
			howMany[secIndex]+=1;
			double diff=(double)stations[secIndex+1]-stations[secIndex];
			double newSectionLength = diff/(howMany[secIndex]+1);
			
			pq.offer(new Pair(newSectionLength,secIndex));
		}
		
		return pq.peek().sectionLength();
	}
	
	public static void main(String[] args) {
		int[] stations = {1, 2, 3, 4, 5}; int k = 2;
//		int[] stations = {3, 6, 12, 19, 33}; int k = 3;
//		System.out.println(bruteMinMaxDist(stations, k));
		System.out.println(betterMinMaxDist(stations, k));
		 
	}
}























