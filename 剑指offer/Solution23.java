import java.util.ArrayList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution23 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	if(root == null) return new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();		        
		ArrayList<Integer> list = new ArrayList<Integer>();
		searchPath(root, 0, target, list, result);
		return result;
    }
    public void searchPath(TreeNode root, int sum, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
    	if(root == null) return;
    	if(root.left == null && root.right == null) {
    		if(root.val + sum == target) {
    			ArrayList<Integer> r = new ArrayList<Integer>();
    			for(Integer n : list) {
    				r.add(n);
    			}
    			r.add(root.val);
    			result.add(r);
    		}
    		else return;
    	}
    	if(root.left != null) {
    		int length = list.size();
    		list.add(root.val);
    		searchPath(root.left, sum + root.val, target, list, result);
    		list.remove(length);
    	}
    	if(root.right != null) {
    		int length = list.size();
    		list.add(root.val);
    		searchPath(root.right, sum + root.val, target, list, result);
    		list.remove(length);
    	}
    }

}