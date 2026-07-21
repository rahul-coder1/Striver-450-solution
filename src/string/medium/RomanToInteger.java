package string.medium;
import java.util.*;
public class RomanToInteger {
	//TC - o(n), SC - o(1)
    public static int romanToInt(String s) {
        Map<Character,Integer> nums = new HashMap<>();
        nums.put('I',1);nums.put('V',5);nums.put('X',10);nums.put('L',50);nums.put('C',100);
        nums.put('D',500);nums.put('M',1000);
        int value=0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1 && nums.get(s.charAt(i))<nums.get(s.charAt(i+1))){
                value+=nums.get(s.charAt(i+1))-nums.get(s.charAt(i));
                i++;
            }else{
                value+=nums.get(s.charAt(i));
            }
        }

        return value;
    }
    
    public static void main(String[] args) {
		String[] str= {"III","LVIII","MCMXCIV"};
		for(String i:str) {
			System.out.println(romanToInt(i));
		}
	}
}
