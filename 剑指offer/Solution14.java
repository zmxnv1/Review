public class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}
public class Solution14{
	public ListNode FindKthToTail(ListNode head, int k) {
		if(head == null) return null;
		ListNode node1 = head, node2 = head;
		while(k > 0) {
			if(node1 == null) return null;  //鲁棒性
			node1 = node1.next;
			k--;
		}
		while(node1 != null) {
			node2 = node2.next;
			node1 = node1.next;
		}
		return node2;
	}
}