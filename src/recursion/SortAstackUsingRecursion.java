package recursion;

import java.util.*;

public class SortAstackUsingRecursion {
	//TC - o(n^2), SC - o(n)
    public static void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int top = st.pop();
        sortStack(st);
        
        sort(top,st);
    }
    
    private static void sort(int top, Stack<Integer>st){
        if(st.isEmpty()) st.push(top);
        else{
            if(st.peek()>top){
                int x = st.pop();
                sort(top,st);
                st.push(x);
            }else{
                st.push(top);
            }
        }
        
    }
    private static void insertInStack(int[] arr, Stack<Integer> st) {
    	for(int i:arr) {
    		st.push(i);
    	}
    }
    private static void printStack(Stack<Integer> st) {
    	for(int i=st.size()-1;i>=0;i--) {
    		System.out.print(st.get(i)+" ");
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		int[] arr = {41, 3, 32, 2, 11};
		insertInStack(arr, st);
		printStack(st);
		sortStack(st);
		printStack(st);
	}
}
