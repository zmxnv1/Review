class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution15{
    public ListNode Merge(ListNode list1,ListNode list2) {
    	if(list1 == null) return list2;
    	if(list2 == null) return list1;
    	ListNode head1 = list1, head2 = list2;
    	ListNode result, r;
    	if(head1.val < head2.val){
 			result = new ListNode(head1.val);
 			head1 = head1.next;
    	}
    	else{
    		result = new ListNode(head2.val);
    		head2 = head2.next;
    	}
    	r = result;
    	while(head2 != null && head1 != null) {
    		if(head1.val < head2.val){
 				result.next = new ListNode(head1.val);
 				head1 = head1.next;
    		}
    		else{
    			result.next = new ListNode(head2.val);
    			head2 = head2.next;
    		}	
    		result = result.next;
    	}
    	if(head1 != null) {
    		result.next = head1;
    	}
    	if(head2 != null) {
    		result.next = head2;
    	}
    	return r;

    }
}