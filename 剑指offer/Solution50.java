import java.util.*;
import java.lang.StringBuilder;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution50{
    StringBuilder serialize(TreeNode root, int heigth, int l) {
        StringBuilder result = new StringBuilder();
        if(root == null) result.append("$/");
        else result.append(String.valueOf(root.val) + "/");
        if(l == heigth) return result;
        else {
            if(root == null) {
                result.append(serialize(null, heigth, l + 1));
                result.append(serialize(null, heigth, l + 1));
            }
            else {
                result.append(serialize(root.left, heigth, l + 1));
                result.append(serialize(root.right, heigth, l + 1));
            }
        }
        return result;
    }



    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if(root == null) return stringBuilder.toString();
        int heigth = getHeight(root), count = (int)Math.pow(2, (heigth + 1)) - 1, flag = 1;
        System.out.println(heigth);
        stringBuilder = serialize(root, heigth, 0);
        return stringBuilder.toString();
    }



    int getHeight(TreeNode root) {
        if(root == null) return -1;
        else return Math.max(getHeight(root.left), getHeight(root.right)) + 1; 
    }

    TreeNode Deserialize(String str) {
        String[] strings = str.split("/");
        TreeNode p;
        if(strings.length == 0) return null;
        try{
            p =  new TreeNode(Integer.valueOf(strings[0]));
        }catch(NumberFormatException e) {
            p = null;
        }
        if(strings.length == 1 || p == null) return p;
        else {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for(int i = 1; i <= strings.length / 2; i++) {
                left.append(strings[i] + "/");
            }
            for(int i = strings.length / 2 + 1; i < strings.length; i++) {
                right.append(strings[i] + "/");
            }
            p.left = Deserialize(left.toString());
            p.right = Deserialize(right.toString());
        }
        return p;
    }

    public static void main(String[] args) {
        String s = "8/6/5/7/10/9/11/";
        Solution50 test = new Solution50();
        System.out.println(test.Serialize(test.Deserialize(s)));
    }
}