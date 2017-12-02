public class Solution11{
    public int NumberOf1(int n) {
        int r = 0;
        while(n != 0) {
            n &= n - 1;
            r++;
        }
        return r;

    }
}