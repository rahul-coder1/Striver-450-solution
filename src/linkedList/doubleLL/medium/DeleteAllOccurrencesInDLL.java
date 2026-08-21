package linkedList.doubleLL.medium;

public class DeleteAllOccurrencesInDLL {
	//TC - o(n)
    static ListNode deleteAllOccurOfX(ListNode head, int x) {
        if(head==null) return head;
        ListNode temp = head;
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head = head.next;
                }
                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;
                if(nextNode!=null) nextNode.prev = prevNode;
                if(prevNode!=null) prevNode.next = nextNode;
                
                temp = temp.next;
            }
            else
                temp = temp.next;
        }
        
        return head;
    }
    
	public static void main(String[] args) {
		int[] arr = {10,20,10,40,50,60,10};
		ListNode head = ListNode.convertArrToDLL(arr);
		ListNode.printDLL(head); 
		ListNode.printDLL(deleteAllOccurOfX(head, 10));
	}
}
