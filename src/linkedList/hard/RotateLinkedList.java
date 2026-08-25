package linkedList.hard;

public class RotateLinkedList {
	//TC - o(2n)
    public static ListNode rotateRight(ListNode head, int k) {
        int len=1; ListNode tail  = head;
        if(head==null || head.next==null) return head;
        while(tail.next!=null){
            len+=1;
            tail=tail.next;
        }

        k=k%len;
        if(k==0) return head;

        tail.next = head;
        ListNode lastNode = findLast(head,len-k);
        
        head = lastNode.next;
        lastNode.next = null;

        return head;
    }

    public static ListNode findLast(ListNode head, int k){
        ListNode lastNode = head;
        int cnt=1;
        while(lastNode!=null){
            if(cnt==k) return lastNode;
            lastNode = lastNode.next;
            cnt+=1;
        }

        return lastNode;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5}; 
    	int k=3;
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(rotateRight(head,k));
	}
}
