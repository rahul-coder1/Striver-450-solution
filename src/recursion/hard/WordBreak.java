package recursion.hard;
import java.util.*;

public class WordBreak {
	//TC - o(n^2.2^n+o(D+S)), n^2 beacuse for-n and hash+sub-n, SC - o(n-stack-D+S )
    public static boolean wordBreakBrute(String s, List<String> wordDict) {
        return solve(0,s,new HashSet<>(wordDict));
    }

    static boolean solve(int idx, String s, Set<String> wd){
        if(idx>=s.length()) return true;

        for(int end=idx; end<s.length();end++){
            String word = s.substring(idx,end+1);
            if(wd.contains(word) && solve(end+1,s,wd)){
                return true;
            }
        }

        return false;
    }
    
  //TC - o(n^3), n^2 for loop and solve func and+o(n)for hash+substring func-n, SC - o(n-stack + D+S + n-dp )
    public static boolean wordBreakOptimal(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solveOptimal(0,s,new HashSet<>(wordDict), dp);
    }

    static boolean solveOptimal(int idx, String s, Set<String> wd, Boolean[] dp){
        if(idx==s.length()) return true;

        if(dp[idx]!=null){
            return dp[idx];
        }

        for(int end=idx; end<s.length();end++){
            String word = s.substring(idx,end+1);
            if(wd.contains(word) && solveOptimal(end+1,s,wd,dp)){
                return dp[idx]=true;
            }
        }

        return dp[idx]=false;
    }
    
  //TC - o(n^3), n^2 for loop and solve func and+o(n)for hash+substring func-n, SC - o(n-stack + D+S + n-dp )
    public static boolean wordBreakOptimalOptimized(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Set<Integer> wordLen = new HashSet<>();
        for(String word:wordDict){
            wordLen.add(word.length());
        }
        return solveOptimalOptimized(0,s,new HashSet<>(wordDict), dp, wordLen);
    }

    static boolean solveOptimalOptimized(int idx, String s, Set<String> wd, Boolean[] dp, Set<Integer> wordLen){
        if(idx==s.length()) return true;

        if(dp[idx]!=null){
            return dp[idx];
        }

        for(int len : wordLen){
            int end = idx+len;
            if(end > s.length()) continue;
            String word = s.substring(idx,end);
            if(wd.contains(word) && solveOptimalOptimized(end,s,wd,dp,wordLen)){
                return dp[idx]=true;
            }
        }

        return dp[idx]=false;
    }
    
    public static void main(String[] args) {
		System.out.println(wordBreakBrute("leetcode", List.of("leet", "code")));
		System.out.println(wordBreakOptimal("leetcode", List.of("leet", "code")));
		System.out.println(wordBreakOptimalOptimized("leetcode", List.of("leet", "code")));
	}
}
