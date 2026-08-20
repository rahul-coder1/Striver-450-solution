package linkedList.medium;

public class AddTwoNumbersLL {
	//TC - o(max(n1.n2)), SC -o(max(n1,n2))
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode t1=l1, t2=l2;
    	ListNode dNode = new ListNode(-1), curr = dNode;
    	int carry=0;
    	while(t1!=null || t2!=null) {
    		int sum=carry;
    		if(t1!=null) sum+=t1.data;
    		if(t2!=null) sum+=t2.data;
    		ListNode newNode = new ListNode(sum%10);
    		carry = sum/10;
    		
    		curr.next = newNode;
    		curr = curr.next;
    		
    		if(t1!=null) t1=t1.next;
    		if(t2!=null) t2=t2.next;
    	}
    	if(carry!=0) {
    		ListNode d = new ListNode(carry);
    		curr.next = d;
    	}
    	
    	return dNode.next;
    }
    
    public static void main(String[] args) {
		int[] arr1 = {9,9,9};
		int[] arr2 = {9,9,9};
		ListNode head1 = ListNode.linkedListForming(arr1);
		ListNode head2 = ListNode.linkedListForming(arr2);
		ListNode.printLL(head1);
		ListNode.printLL(head2);
		ListNode.printLL(addTwoNumbers(head1,head2));
	}
}









