import java.util.ArrayList;
class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}
public class Solution3{
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(listNode == null) return result;
		else print(listNode, result);
		return result;
	}
	public void print(ListNode tail, ArrayList<Integer> result) {
		if(tail.next == null) result.add(tail.val);
		else {
			print(tail.next, result);
			result.add(tail.val);
		}
	}

}