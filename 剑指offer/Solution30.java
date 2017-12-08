import java.util.ArrayList;
import java.util.*;

public class Solution30{
    public static String PrintMinNumber(int[] numbers) {
        if(numbers.length == 0) return " ";
        Integer[] integer = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
                integer[i] = numbers[i];
        }
        Arrays.sort(integer, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                String s1 = String.valueOf(n1);
                String s2 = String.valueOf(n2);
                if((s1 + s2).compareTo(s2 + s1) > 0) return 1;
                else return -1;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for(int i : integer) {
            stringBuilder.append(String.valueOf(i));
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        int[] numbers = new int[args.length];
        for(int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }
        System.out.println(PrintMinNumber(numbers));
    }
}
