public class Solution13{
	public void reOrderArray(int[] array) {
		int[] temp = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		int indexs = 0, indexe = array.length - 1;
		for(int i = 0, j = array.length - 1; i < array.length || j >= 0; i++, j--) {
			if(i < array.length && temp[i] % 2 == 1) {
				array[indexs++] = temp[i];
			}
			if(j >= 0 && temp[j] % 2 == 0) {
				array[indexe--] = temp[j];
			}
		}
	}
}