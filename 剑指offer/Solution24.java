class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}
public class Solution24{
	public ListNode ReverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p = head, q = head.next, temp;
		head.next = null;
		while(q != null) {
			temp = q.next;
			q.next = p;
			p = q;
			q = temp;
		}
		return p;
	}
}