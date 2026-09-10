package recursion.medium;

public class CountSubsequencesWithSumK {
	//TC - o(2^n), SC - o(n)-auxiliary/recursion depth/stack
	public static int countSubsequences(int[] arr, int sum) {
		return generate(0,0,sum,arr);
	}
	
	static int generate(int idx, int s, int sum, int arr[]) {
//		if(s>sum) return 0; //use this only when array contains non-negative integers
		if(idx>=arr.length) {
			if(s==sum) return 1;
			
			return 0;
		}
		
		int l = generate(idx+1, s, sum, arr);
		int r = generate(idx+1, s+arr[idx], sum, arr);
		
		return l+r;
	}
	
	public static void main(String[] args) {
		System.out.println(countSubsequences(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
		System.out.println(countSubsequences(new int[] {4, 9, 2, 5, 1}, 10));
		System.out.println(countSubsequences(new int[] {4, 2, 10, 5, 1, 3}, 5));
	}
}
