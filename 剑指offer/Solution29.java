public class Solution29 {
    public int FindGreatestSumOfSubArray(int[] array) {
    	if(array.length == 0) return 0;
       	int result = 0, max = array[0];
       	for(int i = 0; i < array.length; i++) {
       		result += array[i];
       		if(result > max) {
       			max = result;
       		}
       		if(result < 0) {
       			result = 0;
       		}
       	}
       	return max;
    }
}