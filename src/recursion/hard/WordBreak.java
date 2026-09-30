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
    
    public static void main(String[] args) {
		System.out.println(wordBreakBrute("leetcode", List.of("leet", "code")));
	}
}
