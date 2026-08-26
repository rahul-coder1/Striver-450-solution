package linkedList.hard;

import linkedList.OneD.LinkedListFunctions.Node;

public class ListNode {
	public int data;
	public ListNode next;
	public ListNode bottom;
	ListNode(int data){
		this.data = data;
	}
	ListNode(int data, ListNode next, ListNode bottom){
		this.data = data;
		this.next = next;
		this.bottom = bottom;
	}
	
	public static ListNode linkedListForming(int[]arr) {
		final int n = arr.length;
		if(arr==null || n==0) {
			System.out.println("Array is empty");
			return null;
		}
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
		if(head==null) {
			System.out.println("head is empty");
			return;
		}
		while(mover!=null) {
			System.out.print(mover.data+" ");
			mover=mover.next;
		}
		System.out.println();
	}
	
	public static void printLLDown(ListNode head) {
		ListNode mover = head;
		if(head==null) {
			System.out.println("head is empty");
			return;
		}
		while(mover!=null) {
			System.out.print(mover.data+" ");
			mover=mover.bottom;
		}
		System.out.println();
	}
}
