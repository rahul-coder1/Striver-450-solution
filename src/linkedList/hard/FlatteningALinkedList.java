package linkedList.hard;
import java.util.*;

public class FlatteningALinkedList {
	//TC - o(2*n*m+ XlogX), SC - o(2*n*m) - for array and new linked-list
    public static ListNode flattenBrute(ListNode head) {
        if(head==null) return head;
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){ //n*m
            ListNode t2 = temp;
            while(t2!=null){
                arr.add(t2.data);
                t2 = t2.bottom;
            }
            temp = temp.next;
        }
        
        arr.sort(Comparator.naturalOrder()); //XlogX, X = n*m
        ListNode newHead = convert(arr);
        
        return newHead;
    }
    
    public static ListNode convert(List<Integer> arr){
        ListNode head = new ListNode(arr.get(0));
        ListNode temp=head;
        for(int i=1;i<arr.size();i++){ //n*m
            ListNode child = new ListNode(arr.get(i));
            temp.bottom = child;
            temp=child;
        }
        
        return head;
    }
    
    //===========================================
  //TC - o(n*2*m) ~ o(2nm), SC - o(n)
    public static ListNode flattenOptimal(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode mergeHead = flattenOptimal(head.next);
        head = merge(head,mergeHead);
        
        return head;
    }
    
    public static ListNode merge(ListNode t1, ListNode t2){
        ListNode dNode = new ListNode(-1);
        ListNode curr = dNode;
        while(t1!=null && t2!=null){
            if(t1.data<=t2.data){
                curr.bottom = t1;
                t1 = t1.bottom;
            }else{
                curr.bottom = t2;
                t2 = t2.bottom;
            }
            curr = curr.bottom;
            curr.next = null;
        }
        
        if(t1!=null) curr.bottom = t1;
        else curr.bottom = t2;
        while (curr.bottom != null) {
            curr = curr.bottom;
            curr.next = null;
        }
        return dNode.bottom;
    }
    
    //=======================================================================
    
    public static ListNode addBottom(ListNode head) {
    	ListNode temp = head;
    	temp.bottom = new ListNode(5);
    	temp.next.bottom = new ListNode(6);
    	temp.next.next.bottom = new ListNode(7);
    	temp.next.next.next.bottom = new ListNode(8);
    	
    	return head;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4}; 
    	
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		head = addBottom(head);
		
		ListNode.printLLDown(flattenOptimal(head));
	}
}
