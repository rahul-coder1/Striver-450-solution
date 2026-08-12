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
    
  //TC - o(logn*(n - merge operation + n/2 - middle find)) ~ nlogn, SC - o(logn) - recursive stack space
    public static ListNode sortListOptimal(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode middle = middle(head);
        ListNode leftHead = head, rightHead = middle.next;
        middle.next = null;

        leftHead = sortListOptimal(leftHead);
        rightHead = sortListOptimal(rightHead);

        return merge(leftHead, rightHead);
    }
    public static ListNode merge(ListNode left, ListNode right){
        ListNode dNode = new ListNode(-1);
        ListNode curr = dNode;
        while(left!=null && right!=null){
            if(left.data < right.data){
                curr.next = left;
                curr = left;
                left = left.next;
            }else{
                curr.next = right;
                curr = right;
                right = right.next;
            }
        } 
        if(left!=null) curr.next = left;
        else curr.next = right;

        return dNode.next;
    }
    public static ListNode middle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next; fast = fast.next.next;
        }

        return slow;
    }
	
	
    public static void main(String[] args) {
    	int[] arr = {3,2,1,0,-1};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(sortListOptimal(head));
	}
}








