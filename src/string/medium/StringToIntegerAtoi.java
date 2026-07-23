package string.medium;

public class StringToIntegerAtoi {
	public static int myAtoi(String s) {
		int value=0;
        if (s.isEmpty()) return 0;
        int sign=1,j=0;
        while(j<s.length()&& s.charAt(j)==' ')j++;
        if(j==s.length()) return 0;
        for(int i=j;i<s.length();i++){
            if(i==j){
                if(s.charAt(i)=='-'){
            	    sign=-1;continue;
                }
                else if(s.charAt(i)=='+') continue;
            }
            if(0<=s.charAt(i)-'0' && s.charAt(i)-'0'<=9){
                int digit = s.charAt(i)-'0';
                if(value>Integer.MAX_VALUE/10 || (value==Integer.MAX_VALUE/10 && digit>7)){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                value=value*10+(s.charAt(i)-'0');
            }
            else break;

        }

        return sign*value;
    }
	
	public static void main(String[] args) {
		String[] str = {"+1","1337c0d3","0-1","words and 987","9223372036854775809"};
		for(String s:str) {
			System.out.println(myAtoi(s));
		}
		System.out.printf("Integer max:%d, overflow %d\n",Integer.MAX_VALUE,Integer.MAX_VALUE+1);
		System.out.printf("Integer min:%d, overflow %d",Integer.MIN_VALUE,Integer.MIN_VALUE-1);
	}
}
