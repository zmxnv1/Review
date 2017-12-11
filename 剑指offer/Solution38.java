public class Solution38{
    public int Sum_Solution(int n) {
        if(n < 0) return 0;
        return add(0, n);
    }
    public int add(int a, int n) {
        if(n != 0) return add(a + n, n - 1);
        else return a;

    }
}