package linkedList.medium;

import java.util.*;

public class IntersectionoFTwoLinkedLists {
	//TC - o(2*(n+m)), SC - (n+m)
    public static ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> mp = new LinkedHashMap<>();
        if(headA==null || headB==null) return null;
        ListNode curr = headA;
        while(curr!=null){
            mp.put(curr, mp.getOrDefault(curr,0)+1);
            curr = curr.next;
        }
        curr = headB;
        while(curr!=null){
            mp.put(curr, mp.getOrDefault(curr,0)+1);
            curr = curr.next;
        }
        for(Map.Entry<ListNode, Integer> i: mp.entrySet()){
            if(i.getValue()>1) return i.getKey();
        }

        return null;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		int[] arr2 = {1,2,3,4};
		ListNode head1 = ListNode.linkedListForming(arr);
		ListNode head2 = ListNode.linkedListForming(arr2);
		ListNode.printLL(head1);
		head2.next.next.next.next = head1.next.next.next.next;
		ListNode.printLL(head2);
		System.out.print(getIntersectionNodeBrute(head1,head2).data);
	}
}
