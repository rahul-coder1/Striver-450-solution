package linkedList.medium;

import linkedList.OneD.LinkedListFunctions;
import linkedList.OneD.LinkedListFunctions.Node;

public class MiddleOfTheLinkedList {
	//TC - o(n+n/2)
    public static final Node middleNodeTwoPass(Node head) {
        int n=0;
        if(head==null || head.next==null) return head;
        Node curr = head;
        while(curr!=null){
            n+=1;
            curr = curr.next;
        }
        n=n/2; curr = head;
        while(n>0){
            curr = curr.next;
            n-=1;
        }

        return curr;
    }
    
    public static final Node middleNodeFastPointer(Node head) {
    	Node slow = head;
    	Node fast = head;
    	if(head==null || head.next==null) return head;
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }
    
    public static void main(String[] args) {
//    	int[]arr= {1,10,45,6,17};
//    	int[]arr= {1,10,45,6,17,18};
    	int[]arr= {1,10,45,6};
    	Node head = LinkedListFunctions.linkedListForming(arr);
    	LinkedListFunctions.printLL(head);
    	Node middle = middleNodeFastPointer(head);
    	LinkedListFunctions.printLL(middle);
	}
}
