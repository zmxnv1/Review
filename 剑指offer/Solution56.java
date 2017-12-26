import java.util.*;
public class Solution56{
    public ArrayList maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<Integer>();        
        if(num == null || num.length == 0) return result;
        if(size > num.length) size = num.length;
        list.offerLast(num[0]);
        for(int i = 1; i < size; i++) {
            while(!list.isEmpty() && num[i] > list.peekLast()){
                list.pollLast();
            }
            list.offerLast(num[i]);
        }
        result.add(list.peekFirst());
        for(int i = size; i < num.length; i++) {
            if(num[i - size] == list.peekFirst()) {
                list.pollFirst();
            }
            while(!list.isEmpty() && num[i] > list.peekLast()) {
                list.pollLast();
            }
            list.offerLast(num[i]);
            result.add(list.peekFirst());
        }
        for(int i : result) {
            System.out.println(i + " ");
        }
        System.out.println(" ");
        return result;
    }
    public static void main(String[] args) {
        int[] num = new int[args.length];
        for(int i = 0; i < args.length; i++) {
            num[i] = Integer.valueOf(args[i]);
        }
        new Solution56().maxInWindows(num, 1);
    }
}
