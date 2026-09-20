package recursion.medium;
import java.util.*;

public class LetterCombinationsPhoneNumber {
	//TC - o(n*4^n - assuming each digit has 4 chars, n for copying), SC - O(n * 4^n) output + O(2n) auxiliary
	public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(!digits.isEmpty())
            generate(0, digits, sb, res);

        return res;
    }
	
	static void generate(int idx, String digits, StringBuilder sb, List<String> res){
		if(idx==digits.length()) {
			res.add(sb.toString());
			return;
		}
		
		String letters = digitToLetter(digits.charAt(idx));
		for(char c: letters.toCharArray()) {
			sb.append(c);
			generate(idx+1, digits, sb, res);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static String digitToLetter(char digit){
        String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        return arr[digit-'0'];
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("94"));
	}
}













