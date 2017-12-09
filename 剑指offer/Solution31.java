public class Solution31{
    public int GetUglyNumber_Solution(int index) {
        if(index < 0) return -1;
        if(index <= 6) return index;
        int[][] uglys = new int[3][index];
        index--;
        int ugly = 0, count = 0;
        uglys[0][0] = 2;
        uglys[1][0] = 3;
        uglys[2][0] = 5;
        int[] flags = new int[3];
        int[] indexs = new int[3];
        int[] numbers = {2, 3, 5};
        for(int i = 0; i < 3; i++) {
            flags[i] = 0;
            indexs[i] = 1;
        }
        while(count < index){
            ugly = uglys[0][flags[0]];
            for(int i = 1; i < 3; i++) {
                ugly = Math.min(uglys[i][flags[i]], ugly);
            }
            for(int i = 0; i < 3; i++) {
                uglys[i][indexs[i]++] = ugly * numbers[i];
            }
            for(int i = 0; i < 3; i++) {
                if(uglys[i][flags[i]] == ugly) flags[i]++;
            }
            count++;
        }
        return ugly;
    }
    public static void main(String[] args) {
        int index = Integer.valueOf(args[0]);
        Solution31 s = new Solution31();
        System.out.println(s.GetUglyNumber_Solution(index));
    }
}
