package string.medium;

public class LongestPalindromicSubstring {
	
	//TC - o(n^3)
	public static String longestPalindromeBrute(String s) {
		String lps="";
		int n=s.length();
		
		for(int i=0;i<n;i++) {// o(n)
			for(int j=i;j<n;j++) {// o(n)
				if(isPalindrome(s,i,j)) { //o(n)
					if(j-i+1>lps.length()) {
						lps=s.substring(i,j+1);
					}
				}
			}
		}
		return lps;
	}
	
	public static boolean isPalindrome(String s, int left, int right) {
		while(left<=right) {
			if(s.charAt(left)!=s.charAt(right)) return false;
			left++;right--;
		}
		return true;
	}
	
	//---------------------------------------------------------------------------------------------------------
	//TC - o(n^2), SC - o(1)
    public static String longestPalindromeExpandAroundCenter(String s) {
    	if(s==null || s.length()<2) return s; //base case
    	int start=0, maxLen=0, n= s.length();
    	for(int i=0;i<n;i++) {
    		
    		//## odd case where both left and right at same index
    		int left=i,right=i; 
    		while(left>=0 && right<n && s.charAt(left)==s.charAt(right)) {
    			if(right-left+1>maxLen) {
    				maxLen=right-left+1;
    				start=left;
    			}
    			left-=1;right+=1;
    		}
    		
    		//## even case where right is ahead 1 of left at start
    		left=i;
    		right=i+1;
    		while(left>=0 && right<n && s.charAt(left)==s.charAt(right)) {
    			if(right-left+1>maxLen) {
    				maxLen=right-left+1;
    				start=left;
    			}
    			left-=1;right+=1;
    		}
    	}
    	
    	return s.substring(start,start+maxLen);
    }
	public static void main(String[] args) {
		String[] str = {"babad","cbbd"};
		for(String s:str) {
//			System.out.println(longestPalindromeBrute(s));
			System.out.println(longestPalindromeExpandAroundCenter(s));
		}
	}
}



























