package recursion;

public class CountGoodNumbers {
	//TC - O(log n) + O(log n) = O(log n) since pow function called 2 times
    public static int countGoodNumbers(long n) {
        final long MOD = 1_000_000_007;
        long even = (n+2-1)/2; //(a+b-1)/b for ceil values of positive integer
        long odd = n/2;

        return (int)((pow(5,even)*pow(4,odd))%MOD);
    }

    public static long pow(long x,long n){
        final long MOD = 1_000_000_007;
        long res = 1;
        while(n>0){
            if(n%2==1){
                res = (res*x)%MOD;
            }
            n=n/2;
            x=(x*x)%MOD;
        }

        return res;
    }
    
    public static void main(String[] args) {
		long n = 50;
		System.out.println(countGoodNumbers(n));
	}
}
