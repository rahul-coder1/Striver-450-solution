package recursion;

import java.util.*;

public class ReverseAStackUsingRecursion {
	//TC - o(n^2), SC - o(n)
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int top = st.pop();
        reverseStack(st);
        reverse(st, top);
    }
    
    public static void reverse(Stack<Integer> st, int ele){
        if(st.isEmpty()) {
        	st.push(ele);
        	return;
        }
        int top = st.pop();
        reverse(st, ele);
        st.push(top);
    }
    
    public static void main(String[] args) {
    	Stack<Integer> st = new Stack<>();
		int[] arr = {1,2,3,4,5,6};
		SortAstackUsingRecursion.insertInStack(arr, st);
		SortAstackUsingRecursion.printStack(st);
		reverseStack(st);
		SortAstackUsingRecursion.printStack(st);
	}
}
