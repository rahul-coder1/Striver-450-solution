package basicMath;

public class ReverseInteger {
	static class Solution {
	    public int reverse(int x) {
	        int res=0;
	        while(x!=0) {
	        	int digit=x%10;
//	        	System.out.println("digit:"+digit);
	        	x=x/10;
	        	if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit>7)) 
	        		return 0;
	        	if(res < Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && digit >8 ))
	        		return 0;
	        	res=res*10 + digit;
	        }
	        
	        return res;
	    }
	}
	
	public static void main(String[] args) {
		Solution a = new Solution();
		int res = a.reverse(-1463847412);
		System.out.println(res);
	}
}
