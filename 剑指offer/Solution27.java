public class Solution27{
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array.length == 0) return 0;
		if(array.length == 1) return 1;
		int result = array[0], count = 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] == result) count++;
			else {
				count--;
				if(count == 0) {
					if(i == array.length - 1) break;  //import
					result = array[i + 1];
					i++;	
					count = 1;
				}
			}
		}
		count = 0;
		for(int i : array) {
			if(i == result) count++;
		}
		if(count > array.length / 2) return result;
		else return 0; 
	}
}