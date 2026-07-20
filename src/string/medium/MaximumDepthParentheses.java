package string.medium;

public class MaximumDepthParentheses {
	 //TC - o(n), n-string length
    public static int maxDepth(String s) {
        int maxDepth=0,cnt=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                cnt+=1; 
                maxDepth=Math.max(maxDepth,cnt);
            }
            else if(c==')') cnt-=1;
        }

        return maxDepth;
    }
    
    public static void main(String[] args) {
		String[] str= {"(1+(2*3)+((8)/4))+1","(1)+((2))+(((3)))","()(())((()()))"};
		for(String i:str) {
			System.out.println(maxDepth(i));
		}
	}
}
