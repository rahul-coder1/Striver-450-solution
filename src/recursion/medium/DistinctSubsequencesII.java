package recursion.medium;

public class DistinctSubsequencesII {
	//TC - o(n), SC - o(26)=o(1)
    public static int distinctSubseqII(String s) {
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
		System.out.println(distinctSubseqII("abc"));
		System.out.println(distinctSubseqII("aba"));
		System.out.println(distinctSubseqII("aaa"));
	}
}
