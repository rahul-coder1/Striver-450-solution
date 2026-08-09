package linkedList.medium;

public class DeleteTheMiddleNodeoFALinkedList {
	//TC - o(n+n/2)
    public static ListNode deleteMiddle(ListNode head) {
        
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
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(deleteMiddle(head));
	}
}
