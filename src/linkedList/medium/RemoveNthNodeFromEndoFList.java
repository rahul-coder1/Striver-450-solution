package linkedList.medium;

public class RemoveNthNodeFromEndoFList {
	//TC - o(2*len(ll))
    public static ListNode removeNthFromEndBrute(ListNode head, int n) {
        int cnt = 0;
        ListNode curr = head;
        while(curr!=null){
            cnt+=1;
            curr = curr.next;
        }
        if(cnt==n){ // n = len of ll
            return head.next;
        }else if(n>cnt) return head;
        
        int nth = cnt-n;
        curr=head;
        while(curr!=null){
            nth-=1;
            if(nth==0) break;
            curr = curr.next;
        }
        ListNode temp = curr.next;
        curr.next = curr.next.next;
        temp.next=null;

        return head;
    }
    
  //TC - o(len(ll)) depends only of fast pointer start to end movement
    public static ListNode removeNthFromEndOptimal(ListNode head, int n) {
        ListNode curr = head, slow=head, fast=head;
        if(head==null) return head;
        for(int i=0;i<n;i++){
            fast=fast.next;
            if(fast==null) break;
        }
        if(fast==null) return head.next; //edge case

        while(fast.next!=null){
            fast = fast.next; slow=slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,3,4,5}; int n=6;
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(removeNthFromEndOptimal(head, n));
		
	}
}















