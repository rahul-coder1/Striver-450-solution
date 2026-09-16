package recursion.medium;
import java.util.*;

public class SubsetsII {
	//TC - o(n2^n + nlogn), SC -o(n2^n)+ o(n)-recursion/auxiliary
    public static List<List<Integer>> subsetsWithDupOptimal(int[] nums) {
        List<Integer> op = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        generateOptimal(0,nums,op,res);
        
        return res;
    }

    static void generateOptimal(int idx, int[]arr, List<Integer> op, List<List<Integer>> res){
        res.add(new ArrayList<>(op));
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            op.add(arr[i]);
            generateOptimal(i+1,arr,op,res);
            op.remove(op.size()-1);
        }
        
    }
    
	//TC - o(n2^n+nlogn), SC - o(n2^n + n-recursion depth, + n-op)
    public static List<List<Integer>> subsetsWithDupBrute(int[] nums) {
        List<Integer> op = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        generateBrute(0,nums,op,res);
        
        return new ArrayList<>(res);
    }

    static void generateBrute(int idx, int[]arr, List<Integer> op, Set<List<Integer>> res){
        if(idx>=arr.length){
            res.add(new ArrayList<>(op));
            return;
        }

        //dont take
        generateBrute(idx+1,arr,op,res);
        //take
        op.add(arr[idx]);
        generateBrute(idx+1,arr,op,res);
        //backtrack
        op.remove(op.size()-1);
    }
    
    public static void main(String[] args) {
		System.out.println(subsetsWithDupBrute(new int[]{1,2,2}));
		System.out.println(subsetsWithDupOptimal(new int[]{1,2,2}));
	}
}




