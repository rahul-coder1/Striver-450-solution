package recursion.medium;

import java.util.*;

public class CombinationSum {
	 //TC - o(2^t*k) t>n in wc, SC - o(t*x) exponential worst case 
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        generate(0, target, candidates, op, res);

        return res;
    }

    static void generate(int idx, int s, int[] arr, List<Integer> op, List<List<Integer>> res){
        if(s==0){
            res.add(new ArrayList<>(op));
            return;
        }
        if(idx>=arr.length) return;
        
        //dont pick
        generate(idx+1,s,arr,op, res);

        //pick
        if(s>=arr[idx]){
            op.add(arr[idx]);
            generate(idx,s-arr[idx],arr,op,res);
            //backtrack
            op.remove(op.size()-1);
        }
    }
    
    public static void main(String[] args) {
		System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
		System.out.println(combinationSum(new int[] {2,3,5}, 8));
		System.out.println(combinationSum(new int[] {2}, 1));
	}
}






