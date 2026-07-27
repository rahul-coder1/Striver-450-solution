package linkedList.OneD;

import linkedList.OneD.LinkedListFunctions;
import linkedList.OneD.LinkedListFunctions.Node;

public class DeleteNodeInALinkedList {
	
	public static class ListNode {
		  int val;
		  ListNode next;
		  ListNode(int x) { val = x; }
		  ListNode(int x, ListNode node){val=x;next=node;}
	}
	 //TC - o(1)
    public static void deleteNode(ListNode node) { // suppose node.val=3, 1-2-3-4 => 1-3-3-4=> 1-3-4
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
	public static ListNode linkedListForming(int[]arr) {
		final int n = arr.length;
		ListNode head = new ListNode(arr[0]);
		ListNode mover = head;
		for(int i=1;i<n;i++) {
			ListNode temp=new ListNode(arr[i]);
			mover.next=temp;
			mover=temp;
		}
		
		return head;
	}
	public static void printLL(ListNode head) {
		ListNode mover = head;
		while(mover!=null) {
			System.out.print(mover.val+" ");
			mover=mover.next;
		}
		System.out.println();
	}
    public static ListNode deleteKthNode(ListNode head, int k) {
    	int len=0;
    	ListNode mover = head;
    	while(mover!=null) {
    		len+=1;
    		mover=mover.next;
    	}
    	if(k>len) return null;
    	ListNode kthNodePrev=null;
    	ListNode kthNode=null;
    	if(k==1) {
    		head=head.next;
    		return head;
    	}
    	else {
	    	mover=head;
	    	while(k>1) {
	    		kthNodePrev=mover;
	    		kthNode=mover.next;
	    		mover=mover.next;
	    		k-=1;
	    	}
	    	kthNodePrev.next = kthNode.next;
    	}
    	
    	return head;
    }
    
    public static void main(String[] args) {
    	ListNode head = DeleteNodeInALinkedList.linkedListForming(new int[] {1,4,6,7,9,10});
    	//deleteNode(head.next.next); //#1.
    	printLL(head);
    	printLL(deleteKthNode(head, 5));
    	
	}
}
