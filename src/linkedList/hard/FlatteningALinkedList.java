package linkedList.hard;
import java.util.*;

public class FlatteningALinkedList {
	//TC - o(n+nlogn), SC - o(n)
    public static ListNode flattenBrute(ListNode head) {
        if(head==null) return head;
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            ListNode t2 = temp;
            while(t2!=null){
                arr.add(t2.data);
                t2 = t2.bottom;
            }
            temp = temp.next;
        }
        
        arr.sort(Comparator.naturalOrder());
        ListNode newHead = convert(arr);
        
        return newHead;
    }
    
    public static ListNode convert(List<Integer> arr){
        ListNode head = new ListNode(arr.get(0));
        ListNode temp=head;
        for(int i=1;i<arr.size();i++){
            ListNode child = new ListNode(arr.get(i));
            temp.bottom = child;
            temp=child;
        }
        
        return head;
    }
    
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
		
		ListNode.printLLDown(flattenBrute(head));
	}
}
