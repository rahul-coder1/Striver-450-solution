package linkedList.medium;

public class DeleteTheMiddleNodeoFALinkedList {
	//TC - o(n+n/2)
    public static ListNode deleteMiddleBrute(ListNode head) {
        
        if(head==null) return head;
        ListNode curr = head;
        int n = 0;
        while(curr!=null){
            n+=1;
            curr = curr.next;
        }
        if(n==1){
            head = head.next;
            return head;
        }
        int res = n/2;
        curr = head;
        while(curr!=null){
            res-=1;
            if(res==0){
                curr.next = curr.next.next;
            }
            curr=curr.next;
        }

        return head;
    }
    
    
  //TC - o(n/2)
    public static ListNode deleteMiddleOptimal(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head, fast = head.next.next; //moving fast 1 step ahead, same as skipping 1 step for slow
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return head;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(deleteMiddleOptimal(head));
	}
}












