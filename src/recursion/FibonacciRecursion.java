package recursion;

public class FibonacciRecursion {
	public static int fib(int n) {
        if(n==0 || n==1)
            return n;
        return fib(n-1)+fib(n-2);

    }
	
	static void fibonacciUsingDP(int n) {
		
		if(n<=0) return;
		
		long[] dp = new long[n];
		
		if(n>1) {
			dp[0]=0;
			dp[1]=1; //if n>1 like 2, then dp0 and dp1 will be set here
		}
		for(int i=2; i<n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		for(long i : dp) {
			System.out.print(i+" ");
		}
	}
	
	static void usingTwoPointer(int n) {
		if(n<=0) return;
		long first=0, second=1;
		
		System.out.print(first+" ");
		
		for(int i=1;i<n;i++) {
			System.out.print(second+" ");
			long sum = first+second;
			first = second;
			second = sum; 
		}
		
		
	}
	
	//0 1 2 3 4 5 6
	//0 1 1 2 3 5 8
	public static void main(String[] args) {
//		System.out.println(fib(2));
		fibonacciUsingDP(10);
		System.out.println();
		usingTwoPointer(2);
		
	}
}



























