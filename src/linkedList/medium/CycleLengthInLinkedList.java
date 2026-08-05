package linkedList.medium;

import java.util.*;

public class CycleLengthInLinkedList {
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
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40};
		ListNode head = ListNode.linkedListForming(arr);
		head.next.next.next = head.next;
		System.out.println(lengthOfLoopBrute(head));
	}
}
