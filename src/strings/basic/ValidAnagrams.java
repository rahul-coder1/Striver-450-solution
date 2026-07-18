package strings.basic;

public class ValidAnagrams {
	public static boolean isAnagram(String s, String t) {
		int[] alphabets=new int[26];
		if(s.length()!=t.length()) return false;
		for(int i=0;i<s.length();i++) {
			alphabets[s.charAt(i)-'a']+=1;
			alphabets[t.charAt(i)-'a']-=1;
		}
		
		for(int i:alphabets) if(i!=0) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
//		String s = "anagram", t = "nagaram";
		String s = "rat", t = "car";
		System.out.println(isAnagram(s, t));
	}
}
