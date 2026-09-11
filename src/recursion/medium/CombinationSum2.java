package recursion.medium;

import java.util.*;

public class CombinationSum2 {
	//TC - o(n2^n -recursion)+o(nlogn -sort), SC- o(n*2^n -hashset size in wc), o(n-recursion depth)
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
    
  //TC - o(nlogn + 2^n-backtrack +k.x-adding the total combination) k-avg length of any combination while adding in list WC - o(k.x =~ n.2^n), SC - o(k*x + n-auxiliary/depth), x-total combination
    public static List<List<Integer>> combinationSum2Optimal(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        Arrays.sort(candidates);
        generateOptimal(0, target, candidates, op, res);
    
        return res;
    }

    static void generateOptimal(int idx, int t, int[] arr, List<Integer> op, List<List<Integer>> res){
        if(t==0){
            res.add(new ArrayList<>(op));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(arr[i]>t) break;
            op.add(arr[i]);
            generateOptimal(i+1, t-arr[i], arr, op, res);
            op.remove(op.size()-1);
        }
        
    }
    
    public static void main(String[] args) {
    	System.out.println(combinationSum2Brute(new int[] {10,1,2,7,6,1,5}, 8));
    	System.out.println(combinationSum2Brute(new int[] {1,1,1,2,2}, 4));
    	System.out.println(combinationSum2Optimal(new int[] {1,1,1,2,2}, 4));
	}
}









