import java.util.ArrayList;
import java.util.*;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution21{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root == null) return result;
    	Deque<TreeNode>  queue = new LinkedList<TreeNode>();
    	queue.offerLast(root);
    	while(!queue.isEmpty()) {
    		TreeNode now = queue.pollFirst();
    		result.add(now.val);
    		if(now.left != null) queue.offerLast(now.left);
    		if(now.right != null) queue.offerLast(now.right);
    	}	
    	return result;

    }
}