package recursion;

/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/
public class PalindromString {
	
	public static boolean isPalindrome(String s) {
		s=s.toLowerCase();
		int left=0,right=s.length()-1;
		while(left<right) {
			while(left<right && !Character.isLetterOrDigit(s.charAt(left)))
				left++;
			while(left<right && !Character.isLetterOrDigit(s.charAt(right)))
				right--;
			
			if(s.charAt(left) != s.charAt(right))
				return false;
				
			left++;right--;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
//		String s = "A man, a plan, a canal: Panama";
		String s="a12a";
		System.out.println(isPalindrome(s));
		System.out.println(Character.isLetterOrDigit(s.charAt(1)));
	}
}




























