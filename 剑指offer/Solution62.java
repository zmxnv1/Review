import java.util.*;
public class Solution62{
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer n1, Integer n2) {
            if(n1 > n2) return 1;
            return -1;
        }
    });

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer n1, Integer n2) {
            if(n1 > n2) return -1;
            return 1;

        }
    });

    public void Insert(Integer num) {
        if(count % 2 != 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        count++;
    
    }

    public Double GetMedian() {
        if(count % 2 == 0) {
            return (1.0 * (minHeap.peek() + maxHeap.peek()) / 2 );
        }
        else {
            return 1.0 * maxHeap.peek();
        }
        
    }
    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for(int i = 0; i < args.length; i++) {
            nums[i] = Integer.valueOf(args[i]);
        }
        Solution62 main = new Solution62();
        for(int i = 0; i <  args.length; i++) {
            main.Insert(nums[i]);
            System.out.println(main.GetMedian());
        }
    }

}