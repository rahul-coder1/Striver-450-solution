package recursion.medium;
import java.util.*;

public class SubSequencesPowerSet {
	 //TC - o(n*2^n), SC - o(n*2^n)+o(n)-recursion depth
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        generate(0,nums,op,res);

        return res;
    }

    static void generate(int idx, int[] arr,List<Integer> op, List<List<Integer>> res){
        if(idx>=arr.length){
            res.add(new ArrayList<>(op));
            return;
        }
        //dont take
        generate(idx+1,arr,op,res);
        op.add(arr[idx]);
        //take
        generate(idx+1,arr,op,res);
        //backtrack
        op.remove(op.size()-1);
    }
    
    public static void main(String[] args) {
		System.out.println(subsets(new int[]{1,2,3}));
	}
}











