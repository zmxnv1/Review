public class Solution35{
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) == -1 ? false : true;
    }
    public int depth(TreeNode root) {
        if(root == null) return 0;
        int a = depth(root.left);
        int b = depth(root.right);
        if(a == -1 || b == -1) return -1;
        if(a - b > 1 || a - b < -1) return -1;
        else return a > b ? a + 1 : b + 1;
    }

}
