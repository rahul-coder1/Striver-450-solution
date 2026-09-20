package recursion.hard;
import java.util.*;

public class PalindromePartitioning {
	//TC - O(n^2*2^n) n^2 beacuse isPalindrome everytime, SC - o(n.2^n - res + n-stack + n-op (n^2 for op in worst case as substring method creates new string))
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> op = new ArrayList<>(); //op - options List

        if(!s.isEmpty())
            generate(0,s,op,res);

        return res; 
    }

    static void generate(int idx, String s, List<String> op, List<List<String>> res){
        if(idx==s.length()){
            res.add(new ArrayList<>(op));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                op.add(s.substring(idx,i+1));
                generate(i+1,s,op,res);
                //backtrack
                op.remove(op.size()-1);
            }
        }
    }

    static public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l+=1;
            r-=1;
        }

        return true;
    }
    public static void main(String[] args) {
		System.out.println(partition("aab"));
	}
}










