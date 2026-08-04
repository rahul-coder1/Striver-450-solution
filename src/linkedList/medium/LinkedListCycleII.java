package linkedList.medium;

import java.util.*;

public class LinkedListCycleII {
	//TC - o(n*2logn), SC - o(n)
	public static ListNode detectCycleBrute(ListNode head) {
		Map<ListNode, Integer> mp = new HashMap<>();
		ListNode curr = head;
		while(curr!=null) {
			if(mp.getOrDefault(curr, 0)==1) {
				return curr;
			}else {
				mp.put(curr,mp.getOrDefault(curr, 0)+1);
			}
			
			curr = curr.next;
		}
		
		return null;
	}
	
	//TC - o(n), floyd tortoise and hare method
    public static ListNode detectCycleOptimal(ListNode head) {
    	ListNode slow = head, fast = head;
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast) {
    			slow = head;
    			while(slow!=fast) {
    				slow = slow.next;
    				fast = fast.next;
    			}
    			
    			return slow;
    		}
    	}
    	
    	return null;
    }
	public static void main(String[] args) {
		int[] arr = {10,20,30,40};
		ListNode head = ListNode.linkedListForming(arr);
		head.next.next.next = head.next;
		System.out.println(detectCycleOptimal(head).data);
	}
}





