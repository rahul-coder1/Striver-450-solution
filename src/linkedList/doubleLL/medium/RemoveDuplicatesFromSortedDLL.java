package linkedList.doubleLL.medium;

public class RemoveDuplicatesFromSortedDLL {
    //TC - o(n)
    static ListNode removeDuplicates(ListNode headRef) {
        ListNode temp = headRef;
        while(temp!=null && temp.next!=null){
            ListNode nextNode = temp.next;
            while(nextNode!=null && nextNode.data==temp.data){
                nextNode = nextNode.next;
            }
            
            temp.next = nextNode;
            if(nextNode!=null) nextNode.prev = temp;
            
            temp = nextNode; // or temp = temp.next
        }
        
        return headRef;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,1,2,2,2,3,3,4,4,5};
		ListNode head = ListNode.convertArrToDLL(arr);
		ListNode.printDLL(head); 
		ListNode.printDLL(removeDuplicates(head)); 
	}

}
