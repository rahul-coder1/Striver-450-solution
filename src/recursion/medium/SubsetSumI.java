package recursion.medium;
import java.util.*;

public class SubsetSumI {
	//TC - o(2^nlog(2^n) + 2^n), SC - o(2^n)+o(n) recursion depth
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ls = new ArrayList<>();
        generate(0,0,arr,ls);
        Collections.sort(ls); //here sorting (2^nlog(2^n))
        
        return ls;
    }
    
    static void generate(int idx, int s, int[]arr, ArrayList<Integer> ls){
        if(idx>=arr.length){
            ls.add(s);
            return;
        }
        //dont take
        generate(idx+1,s,arr,ls);
        //take
        generate(idx+1,s+arr[idx],arr,ls);
        
    }
    
    public static void main(String[] args) {
    	System.out.println(subsetSums(new int[] {1,2,3}));
	}
}
