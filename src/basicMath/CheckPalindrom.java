package basicMath;


public class CheckPalindrom {
	static class Solution {
	    public boolean isPalindrome(int x) {
	    	String s =Integer.toString(x); boolean res=true;
//	    	System.out.println("string::"+s);
//	    	int a=0110;
//	    	System.out.println(a);
	    	int len = s.length();
	    	for(int i=0;i<=len/2;i++) {
	    		if(s.charAt(i)!=s.charAt(len-1-i)) {
	    			res=false;
	    		}
	    		
	    	}
	    	
	    	return res;
	    }
	    
	    public boolean isPalindromeAnotherWay(int x) {
	    	boolean res=true;
	    	int duplicate =x;
	    	int rev=0;
	    	while(x!=0) {
	    		int digit=x%10;
	    		x=x/10;
	    		rev=rev*10+digit;
	    	}
	    	if(duplicate != rev)
	    		res=false;
	    	return res;
	    }
	}
	
	public static void main(String[] args) {
		Solution a = new Solution();
//		boolean res = a.isPalindrome(1110110111);
		boolean res = a.isPalindromeAnotherWay(10);
		System.out.println(res);
	}
}
