package linkedList.medium;

public class Node {
	public int data;
	public Node next;
	Node(int data){
		this.data = data;
	}
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	
	public static Node linkedListForming(int[]arr) {
		final int n = arr.length;
		Node head = new Node(arr[0]);
		Node mover = head;
		for(int i=1;i<n;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover=temp;
		}
		
		return head;
	}
}
