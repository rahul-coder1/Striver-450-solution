package recursion.medium;
import java.util.*;

public class DistinctSubsequencesII {
	//TC - o(n*2^n), SC - o(n*2^n)+o(n - recursion stack)+o(n - stringBuilder) - this sol will 100% give TLE
	public static int distinctSubseqIIBrute(String s) {
		Set<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		generate(0,s,set,sb);
		
		return set.size();
	}
	
	
	private static void generate(int idx, String s, Set<String> set, StringBuilder sb) {
		if(idx>=s.length()) {
			if(sb.length()!=0) {
				set.add(sb.toString());
			}
			return;
		}
		
		//dont take
		generate(idx+1, s, set, sb);
		
		//take
		sb.append(s.charAt(idx));
		generate(idx+1, s, set, sb);
		
		//backtrack
		sb.deleteCharAt(sb.length()-1);
		
	}


	//TC - o(n), SC - o(26)=o(1)
    public static int distinctSubseqIIOptimal(String s) {
        int MOD = 1_000_000_007;
        int total = 0;
        int[] endsWith = new int[26];
        for(char c:s.toCharArray()){
            int index = c-'a';
            int subsequence = (total+1-endsWith[index]+MOD)%MOD;
            total = (total+subsequence)%MOD;
            endsWith[index] = (endsWith[index]+subsequence)%MOD;
        }

        return total;
    }
    
    public static void main(String[] args) {
		System.out.println(distinctSubseqIIBrute("abc"));
		System.out.println(distinctSubseqIIBrute("aba"));
		System.out.println(distinctSubseqIIBrute("aaa"));
		System.out.println(distinctSubseqIIOptimal("abc"));
		System.out.println(distinctSubseqIIOptimal("aba"));
		System.out.println(distinctSubseqIIOptimal("aaa"));
	}
}
