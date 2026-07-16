package strings.basic;

public class LongestCommonPrefix {
	//TC - n*m, n is total string, m is the length of shortest string
    // public String longestCommonPrefix(String[] strs) {
    //     StringBuilder longestPrefix= new StringBuilder("");
    //     for(int i=0;i<strs[0].length();i++){
    //         for(String s:strs){
    //             if(i==s.length() || s.charAt(i)!=strs[0].charAt(i)) 
    //                 return longestPrefix.toString(); 
    //         }
    //         longestPrefix.append(strs[0].charAt(i));
    //     }

    //     return longestPrefix.toString();
    // }
    //TC - n*m
    public static String longestCommonPrefix(String[] strs) {
        String result=strs[0];
        for(int i=1;i<strs.length;i++) {
        	while(!strs[i].startsWith(result))
        		result=result.substring(0,result.length()-1);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		String[]strs = {"flower","flow","flight"};
//		String[]strs = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
	}
}
