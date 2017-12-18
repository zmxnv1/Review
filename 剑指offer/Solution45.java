class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution45 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) return pHead;
        ListNode head = new ListNode(0), t = head;
        ListNode p = pHead, q = pHead.next;
        while(p != null){
            if((q != null && p.val != q.val) || (q == null)) {
                t.next = new ListNode(p.val);
                t = t.next;
                p = p.next;
                if(q != null) q = q.next;
            }
            else {
                while(q != null && q.val == p.val) {
                    q = q.next;
                }
                p = q;
                if(q != null) {
                    q = q.next;
                }
            }
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode pHead = new ListNode(Integer.valueOf(args[0]));
        ListNode p = pHead;
        for(int i = 1; i < args.length; i++){
            String s = args[i];
            p.next = new ListNode(Integer.valueOf(s));
            p = p.next;
        }
        ListNode q = new Solution45().deleteDuplication(pHead);
        while(q != null) {
            System.out.println(q.val);
            q = q.next;
        }

    }
}