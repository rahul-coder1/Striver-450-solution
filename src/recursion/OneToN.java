package recursion;

public class OneToN {
	
//	public static void oneToN(int i, int n) {
//		
//		System.out.println(i);
//		if(i==n) {
//			return;
//		}else {
//			oneToN(i+1, n);
//		}
//	}
	
	public static void onToN2(int n) {
		if(n==0)
			return;
		onToN2(n-1);
		System.out.println(n);
	}
	
	public static void nToOne(int n) {
		if(n==0)
			return;
		System.out.println(n);
		nToOne(n-1);
	}
	
	public static void main(String[] args) {
//		oneToN(0,12);
//		onToN2(10);
		nToOne(10);
		
	}
}





















