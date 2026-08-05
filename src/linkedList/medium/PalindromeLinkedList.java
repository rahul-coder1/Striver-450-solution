package linkedList.medium;
import java.util.*;

public class PalindromeLinkedList {
	//TC - o(2n), SC - o(n)
    public static boolean isPalindromeBrute(ListNode head) {
    	ListNode curr = head;
    	Stack<Integer> st = new Stack<>();
    	while(curr!=null) {
    		st.push(curr.data);
    		curr = curr.next;
    	}
    	curr=head;
    	while(curr!=null) {
    		if(curr.data!=st.peek()) return false;
    		st.pop();
    		curr = curr.next;
    	}
    	
    	return true;
    }
    
  //TC - o(2n)
    public static boolean isPalindromeOptimal(ListNode head) { //1.Find middle, 2. reverse half, 3. comparing
        if(head==null || head.next==null) return true;
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){ // o(n/2)
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow is at middle for odd and m1 for even length
        ListNode newHead = reverse(slow.next); // o(n/2)
        ListNode first = head, second = newHead;
        while(second!=null){ // o(n/2)
            if(first.data!=second.data){
                reverse(newHead);  // o(n/2)
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverse(newHead); // o(n/2)
        
        return true;
    }

    public static ListNode reverse(ListNode head){ // o(n/2)
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode front = curr.next; // front -> head->
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }
	public static void main(String[] args) {
		int[] arr = {1,2,2,1};
//		int[] arr = {1,2,24};
		ListNode head = ListNode.linkedListForming(arr);
		System.out.println(isPalindromeOptimal(head));
	}
}
