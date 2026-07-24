package string.medium;

public class LongestPalindromicSubstring {
	
	public static String longestPalindromeBrute(String s) {
		String lps="";
		int n=s.length();
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(isPalindrome(s,i,j)) {
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
	
	public static void main(String[] args) {
		String[] str = {"babad","cbbd"};
		for(String s:str) {
			System.out.println(longestPalindromeBrute(s));
		}
	}
}
