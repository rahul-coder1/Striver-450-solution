package linkedList.doubleLL;

import linkedList.medium.ListNode;
import java.util.*;

public class OddEvenLinkedList {
	//TC - o(2n), SC - o(n)
	public static ListNode oddEvenListBrute(ListNode head) {
		if(head==null || head.next==null) return head;
		List<Integer> arr = new ArrayList<>();
		ListNode curr = head;
		while(curr!=null && curr.next!=null) {
			arr.add(curr.data);
			curr = curr.next.next;
		}
		if(curr!=null) arr.add(curr.data);
		
		curr = head.next;
		while(curr!=null && curr.next!=null) {
			arr.add(curr.data);
			curr = curr.next.next;
		}
		if(curr!=null) arr.add(curr.data);
		
		curr=head; int i=0;
		while(curr!=null) {
			curr.data = arr.get(i);
			i+=1;
			curr = curr.next;
		}
		
		return head;
	}
	
	//TC - o(n/2) ~ 0(n)
	public static ListNode oddEvenListOptimal(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode odd = head, even = head.next, evenHead = even;
		while(even!=null && even.next!=null) {
			odd.next = even.next;
			odd = odd.next;
			
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		
		return head;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {2,1,4,3,6};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(oddEvenListOptimal(head));
	}
}
