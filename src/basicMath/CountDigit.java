package basicMath;

class Solution {
    public static int evenlyDivides(int n) {
        int count=0,temp=0;
        int n2=n;
        while(n>0) {
        	temp=n%10;
        	if(temp!=0)
        	    if(n2%temp==0) count++;
        	n=n/10;
        }
        return count;
    }
    
    public static int countIncZero(int n) {
    	int count=0;
    	while(n!=0) {
    		count++;
    		n=n/10;
    	}
    	return count;
    }
    
    public static int countDigits(int n) {
    	System.out.printf("logarithmic of n is log10(%d):%f\n",n,Math.log10(n));
    	int cnt=(int) Math.log10(n)+1;
    	
    	return cnt;
    }
}

public class CountDigit {
	public static void main(String[] args) {
		int res = Solution.evenlyDivides(12030);
		System.out.println("evenlyDivides:"+res);
		System.out.println("countDigits log:"+Solution.countDigits(12030));
		System.out.println("countIncZero:"+Solution.countDigits(12030));
	}
	
}
