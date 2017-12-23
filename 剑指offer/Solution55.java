import java.util.*;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution55{
    TreeNode clone(TreeNode pRoot) {
        if(pRoot == null) return null;
        TreeNode p = new TreeNode(pRoot.val);
        p.left = clone(pRoot.right);
        p.right = clone(pRoot.left);
        return p;
    }
    boolean equal(TreeNode pRoot, TreeNode q) {
        if(pRoot == null && q == null) return true;
        if(pRoot != null && q != null && pRoot.val == q.val) {
            return (equal(pRoot.left, q.left) && equal(pRoot.right, q.right));
        }
        return false;
    }


    boolean isSymmetrical(TreeNode pRoot){
        return equal(pRoot, clone(pRoot));
    }
}