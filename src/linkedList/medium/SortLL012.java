package linkedList.medium;

public class SortLL012 {
	//TC - o(2n)
	public static ListNode segregateBrute(ListNode head) {
        if(head==null || head.next==null) return head;
       int cnt0=0,cnt1=0,cnt2=2;
       ListNode curr = head;
       while(curr!=null){
           if(curr.data==0) cnt0+=1;
           else if(curr.data==1)cnt1+=1;
           else if(curr.data==2)cnt2+=1;
           
           curr = curr.next;
       }
       
       curr = head;
       while(curr!=null){
           if(cnt0>0){
               curr.data = 0; cnt0-=1;
           }
           else if(cnt1>0){
               curr.data = 1; cnt1-=1;
           }
           else if(cnt2>0){
               curr.data = 2;cnt2-=1;
           }
           
           curr = curr.next;
       }
        
        return head;
    }
	
	//TC - o(n)
	public static ListNode segregateOptimal(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode zeroHead = new ListNode(-1);
		ListNode oneHead = new ListNode(-1);
		ListNode twoHead = new ListNode(-1);
		ListNode zero = zeroHead, one = oneHead, two = twoHead;
		ListNode curr = head;
        while(curr!=null){
            if(curr.data==0){
                zero.next = curr;
                zero = curr;
            }
            else if(curr.data==1){
                one.next = curr;
                one = curr;
            }
            else{
                two.next = curr;
                two = curr;
            }
            
            curr = curr.next;
        }
        
        zero.next = oneHead.next!=null?oneHead.next:twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        
        return zeroHead.next;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,2,1,1,0,1,0,0};
		ListNode head = ListNode.linkedListForming(arr);
		ListNode.printLL(head);
		ListNode.printLL(segregateOptimal(head));
	}
}
