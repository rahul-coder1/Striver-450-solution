package linkedList.hard;
import java.util.*;

public class CopyListWithRandomPointer {
	//TC - o(n+n), SC - o(n) + o(n)=for answer LL
    public static ListNode copyRandomListBrute(ListNode head) {
        if(head==null) return head;
        ListNode temp = head;
        Map<ListNode,ListNode> mp = new HashMap<>();
        while(temp!=null){
            ListNode node= new ListNode(temp.data);
            mp.put(temp,node);
            temp = temp.next;
        }
        temp=head;
        while(temp!=null){
            ListNode copyNode = mp.get(temp);
            copyNode.next = mp.get(temp.next);
            copyNode.random = mp.get(temp.random);
            temp = temp.next;
        }

        return mp.get(head);
    }
    
//    ===================================================================================================
    public static ListNode copyRandomListOptimal(ListNode head) {
    	if(head==null) return head;

    	insertCopyNodeInBetween(head);
    	connectRandomPointers(head);

    	return copyLLHead(head);
    }
    /**
    *function to connect next pointers
    */
    public static ListNode copyLLHead(ListNode head){
    	ListNode curr = head;
    	ListNode dNode = new ListNode(-1); 
    	ListNode res = dNode;
    	while(curr!=null){
    		res.next = curr.next;
    		curr.next = curr.next.next;
    		res = res.next;
    		curr = curr.next;
    	}

    	return dNode.next;
    }
    public static void connectRandomPointers(ListNode head){
    	ListNode curr = head;
    	while(curr!=null){
    		ListNode copyNode = curr.next;
    		if(curr.random!=null)
    			copyNode.random = curr.random.next;
    		else copyNode.random = null;

    		curr = curr.next.next;
    	}
    }
    public static void insertCopyNodeInBetween(ListNode head){
    	ListNode curr = head;
    	while(curr!=null){
    		ListNode ListNode = new ListNode(curr.data);
    		ListNode.next = curr.next;
    		curr.next = ListNode;
    		curr = ListNode.next;
    	}
    }
    
    public static void printListWithRandom(ListNode head) {

        ListNode temp = head;

        while (temp != null) {

            System.out.print(
                "Node: " + temp.data +
                " | Random: " +
                (temp.random != null ? temp.random.data : "null")
            );

            System.out.println();

            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
    	// Create normal linked list
        int[] arr = {7, 13, 11, 10, 1};

        ListNode head = ListNode.linkedListForming(arr);

        // Get references to individual nodes
        ListNode node1 = head;           // 7
        ListNode node2 = node1.next;     // 13
        ListNode node3 = node2.next;     // 11
        ListNode node4 = node3.next;     // 10
        ListNode node5 = node4.next;     // 1

        /*
         * Assign random pointers
         *
         * 7  -> null
         * 13 -> 7
         * 11 -> 1
         * 10 -> 11
         * 1  -> 7
         */

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        System.out.println("Original List:");
        printListWithRandom(head);

        ListNode copiedHead = copyRandomListOptimal(head);

        System.out.println("\nCopied List:");
        printListWithRandom(copiedHead);
	}
    
    
}
