package recursion;

public class PowerOfXbyN {
	//TC - o(logn)
    public static double myPow(double x, int n) {
        long nn = n;
        double ans = 1.0;
        if(n<0) nn = -1*nn;
        while(nn>0){
            if(nn%2==1){
                ans = ans*x;
                nn-=1;
            }else{
                x = x*x;
                nn = nn/2;
            }
        }

        return n<0?1/ans:ans;
    }
    
    public static void main(String[] args) {
		double x = 2;
		int n = 5;
		System.out.println(myPow(x, n));
	}
}
