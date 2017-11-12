public class QuickSort{

	public static void sort(int[] nums, int s, int e) {
		if(nums == null || s >= e || nums.length == 1){
			return ;
		}
		int flag = nums[(s + e) / 2], i = s, j = e;
		while(i <= j) {
			while(nums[i] < flag) {
				i++;
			}
			while(nums[j] > flag) {
				j--;
			}
			if(i < j) {
				nums[i] = nums[i] ^ nums[j]; 
				nums[j] = nums[i] ^ nums[j]; 
				nums[i] = nums[i] ^ nums[j]; 
				++i;
				--j;
			}if(i == j) {
				++i;
			}
		}
		sort(nums, s, j);
		sort(nums, i, e);
	}
	public QuickSort(){


	}

	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for(int i = 0; i < args.length; i++) {
			nums[i] = Integer.valueOf(args[i]);
		}

		sort(nums, 0, nums.length - 1);
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}				
	}
}