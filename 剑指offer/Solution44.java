public class Solution44{
    public int StrToInt(String str) {
        if(str.length() == 0) return 0;
        long result = 0, flag = 0;
        int index = 0;
        if(str.charAt(0) == '-') {
            flag = 1;
            index++;
        }
        if(str.charAt(0) == '+') {
            index++;
        }
        while(index < str.length()) {
            if(str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                result *= 10;
                result += str.charAt(index) - '0';
                if(flag == 0 && result > 2147483647) return 0;
                if(flag == 1 && result > 2147483648L) return 0;
            }
            else return 0;
            index++;
        }
        return (int)result * (flag == 1 ? -1 : 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution44().StrToInt(args[0]));
    }
}
