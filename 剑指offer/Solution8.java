public class Solution8{
	public int JumpFloor(int target) {
		if(target <= 0) return 0;
		if(target == 1) return 1;
		int a = 0, b = 1, c = 0;
		while(c < target - 1) {
			int temp = a;
			a = b;
			b += temp;
			c++;
		}
		return a + b;
	}
}