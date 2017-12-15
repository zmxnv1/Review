public class Solution {
    public String LeftRotateString(String str,int n) {
        if(n <= 0) return str;
        if(str.length() == 0) return str;
        n %= str.length();
        StringBuilder stringBuilder = new StringBuilder(str.substring(n, str.length()));
        stringBuilder.append(str.substring(0, n));
        return stringBuilder.toString();
    }
}