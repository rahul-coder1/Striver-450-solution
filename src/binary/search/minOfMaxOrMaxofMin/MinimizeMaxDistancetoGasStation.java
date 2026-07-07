package binary.search.minOfMaxOrMaxofMin;

public class MinimizeMaxDistancetoGasStation {
	
	//TC - K × O(N) + O(N) ~= O(KN), SC - O(N)
	public static double bruteMinMaxDist(int[] stations, int k) {
		int[] howMany= new int[stations.length-1];
		int n=stations.length;
		if(n<=1) return 0.0; //edge case
		for(int gasStn=1; gasStn<=k; gasStn++) {
			int maxIndex=-1; double maxSection=-1;
			for(int i=0;i<stations.length-1;i++) {
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
		for(int i=0;i<stations.length-1;i++) {
			double diffBtwStn=stations[i+1]-stations[i];
			double sectionLength = diffBtwStn/(howMany[i]+1);
			if(sectionLength>minMaxDistance) minMaxDistance=sectionLength;
		}
		
		return minMaxDistance;
	}
	
	public static void main(String[] args) {
//		int[] stations = {1, 2, 3, 4, 5}; int k = 2;
		int[] stations = {3, 6, 12, 19, 33}; int k = 3;
		System.out.println(bruteMinMaxDist(stations, k));
		 
	}
}























