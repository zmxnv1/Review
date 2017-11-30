class TreeNode {
   int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	return makeTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
    public TreeNode makeTree(int[] pre, int[] in, int pres, int pred, int ins, int ine) {
    	if(ins > ine) return null;   //import
    	TreeNode result = new TreeNode(pre[pres]);
    	if(pred == pres) return result;
    	int index = 0;
    	for(int i = ins; i <= ine; i++) {
    		if(in[i] == pre[pres]) {
    			index = i;
    			break;
    		}
    	}
    	result.left = makeTree(pre, in, pres+1, pres + (index - ins), ins, index - 1);
    	result.right = makeTree(pre, in, pres + (index - ins) + 1, pred, index + 1, ine);
    	return result;
    }
}