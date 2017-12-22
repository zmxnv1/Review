import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution51{
    TreeNode KthNode(TreeNode pRoot, int k){
        if(k < 1) return null;
        ArrayList<TreeNode> lists =  new ArrayList<>();
        KthNode(pRoot, lists);
        if(k > lists.size()) return null;
        return lists.get(k - 1);
    }
    public void KthNode(TreeNode pRoot, ArrayList<TreeNode> lists) {
        if(pRoot == null) return;
        KthNode(pRoot.left, lists);
        lists.add(pRoot);
        KthNode(pRoot.right, lists);
    }

}