package strings.basic;

import java.util.*;

public class IsomorphicStrings {
	//TC for hashmap solution - o(n+c(hashmap operations)), SC - o(2n) but since characters are ascii therefore 256
    //space only which is constant
    //TC for array solution also same time complexity but hashmap operations will be reduced
    public static boolean isIsomorphic(String s, String t) {
        // Map<Character, Character> st = new HashMap<>();
        // Map<Character, Character> ts = new HashMap<>();
        int[] st = new int[128];
        int[] ts = new int[128];
        Arrays.fill(st,-1);
        Arrays.fill(ts,-1);
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char s1=s.charAt(i);
            char t1=t.charAt(i);
            // if(!st.containsKey(s1)) st.put(s1,t1);
            // if(!ts.containsKey(t1)) ts.put(t1,s1);
            // if(st.get(s1)!=t1 || ts.get(t1)!=s1) return false;
            if(st[s1]==-1) st[s1]=t1;
            if(ts[t1]==-1) ts[t1]=s1;
            if(st[s1]!=t1 || ts[t1]!=s1) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
//		String s = "egg", t = "add";
    	String  s = "f11", t = "b23";
		System.out.println(isIsomorphic(s, t));
	}
}







