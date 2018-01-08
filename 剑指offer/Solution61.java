class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution61{
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        TreeNode p = null, q = null;
        if(pRootOfTree.left != null) {
            p = Convert(pRootOfTree.left);
            TreeNode pTemp = p;
            while(pTemp.right != null) {
                pTemp = pTemp.right;
            }
            pRootOfTree.left = pTemp;
            pTemp.right = pRootOfTree;
        }
        if(pRootOfTree.right != null) {
            q = Convert(pRootOfTree.right);
            pRootOfTree.right = q;
            pRootOfTree.right.left = pRootOfTree;
        }
        return p == null ? pRootOfTree : p;
    }

}