package linkedList.medium;

import java.util.*;

public class ReverseALinkedList {
	//TC - o(2n), SC - o(n)
	public static ListNode reverseListBrute(ListNode head) {
		Stack<Integer> st = new Stack<>();
		ListNode curr = head;
		while(curr!=null) {
			st.add(curr.data);
			curr = curr.next;
		}
		
		curr = head;
		while(curr!=null) {
			curr.data = st.pop();
			curr = curr.next;
		}
		
		return head;
	}
	
	//TC - o(n)
	public static ListNode reverseListOptimal(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while(curr!=null) {
			ListNode front = curr.next;
			curr.next = prev;
			prev = curr;
			curr = front;
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
//		ListNode.printLL(reverseListBrute(head)); //#1
		ListNode.printLL(reverseListOptimal(head)); //#1
	}
}
















