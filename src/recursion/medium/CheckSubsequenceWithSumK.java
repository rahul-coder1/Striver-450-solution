package recursion.medium;

public class CheckSubsequenceWithSumK {
	 //TC - o(2^n), SC - o(n) - recursion depth
    public static boolean checkSubsequenceSum(int[] arr, int k) {
    	return generate(0,0,arr,k);
    }
    
    public static boolean generate(int idx,int s, int[]arr, int sum) {
    	
    	if(s>sum) return false;
    	
    	if(idx>=arr.length) {
    		return s==sum;
    	}
    	
    	//dont take
    	if(generate(idx+1, s, arr, sum)) {
    		return true;
    	}
    	//take
    	return generate(idx+1, s+arr[idx], arr, sum);
    	
    }
    
    public static void main(String[] args) {
		System.out.println(checkSubsequenceSum(new int[]{10, 1, 2, 7, 6, 1, 5},8));
		System.out.println(checkSubsequenceSum(new int[]{2, 3, 5, 7, 9},100));
	}
}
