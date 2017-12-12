class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}
public class Solution41{
    public int LastRemaining_Solution(int n, int m) {
        if(m == 0) return -1;
        if(n == 0) return 0;
        if(m == 1) return n-1;
        Node head = new Node(0);
        Node p = head;
        int count = 0, sum = (n * (n - 1)) / 2, tempSum = 0;
        for(int i = 1; i < n; i++) {
            p.next = new Node(i);
            p = p.next;
        }
        p.next = head;
        p = head;
        while(count < n - 1) {
           for(int i = 0; i < m - 2; i++) {
               p = p.next;
           }
           tempSum += p.next.val;
           p.next = p.next.next;
           p = p.next;
           count++;
        }
        return sum - tempSum;
    }
    public static void main(String[] args) {
        Solution41 s = new Solution41();
        System.out.println(s.LastRemaining_Solution(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}