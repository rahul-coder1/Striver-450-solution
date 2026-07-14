package strings.basic;

public class RemoveOutermostParentheses {
	//TC - o(n)
    // public String removeOuterParentheses(String s) {
    //     int cnt=0; 
    //     StringBuilder sb = new StringBuilder();
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i)=='('){
    //             if(cnt>0) sb.append('(');
    //             cnt+=1;
    //         }
    //         else{
    //             cnt-=1;
    //             if(cnt>0) sb.append(')');
    //         }
    //     }

    //     return sb.toString();
    // }
     public static String removeOuterParentheses(String s) {
        int cnt=0; 
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                if(cnt>0) sb.append('(');
                cnt+=1;
            }
            else{
                cnt-=1;
                if(cnt>0) sb.append(')');
            }
        }

        return sb.toString();
    }
     
    public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())"));
	}
}











