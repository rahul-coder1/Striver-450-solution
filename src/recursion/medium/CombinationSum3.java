package recursion.medium;
import java.util.*;

public class CombinationSum3 {
	//TC - O(2^9 + k·x)k-length with x unique combination , SC - o(k.x)+o(9-recursion depth), o(k) - op 
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        generate(1,k,0, n, op, res);
    
        return res;
    }

    static void generate(int i, int k, int sum, int n, List<Integer> op, List<List<Integer>> res){
        if(sum>n) return;
        if(k==0){
            if(sum == n){
                res.add(new ArrayList<>(op));
            }
            return;
        }
        if(i>9) return;
        //dont take
        generate(i+1,k,sum,n,op,res);
        //take
        op.add(i);
        generate(i+1,k-1,sum+i,n,op,res);
        op.remove(op.size()-1);
    }
    
    public static void main(String[] args) {
		System.out.println(combinationSum3(9, 45));
		System.out.println(combinationSum3(2, 6));
	}
}












