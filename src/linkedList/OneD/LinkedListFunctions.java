package linkedList.OneD;


final public class LinkedListFunctions {
	public static class Node{
		public int value;
		public Node next;
		Node(int value, Node node){
			this.value=value;
			this.next = node;
		}
		Node(int value){
			this.value=value;
			this.next = null;
		}
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
	//TC - o(1)
	public static Node insertNodeAtHead(Node head, int val) {
		Node node = new Node(val);
		node.next = head;
		head=node;
		return head;
	}
	
	public static Node insertAtTail(Node head, int value) {
		if(head==null) return head;
		Node mover = head;
		while(mover.next!=null) {
			mover=mover.next;
		}
		Node tail = new Node(value);
		mover.next=tail;
		
		return head;
	}
	public static void printLL(Node head) {
		Node mover = head;
		while(mover!=null) {
			System.out.print(mover.value+" ");
			mover=mover.next;
		}
		System.out.println();
	}
	
	//TC - o(n)
	public static Node deleteTail(Node head) {
		Node temp = head;
		if(head==null || head.next==null) return null;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next=null;
		
		return head;
	}
	
	public static void main(String[] args) {
		int[]arr= {1,10,45,6,17}; int insertAthead=7;
		Node head = linkedListForming(arr);
		printLL(head);
		head = insertNodeAtHead(head,insertAthead); //#1.
		printLL(head);
		deleteTail(head); 	//#2.
		printLL(head);
		insertAtTail(head, 111);
		printLL(head);
	}
}
