package recursion;


//two pointer approach
public class ReverseAString {
	
	public static void reverse(char[] s) {
		helper(s, 0, s.length-1);
	}
	
	public static void helper(char s[], int left, int right) {
		if(left<right) {
			char temp=s[left];
			s[left]=s[right];
			s[right]=temp;
			left++;right--;
			
			helper(s,left,right);
		}
		else return;
	}
	
	public static void main(String[] args) {
		char[] s= {'H','e','l','l','o'};
		reverse(s);
		System.out.println(s);
		String a="abvc";
//		System.out.println(a[1]); cant do this as String is not array, either convert it to toCharArray
	}
}
