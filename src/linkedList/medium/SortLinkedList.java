package linkedList.medium;

import java.util.*;

public class SortLinkedList {
	
	  //TC - o(n+logn+n), SC - o(n)
    public static ListNode sortListBrute(ListNode head) {
    	List<Integer> arr = new ArrayList<>();
    	if(head==null || head.next==null) return head;
    	ListNode curr = head;
    	while(curr!=null) {
    		arr.add(curr.data);
    		curr = curr.next;
    	}
    	Collections.sort(arr);
    	int i=0; curr = head;
    	while(curr!=null) {
    		curr.data = arr.get(i);
    		i+=1;
    		curr = curr.next;
    	}
    	
    	return head;
    }
	
	
    public static void main(String[] args) {
    	int[] arr = {3,2,1,0};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(sortListBrute(head));
	}
}








