import java.util.ArrayList;
public class Solution37{
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        if(array.length == 0 || array.length == 1) return r;
        int min = 0x7fffffff, i = 0, j = array.length - 1, rx = 0, ry = 0;
        while(i < j) {
            int x = array[i], y = array[j];
            if(x + y == sum) {
                if(x * y < min) {
                    rx = x;
                    ry = y;
                    min = x * y;
                }
                i++;
                j--;
            }
            else if(x + y < sum) {
                i++;
            }
            else if(x + y > sum) {
                j--;
            }
        }
        if(min != 0x7fffffff) {
            r.add(rx);
            r.add(ry);
        }
        return r;
    }
}
