class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution47{
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null) return null;
        if(pNode.right != null) {
            TreeLinkNode p = pNode.right;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }
        else {
            TreeLinkNode p = pNode.next;
            while(p != null &&  p.val < pNode.val){
                p = p.next;
            }
            return p;
        }
    }
}