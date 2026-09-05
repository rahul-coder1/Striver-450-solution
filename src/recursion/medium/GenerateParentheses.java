package recursion.medium;
import java.util.*;

public class GenerateParentheses {
//This is a catalan number problem
	//TC - O(n × Cn), , SC - o(2n)-recursion depth/recursive stack + o(2n for sb) + o(2n × Cn for arr)
    public static List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(0,0,n,arr,sb);

        return arr;
    }
    static void backtrack(int openP, int closeP, int n, List<String> arr, StringBuilder res){
        if(closeP==n && openP == n){
            arr.add(res.toString());
            return;
        }
        if(openP<n){
            res.append("(");
            backtrack(openP+1,closeP,n,arr,res);
            res.deleteCharAt(res.length()-1);
        }
        if(closeP<openP){
            res.append(")");
            backtrack(openP,closeP+1,n,arr,res);
            res.deleteCharAt(res.length()-1);
        }
    }
    
    public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
		System.out.println(generateParenthesis(3));
	}
}











