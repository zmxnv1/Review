import java.util.ArrayList;

public class Solution54{
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int j = 1; j < (sum + 1) / 2; j++) {
            int b = (int)(Math.pow(4 * j * j + 8 * sum - 4 * j + 1, 0.5)); //0.5
            int a = 0;
            if(b * b == (4 * j * j + 8 * sum - 4 * j + 1) && b % 2 == 1){
                System.out.println(b);
                a = (b - 1) / 2;
            }
            else continue;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int k = j; k <= a; k++){
                temp.add(k);
            }
            result.add(temp);
        }
        return result;
    }
    public static void main(String[] args){
        new Solution54().FindContinuousSequence(3);
    }
    
}