public class CardSort{
	public int[] nums;
	public int[][] buckets ;
	boolean flag = true;

	public CardSort(int size){
		nums = new int[size];
		buckets = new int[20][size+1];
		for(int i = 0; i < 20; i++) {
			buckets[i][0] = 1;
		}
	}

	public void cardSort(){
		int max = -2147483648;
		int bit = 0;
		for(int i = 0; i < nums.length ; i++) {
			int num = nums[i];
			if(num > max) max = num;
			buckets[mod(num, 1)][buckets[mod(num, 1)][0]] = num;
			buckets[mod(num, 1)][0]++;
		}
		while(max != 0){
			max /= 10;
			bit++;
		}


		for(int i = 2; i <= bit; i++) {
			if(flag) {
				for(int j = 0; j < 10; j++) {
					for(int index = 1; index < buckets[j][0]; index++){
						int num = buckets[j][index];
						buckets[10 + mod(num, i)][buckets[10 + mod(num, i)][0]] = buckets[j][index];	
						buckets[10 + mod(num, i)][0]++;	
						System.out.println(flag +": "+(10 + mod(num, i)));
					}	
					buckets[j][0] = 1;
				}
				flag = false;
			}
			else{
				for(int j = 10; j < 20; j++) {
					for(int index = 1; index < buckets[j][0]; index++){
						int num = buckets[j][index];
						buckets[mod(num, i)][buckets[mod(num, i)][0]] = buckets[j][index];
						buckets[mod(num, i)][0]++;
						System.out.println(flag + ": " +(10 + mod(num, i)));
					}
					buckets[j][0] = 1;
				}
				flag = true;
			}
		}

		int base;
		if(flag) base = 0;
		else base = 10;
		int index = 0;
		for(int i = base; i < base+10; i++) {
			for(int j = 1; j < buckets[i][0]; j++) {
				nums[index++] = buckets[i][j];
			}
		}
	}

	public void print(){
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}



	public int mod(int num, int index){
		return index != 1 ? mod(num/10, index-1) : num%10;
	}

	public static void main(String[] args) {
		CardSort cardSort = new CardSort(args.length);
		for(int i = 0; i < args.length; i++) {
			cardSort.nums[i] = Integer.valueOf(args[i]);
		}
		cardSort.cardSort();
		cardSort.print();
		
	}
}