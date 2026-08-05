package linkedList.medium;

import java.util.*;

public class CycleLengthInLinkedList {
	//TC - o(n*2logn), SC - o(n)
	public static int lengthOfLoopBrute(ListNode head) {
        Map<ListNode, Integer> mp = new HashMap<>();
        ListNode curr = head;
        int len=0;
        while(curr!=null){
            if(mp.containsKey(curr)){
                int value = mp.get(curr);
                return len - value;
            }
            mp.put(curr,len);
            len+=1;
            curr = curr.next;
        }
        return 0;
    }
	
	//TC - O(x + L) + O(L) ~= 3n ~ o(n)
	public static int lengthOfLoopOptimal(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast!=null && fast.next!=null) {//TC - O(x + L)
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				return cycleLength(slow);
			}
		}
		
		return 0;
	}
	
	public static int cycleLength(ListNode slow) { //1-2-3-4-5, link=2-5
		int len=0;
		ListNode curr = slow;
		slow = slow.next; len+=1;
		while(curr!=slow) {//TC - O(L)
			len+=1;
			slow = slow.next;
		}
			
		return len;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		ListNode head = ListNode.linkedListForming(arr);
		head.next.next.next.next.next = head.next;
		System.out.println(lengthOfLoopOptimal(head));
	}
}
