package linkedList.doubleLL.medium;

public class ListNode {

	int data;
	ListNode next;
	ListNode prev;
	ListNode(int data){
		this.data=data;
		this.next = null;
		this.prev = null;
	}
	ListNode(int data, ListNode next, ListNode prev){
		this.data=data;
		this.next = next;
		this.prev = prev;
	}

	public static ListNode convertArrToDLL(int[]arr) {
		if(arr==null || arr.length==0) return null;
		
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for(int i=1;i<arr.length;i++) {
			ListNode temp = new ListNode(arr[i]);
			current.next = temp;
			temp.prev = current;
			current = temp;
		}
		
		return head;
	}
	
	public static void printDLL(ListNode head) {
		if(head==null) System.out.println("head is empty");
		ListNode current = head;
		while(current!=null) {
			if(current.next==null)
				System.out.print(current.data);
			else System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
}
