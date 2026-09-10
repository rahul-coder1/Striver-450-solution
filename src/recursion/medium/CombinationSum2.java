package recursion.medium;

import java.util.*;

public class CombinationSum2 {
	public static List<List<Integer>> combinationSum2Brute(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> op = new ArrayList<>();
        Arrays.sort(candidates);
        generate(0, target, candidates, op, res);

        return new ArrayList<>(res);
    }

    static void generate(int idx, int s, int[] arr, List<Integer> op, Set<List<Integer>> res){
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
            generate(idx+1,s-arr[idx],arr,op,res);
            //backtrack
            op.remove(op.size()-1);
        }
    }
    
    public static void main(String[] args) {
    	System.out.println(combinationSum2Brute(new int[] {10,1,2,7,6,1,5}, 8));
	}
}









