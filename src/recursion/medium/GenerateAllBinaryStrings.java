package recursion.medium;
import java.util.*;

public class GenerateAllBinaryStrings {
    //TC - o(n*2^n), SC - o(n)
    public static ArrayList<String> binstr(int n) {
        ArrayList<String> arr = new ArrayList<>();
        String bits = "";
        generate(arr,bits,n);
        
        return arr;
    }
    
    static void generate(ArrayList<String> arr,String bits, int n){
        if(bits.length()==n){
            arr.add(bits);
            return;
        }
        generate(arr, bits+'0',n);
        generate(arr, bits+'1',n);
    }
    
    public static void main(String[] args) {
    	int n =3;
		ArrayList<String> arr = binstr(n);
		for(String s:arr) {
			System.out.print(s+" ");
		}
	}
}
