package linkedList.doubleLL.medium;

import java.util.*;

public class PairSumInSortedDoublyLinkedList {
	//TC - o(n^2)
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
	
	public static ListNode findTail(ListNode head){
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        
        return temp;
    }
	
	//TC - o(2n)
	public static List<List<Integer>> givenSumPairsOptimal(ListNode head, int target) {
		List<List<Integer>> arr = new ArrayList<>();
        ListNode left = head;
        ListNode right = findTail(head);
        while(left.data<right.data){
            if(left.data+right.data==target){
                arr.add(new ArrayList<>(List.of(left.data,right.data)));
                left = left.next;
                right = right.prev;
            }
            else if(left.data+right.data<target){
                left = left.next;
            }else{
                right = right.prev;
            }
        }
        
        return arr;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,8,9};
		ListNode head = ListNode.convertArrToDLL(arr);
		ListNode.printDLL(head); 
		List<List<Integer>> a = givenSumPairsOptimal(head, 10);
		for(List<Integer> i : a) {
			System.out.println(i);
		}
	
	}
}
