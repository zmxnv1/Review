public class Solution22{
	public boolean VerifySqueneceOfBST(int[] sequence) {
		if(sequence == null || sequence.length == 0) return false;   //空返回false
		if(sequence.length <= 2) return true;
		return judge(sequence, 0, sequence.length - 1);
	}
	public boolean judge(int[] sequence, int s, int e) {
		if(s >= e - 1) return true;
		int falg = sequence[e]; 
		for(int j = e - 1; j >= s; j--) {
			if(sequence[j] < flag) {
				for(int x = s; x <= j; x++) {
					if(sequence[x] > flag) return false;
				}
				flag = j;	
				break;
			}
			if(j == s) return judge(sequence, s, e - 1);  //注意
		}
		return judge(sequence, s, flag)  && judge(sequence, flag + 1, e - 1);
	}
}