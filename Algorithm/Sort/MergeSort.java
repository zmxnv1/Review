public class MergeSort{
    public static void recursiveSort(int[] nums, int s, int e){
        if(e - s == 0) return;
        if(e - s == 1) {
            if(nums[s] > nums[e]) {
                nums[s] = nums[s] ^ nums[e];
                nums[e] = nums[s] ^ nums[e];
                nums[s] = nums[s] ^ nums[e];
            }
            return ;
        }
        int m = (e - s) / 2 + s;
        recursiveSort(nums, s, m);
        recursiveSort(nums, m + 1, e);

        int[] temp = new int[e - s + 1];
        int i = s, j = m + 1, index = 0;

        while(i <= m || j <= e) {
            if(i <= m ) {
                if((j <= e && nums[i] < nums[j]) || j > e) {
                    temp[index++] = nums[i];
                    i++;
                }
                else{
                    temp[index++] = nums[j];
                    j++;
                }
            }
            else {
                temp[index++] = nums[j];
                j++;
            }
        }
        for(int k = s; k <= e; k++) {
            nums[k] = temp[k - s];
        }
    } 
    public static void iterationSort(int[] nums){
        int length = nums.length;
        int[] temp = new int[length];
        int s;

        for(int i = 1; i < length * 2 ; i *= 2) {
            for(s = 0; s < length; s += 2 * i) {
                int mid = (s + i) < length ? (s + i): length;
                int e  = (i * 2 + s);
                if(e >= length) e = length;

                int s1 = s, e1 = mid, index = s;
                int s2 = mid, e2 = e;
                while(s1 < mid && s2 < e) {
                    if(nums[s1] < nums[s2]){
                        temp[index++] = nums[s1];
                        s1++;
                    }
                    else {
                        temp[index++] = nums[s2];
                        s2++;
                    }
                }
                while(s1 < mid) {
                    temp[index++] = nums[s1];
                    s1++;
                }
                while(s2 < e) {
                    temp[index++] = nums[s2];
                    s2++;
                }
                for(int k = s; k < e; k++) {
                    nums[k] = temp[k];
                }
            }
        }

    }

    public static void main(String[] args){
        int[] nums = new int[args.length];
        int index = 0;
        for(String s : args) {
            nums[index++] = Integer.valueOf(s);
        }
        recursiveSort(nums, 0, nums.length - 1);
        for(int i : nums){
            System.out.println(i);
        }
    }
}