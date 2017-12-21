import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution48{
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> layer = new LinkedList<Integer>();
        queue.offer(pRoot);
        layer.offer(1);
        ArrayList<Integer> tempArrayList = new ArrayList<>();
        tempArrayList.add(pRoot.val);
        result.add(tempArrayList);
        int last = 0;
        while(!queue.isEmpty()){
            TreeNode t = queue.peekFirst();
            Integer l = layer.peekFirst();
            if(l > last) {
                last = l;
            }
            else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!queue.isEmpty() && last == l) {
                    if(layer.peekFirst() != last) {
                        if(last % 2 == 1) {
                            Object[] arrays = temp.toArray();
                            temp.clear();
                            for(int i = arrays.length - 1; i >= 0; i--) {
                                temp.add((Integer)arrays[i]);
                            }
                        }
                        result.add(temp);
                        break;
                    }
                    t = queue.pollFirst();
                    l = layer.pollFirst();
                    if(t.left != null) {
                        queue.add(t.left);
                        layer.add(l + 1);
                        temp.add(t.left.val);
                    }
                    if(t.right != null) {
                        queue.add(t.right);
                        layer.add(l + 1);
                        temp.add(t.right.val);
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode pNode = new TreeNode(8);
        pNode.left = new TreeNode(6);
        pNode.right = new TreeNode(10);
        pNode.left.left = new TreeNode(5);
        pNode.left.right = new TreeNode(7);
        pNode.right.left = new TreeNode(9);
        pNode.right.right= new TreeNode(11);
        ArrayList<ArrayList<Integer>> result = new Solution48().Print(pNode);
        for(ArrayList<Integer> temp : result) {
            for(Integer i : temp) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
}