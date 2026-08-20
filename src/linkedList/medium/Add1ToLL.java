package linkedList.medium;

public class Add1ToLL {
	public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
	
	//TC - o(3n)
    public static ListNode addOneBrute(ListNode head) {
        if(head==null) return head;
        int carry=1;
        head = reverse(head);
        ListNode curr = head;
        while(curr!=null){
            curr.data = curr.data+carry;
            if(curr.data<10){
                carry=0;
                break;
            }
            else{
                curr.data=0;
                carry=1;
            }
            
            curr = curr.next;
        }
        
        if(carry==1){
            ListNode nhead = new ListNode(1);
            head = reverse(head);
            nhead.next = head;
            return nhead;
        }
        
        head = reverse(head);
        
        return head;
    }
    
    public static int helper(ListNode temp) {
    	if(temp==null) return 1;
    	int carry = helper(temp.next);
    	temp.data = temp.data+carry;
    	if(temp.data<10) {
    		return 0;
    	}
    	temp .data = 0;
    	return 1;
    }
    
    //TC - o(n), SC - o(n) - recursive stack space
    public static ListNode addOneoptimal(ListNode head) {
    	if(head==null) return head;
    	int carry = helper(head);
    	if(carry==1) {
    		ListNode nhead = new ListNode(1);
    		nhead.next = head;
    		return nhead;
    	}
    	
    	return head;
    }
    
    public static void main(String[] args) {
		int[] arr = {9,9,9};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(addOneoptimal(head));
	}
}
