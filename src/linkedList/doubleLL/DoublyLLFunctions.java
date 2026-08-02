package linkedList.doubleLL;

import java.util.logging.Logger;

public class DoublyLLFunctions {
	private static final Logger log = Logger.getLogger(DoublyLLFunctions.class.getName());
	
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
	
	public static Node removeKthElement(Node head, int k) {
		if(head==null) return head;
		Node current = head;
		int count=0;
		while(current!=null) {
			count+=1;
			if(count==k) break;
			current = current.next;
		}
		
		if(current==null) return head; //if current goes out of bound i.e k>len(DLL)
		
		Node back = current.prev; Node front = current.next;
		if(back==null && front ==null) {
			head = null;
		}
		else if(back==null) {
			Node prev = head;
			head = head.next;
			prev.next = null;
			head.prev = null;
		}
		else if(front==null) {
			current.prev=null;
			back.next = null;
		}
		else {
			current.next = null; current.prev = null;
			back.next = front;
			front.prev = back;
		}
		
		return head;
	}
	
	public static void deleteNode(Node givenNode) { //constraint is givenNode cannot be head
		if(givenNode==null) return;
		Node back = givenNode.prev; Node front = givenNode.next;
		if(front == null) {
			back.next = null;
			givenNode.prev = null;	
		}else {
			back.next = front;
			front.prev = back;
			givenNode.next = null;
			givenNode.prev = null;
		}
	}
	
	public static Node insertBeforeHead(Node head, int value) {
		if(head==null) return head;
		
		Node newHead = new Node(value,head,null);
		head.prev = newHead;
		head = newHead;
		
		return head;
	}
	
	public static Node insertBeforeTail(Node head, int value) {
		if(head==null) return head;
		Node current = head;
		while(current.next!=null) current = current.next;
		Node back = current.prev;
		if(back!=null) {
			Node temp = new Node(value,current,back);
			current.prev = temp;
			back.next = temp;
		}else {
			head = insertBeforeHead(head, value);
		}
		
		return head;
	}
	
	public static Node insertBeforeKthElement(Node head, int value, int k) { // 1<=k<=N (N= len of DLL)
		if(head==null) {
			return new Node(value);
		}else if(k==1) {
			head = insertBeforeHead(head, value);
		}
		else {
			Node temp = head;
			int cnt=0;
			while(temp!=null) {
				cnt+=1;
				if(cnt==k) break;
				temp=temp.next;
			}
			if(temp==null) return head; //k> length of given DLL
			
			Node back = temp.prev;
			Node kthNode = new Node(value,temp,back);
			back.next = kthNode;
			temp.prev = kthNode;
		}
		
		return head;
	}
	
	public static void insertBeforeNode(Node node, int val) { // 2 nodes min given and node is at min tail
		if(node==null) return;
		Node back = node.prev;
		Node temp = new Node(val,node,back);
		back.next = temp;
		node.prev = temp;
		
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
		int[] arr = {10,20,30,40};
		Node head = convertArrToDLL(arr);
		printDLL(head); //#1
//		printDLL(deleteHead(head)); //#2
//		printDLL(deleteTail(head)); //#3
//		printDLL(removeKthElement(head,7)); //#4
//		deleteNode(head.next.next.next.next.next); //#5
//		printDLL(head);
//		printDLL(insertBeforeHead(head, -11)); //#6

//		printDLL(insertBeforeTail(head.next.next, 99)); //#6
//		printDLL(insertBeforeKthElement(head, 99,5)); //#6
		insertBeforeNode(head.next.next.next,99); //#6
		printDLL(head);
	}
}















