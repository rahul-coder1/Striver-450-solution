package basicMath;

import java.util.Arrays;

public class GCDandLCM {
	static class Solution {
		public static int[] lcmAndGcd(int a, int b) {
	    	int[] res=new int[2];
	    	int gcd=gcdF(a,b);
	    	
	    	res[0]=gcd;
	    	res[1]=(a*b)/gcd;
	    	return res;
	    }
		public static int gcdF(int a, int b) {
			while(b!=0) {
	    		int temp=b;
	    		b=a%b;
	    		a=temp;
	    	}
			
			return a;
		}
	}
	
	public static void main(String[] args) {
		Solution a = new Solution();
		int[] res = a.lcmAndGcd(8,6);
		System.out.println(Arrays.toString(res));
	}
}
