public class Solution10{
    public int RectCover(int target) {
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int a = 1, b = 2, temp, n = 2;
        while(n < target) {
            temp  = a;
            a = b;
            b = a + temp;
            n++;
        }
        return b;
    }
}