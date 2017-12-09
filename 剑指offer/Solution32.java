public class Solution32{
    public int FirstNotRepeatingChar(String str) {
        int[] numbers = new int[128];
        for(int i = 0; i < 128; i++) {
            numbers[i] = 0;
        }
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            numbers[(int)c - 0]++;
        }
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(numbers[(int)c - 0] == 1) return i;
        }
        return -1;
    }
}
