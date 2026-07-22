package string.medium;
import java.util.*;
public class RomanToInteger {
	//TC - o(n), SC - o(1)
    private static int value(char c){
        return switch(c){
            case 'I'->1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default->1000;
        };
    }
    public static int romanToInt(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1 && value(s.charAt(i))<value(s.charAt(i+1))){
                res+=value(s.charAt(i+1))-value(s.charAt(i));
                i++;
            }else{
                res+=value(s.charAt(i));
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
		String[] str= {"III","LVIII","MCMXCIV"};
		for(String i:str) {
			System.out.println(romanToInt(i));
		}
	}
}
