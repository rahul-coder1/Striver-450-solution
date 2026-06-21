package recursion;

public class FactorialOfN {
	
	public static int factorial(int n) {
		if(n==0 || n==1)
			return 1;
		
		return n*factorial(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(10));
		int[] a = new int[10];
		System.out.println("default value:"+a[9]);
	}
}
