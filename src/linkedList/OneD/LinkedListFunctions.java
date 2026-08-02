package linkedList.OneD;


public final class LinkedListFunctions {
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
		
		if(head==null) return new Node(val);
		
		Node node = new Node(val);
		node.next = head;
		head=node;
		
		return head;
	}
	
	//TC - o(n)
	public static Node insertAtTail(Node head, int value) {
		if(head==null) return new Node(value);
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
	
	public static Node insertAtKthPlace(Node head, int value, int k) {
		if(head==null) return new Node(value);
		Node kthNode = new Node(value);
		Node mover = head;
		
		if(k==1) {
			kthNode.next=head;
			head = kthNode;
			return head;
		}
		else {
			int count=0;
			Node prev=head;
			while(prev!=null) {
				count+=1;
				if(count==k-1) {
					kthNode.next = prev.next;
					prev.next = kthNode;
					break;
				}
				prev = prev.next;
			}
		}
		
		return head;
	}
	
	public static Node insertBeforeValue(Node head, int ele, int value) {
		if(head==null) return null;
		else if(head.value == ele) {
			head = new Node(value,head);
			return head;
		}
		else {
			Node prev = head;
			while(prev.next!=null) {
				if(prev.next.value==ele) {
					Node insert = new Node(value,prev.next);
					prev.next=insert;
					break;
				}
				prev = prev.next;
			}
		}
		
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
//		Node head = null;
//		printLL(insertAtTail(head, 111)); //#3.
//		printLL(insertAtKthPlace(head, -10, 8)); //#4.
		printLL(insertBeforeValue(head, 11, -99)); //#5.
	}
}
