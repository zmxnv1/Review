public class Solution1{
	public boolean Find(int target, int[][] array){
		int x = 0, y = array[0].length - 1;
		while(x < array.length && y >= 0) {
			if(array[x][y] > target) y--;
			else if(array[x][y] < target) x++;
			else if(array[x][y] == target) return true;
		}
		return false;
	}
}