package linkedList.medium;

public class MergeTwoSortedLL {
// brute force will be take an array, put values inside of it, sort array and convert array into LL
	//TC - o(n1+n2), SC - o(1)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;
        ListNode dNode = new ListNode(-1);
        ListNode curr = dNode;
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                curr.next = t1;
                curr = t1;
                t1 = t1.next;
            }else{
                curr.next = t2;
                curr = t2;
                t2 = t2.next;
            }
        } 

        if(t1!=null) curr.next = t1;
        else curr.next = t2;

        return dNode.next;
    }
    
    public static void main(String[] args) {
    	int[] arr1 = {1,3,5,7,9,11};
    	int[] arr2 = {2,4,6,8,10};
		ListNode head1 = ListNode.linkedListForming(arr1);
		ListNode head2 = ListNode.linkedListForming(arr2);
		ListNode.printLL(head1);
		ListNode.printLL(head2);
		ListNode.printLL(mergeTwoLists(head1, head2));
	}
}
