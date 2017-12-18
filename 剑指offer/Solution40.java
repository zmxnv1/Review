
public class Solution40{
    public boolean duplicat(int[] numbers, int length, int[] duplication) {
        int size = 0, n = 0, flag = 0;
        for(int i = 0; i < length; i++) {
            int index = numbers[i];
            if(index < 0) index *= -1;
            if(numbers[index] < 0 || (flag == 1 && numbers[index] == 0)) {
                duplication[0] = (numbers[index] * -1);
                return true;
            }
            if(numbers[index] == 0) flag = 1;
            else numbers[index] *= -1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] duplication = new int[1];
        int[] numbers = new int[args.length];
        for(int i = 0; i < args.length; i++){
            numbers[i] = Integer.parseInt(args[i]);
        }
        if(new Solution40().duplicat(numbers, numbers.length, duplication)) {
            System.out.println(duplication[0]);
        }
    }
}