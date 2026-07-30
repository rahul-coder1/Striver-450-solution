package linkedList.doubleLL;

import java.util.logging.Logger;

public class DoublyLLFunctions {
	private static final Logger log = Logger.getLogger(DoublyLLFunctions.class.getName());
	private static class Node{
		int data;
		Node next;
		Node prev;
		Node(int data){
			this.data=data;
			this.next = null;
			this.prev = null;
		}
		Node(int data, Node next, Node prev){
			this.data=data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public static Node convertArrToDLL(int[]arr) {
		if(arr==null || arr.length==0) return null;
		
		Node head = new Node(arr[0]);
		Node current = head;
		for(int i=1;i<arr.length;i++) {
			Node temp = new Node(arr[i]);
			current.next = temp;
			temp.prev = current;
			current = temp;
		}
		
		return head;
	}
	
	public static Node deleteHead(Node head) {
		if(head==null) return head;
		Node prev = head;
		head = head.next;
		head.prev = null;
		prev.next = null;
		
		return head;
	}
	
	public static Node deleteTail(Node head) {
		if(head==null || head.next==null) return null;
		Node tail = head;
		while(tail.next!=null) {
			tail = tail.next;
		}
		Node prev = tail.prev;
		tail.prev = null;
		prev.next = null;
		
		return head;
	}
	
	public static void printDLL(Node head) {
		if(head==null) log.info("head is empty");
		Node current = head;
		while(current!=null) {
			if(current.next==null)
				System.out.print(current.data);
			else System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60};
		Node head = convertArrToDLL(arr);
		printDLL(head); //#1
//		printDLL(deleteHead(head)); //#2
		printDLL(deleteTail(head)); //#3
	}
}















