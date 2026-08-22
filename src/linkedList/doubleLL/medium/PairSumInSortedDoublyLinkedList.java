package linkedList.doubleLL.medium;

import java.util.*;

public class PairSumInSortedDoublyLinkedList {
	public static List<List<Integer>> givenSumPairsBrute(ListNode head, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        ListNode temp1 = head;
        while(temp1!=null){
            ListNode temp2 = temp1.next;
            while(temp2!=null && temp1.data+temp2.data<=target){
                if(temp1.data+temp2.data==target){
                    arr.add(new ArrayList<>(List.of(temp1.data,temp2.data)));
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        
        return arr;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,8,9};
		ListNode head = ListNode.convertArrToDLL(arr);
		ListNode.printDLL(head); 
		List<List<Integer>> a = givenSumPairsBrute(head, 10);
		for(List<Integer> i : a) {
			System.out.println(i);
		}
	
	}
}
