package basicMath;

public class CheckForPrime {
	
	public static boolean isPrime(int n) {
		 int cnt=0;
		for(int i=1; i*i<=n;i++) {
			if(n%i==0) {
				cnt++;
				if((n/i)!=1) {
					cnt++;
				}
			}
		}
		if(cnt==2) {
			return true;
		}else
			return false;
	}
	
	public static void main(String[] args) {
			System.out.println(isPrime(29));
	}
}
