package recursion.medium;
import java.util.*;

public class PrintAllSubsequencesWhoseSumIsK {
	public static List<List<Integer>> res = new ArrayList<>();
    // TC: O(2^n + output size), commonly bounded by O(n * 2^n)
    // SC: O(output size) + O(n) auxiliary
    // Worst case: O(n * 2^n)
    public static List<List<Integer>> printSubsequences(int n, int[] arr, int sum) {
    	res.clear();
        int s=0;
        List<Integer> list = new ArrayList<>();
        generate(0,s,sum,n,arr,list);

        return res;
    }

    static void generate(int idx, int s, int sum, int n, int[]arr, List<Integer> list){
        if(idx>=n){
            if(s==sum){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        //dont take
        generate(idx+1,s,sum,n,arr,list);
        //take
        s+=arr[idx];
        list.add(arr[idx]);
        generate(idx+1,s,sum,n,arr,list);
        //backtrack
        list.remove(list.size()-1);

    }
    
    //TC - O(2n+total size of printed output) wc-o(n*2^n), SC - o(n)+o(n) - recursion depth
    public static void printSubsequencesOptimal(int n, int[] arr, int sum) {
        int s=0;
        List<Integer> list = new ArrayList<>();
        generateOptimal(0,s,sum,n,arr,list);

    }
    
    static void generateOptimal(int idx, int s, int sum, int n, int[]arr, List<Integer> list){
    	if(idx>=n){
    		if(s==sum){
    			System.out.print(list+" ");
    		}
    		return;
    	}
    	//dont take
    	generateOptimal(idx+1,s,sum,n,arr,list);
    	//take
    	s+=arr[idx];
    	list.add(arr[idx]);
    	generateOptimal(idx+1,s,sum,n,arr,list);
    	//backtrack
    	list.remove(list.size()-1);
    	
    }
    
    public static void main(String[] args) {
		System.out.println(printSubsequences(4,new int[] {1,2,1,3},3));
		printSubsequencesOptimal(4,new int[] {1,2,1,3},3);
	}
}
