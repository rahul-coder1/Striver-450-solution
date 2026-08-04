package linkedList.medium;

import java.util.*;

public class LinkedListCycleDetectLoop {
	
	public static boolean hasCycleBrute(ListNode head) {
		boolean flag = false;
		Map<ListNode, Integer> mp = new HashMap<>();
		
		if(head==null || head.next==null) return flag;
		ListNode curr = head;
		while(curr!=null) {
			if(mp.getOrDefault(curr, 0)==1) {
				flag = true; 
				break;
			}else {
				mp.put(curr, mp.getOrDefault(curr,0)+1);
			}
			
			curr = curr.next;
		}
		
		return flag;
	}
	
	//TC - o(n)
    public static boolean hasCycleOptimal(ListNode head) {
    	boolean flag = false;
    	if(head==null || head.next==null) return flag;
    	
    	ListNode slow = head, fast = head;
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast) {
    			flag = true; break;
    		}
    	}
    	return flag;
    }
	public static void main(String[] args) {
		int[] arr = {10,20,30,40};
		ListNode head = ListNode.linkedListForming(arr);
		head.next.next.next = head;
		System.out.println(hasCycleBrute(head));
	}
}
