public class Solution39{
    public int  Add(int num1, int num2) {
        int a = num1 ^ num2;
        int b = num1 & num2;
        if(b != 0) {
            return Add(b <<= 1 , a);
        }
        else{
            return a;
        }
    }
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        System.out.println(new Solution39().Add(num1, num2));
    }
}