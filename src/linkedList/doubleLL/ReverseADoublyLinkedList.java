package linkedList.doubleLL;

import java.util.*;

import linkedList.doubleLL.DoublyLLFunctions.*;

public class ReverseADoublyLinkedList {
	
	//TC - o(2n), SC - o(n)
	private static Node reverseDLLBrute(Node head) {
		Stack<Integer> st = new Stack<>();
		Node tmp = head;
		
		if(head==null || head.next==null) return head;
		
		while(tmp!=null) {
			st.add(tmp.data);
			tmp = tmp.next;
		}
		tmp=head;
		while(tmp!=null) {
			tmp.data = st.pop();
			tmp = tmp.next;
		}
		
		return head;
	}
	
	//TC - o(n)
	private static Node reverseDLLOptimal(Node head) {
		Node prev=null;
		Node current = head;
		
		if(head==null || head.next==null) return head;
		while(current!=null) {
			prev = current.prev;
			current.prev = current.next;
			current.next = prev;
			
			current = current.prev; //since next element is stored in prev
		}
		
		return  prev.prev;
	}
	public static void main(String[] args) {
		int[] arr = {10,20,30,40};
		Node head = DoublyLLFunctions.convertArrToDLL(arr);
		DoublyLLFunctions.printDLL(head);
//		reverseDLLBrute(head); //#1
		DoublyLLFunctions.printDLL(reverseDLLOptimal(head)); //#2
		
	}
}
