package arrayBasic;

public class secondLargest {
	
	static int betterSolution(int[] arr) {
		//TC - O(2N)
		int max = arr[0]; int max_2nd = Integer.MIN_VALUE;//assuming if every element is same then return -1
		for(int i:arr) {
			if(max<i)
				max=i;
		}
		
		for(int i: arr) {
			if(max_2nd < i && i!=max)
				max_2nd=i;
		}
		
		return max_2nd==Integer.MIN_VALUE?-1:max_2nd;
	}
	
	//TC - O(N)
	static int optimalSolution(int [] arr) {
		int max = arr[0]; int max_2nd = Integer.MIN_VALUE;
		
		for(int i:arr) {
			if(max < i) {
				max_2nd = max;
				max=i;
			}else if(max_2nd < i && i!=max) {
				max_2nd=i;
			}
		}
		
		return max_2nd==Integer.MIN_VALUE?-1:max_2nd;
	}
	
	public static void main(String[] args) {
		int arr[] = {8, 8, 7, 6, 5,9,9,9,10,10,10,10,11,11};
		System.out.println("betterSolution:"+betterSolution(arr));
		System.out.println("optimalSolution:"+optimalSolution(arr));
	}
}
























