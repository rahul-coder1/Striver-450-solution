package linkedList.hard;

public class ReverseNodesInkGroup {
	//TC - o(2n), SC - o(1)
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, nextNode=null, prevNode=null;
        while(curr!=null){
            ListNode kthNode = getKthNode(curr,k);
            if(kthNode==null){
                if(prevNode!=null) prevNode.next = curr;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(curr);
            if(curr==head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }

            prevNode = curr;
            curr = nextNode;
        }

        return head;
    }

    public static ListNode reverseLL(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode curr = head, prev = null;
        while(curr!=null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
    public static ListNode getKthNode(ListNode node, int k){
        k-=1; ListNode curr = node;
        while(curr!=null && k>0){
            k-=1;
            curr = curr.next;
        }

        return curr;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5}; int k=2;
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(reverseKGroup(head,k));
	}
}


















