package strings.basic;

import java.util.Arrays;

public class ReverseWordsInAString {
	//TC - o(n)
    public static String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int startIdx = s.length()-1;
        while(startIdx>=0){
            while(startIdx>=0 && s.charAt(startIdx)==' ') startIdx-=1;
            if(startIdx<0) break;
            int endIdx=startIdx;
            while(startIdx>=0 && s.charAt(startIdx)!=' ') startIdx-=1;

            if(sb.length()>0) sb.append(' ');
            sb.append(s.substring(startIdx+1,endIdx+1));
        }

        return sb.toString();
    }
	public static void main(String[] args) {
		String s = "a good   example";
		System.out.println(reverseWords(s));
	}
}
