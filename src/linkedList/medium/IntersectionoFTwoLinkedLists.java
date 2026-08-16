package linkedList.medium;

import java.util.*;

public class IntersectionoFTwoLinkedLists {
	//TC - o(n1*logn1+n2*logn2), SC - o(n1+n2)
    public static ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> mp = new LinkedHashMap<>();
        if(headA==null || headB==null) return null;
        ListNode curr = headA;
        while(curr!=null){
            mp.put(curr, mp.getOrDefault(curr,0)+1);
            curr = curr.next;
        }
        curr = headB;
        while(curr!=null){
            mp.put(curr, mp.getOrDefault(curr,0)+1);
            if(mp.get(curr)>1) return curr;
            curr = curr.next;
        }

        return null;
    }
    
    //TC - o(n1+n2+n2-n1+n1) ~ o(n1+2n2), SC - o(1)
    public static ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
    	int n1=0,n2=0;
    	ListNode curr = headA;
    	while(curr!=null) {
    		n1+=1;
    		curr = curr.next;
    	}
    	
    	curr = headB;
    	while(curr!=null) {
    		n2+=1;
    		curr = curr.next;
    	}
    	
    	if(n1<n2) return collisionNode(headA,headB,n2-n1);
    	else return collisionNode(headB,headA,n1-n2);
    }
    
    public static ListNode collisionNode(ListNode a, ListNode b, int d) {
    	while(d!=0) {
    		d-=1;
    		b=b.next;
    	}
    	while(a!=b) {
    		a=a.next;b=b.next;
    	}
    	
    	return a;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		int[] arr2 = {1,2,3,4};
		ListNode head1 = ListNode.linkedListForming(arr);
		ListNode head2 = ListNode.linkedListForming(arr2);
		ListNode.printLL(head1);
		head2.next.next.next.next = head1.next.next.next.next;
		ListNode.printLL(head2);
		System.out.print(getIntersectionNodeBetter(head1,head2).data);
	}
}
