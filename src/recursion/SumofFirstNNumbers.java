package recursion;

public class SumofFirstNNumbers {
	
//	public static int sumOfNaturals(int n) {
//		int res=0;
//		if(n==0)
//			return 0;
//		else {
//			res=res+n+sumOfNaturals(n-1);
//		}
//		
//		return res;
//		
//	}
	
	public static int sumOfNaturals2(int n) {
		if(n==0)
			return 0;
		return n+sumOfNaturals2(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println(sumOfNaturals2(6));
	}
}












