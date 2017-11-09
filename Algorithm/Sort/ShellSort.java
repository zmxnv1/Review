public class ShellSort{
	public static void sort(int[] nums){
		int length = nums.length;
		for(int i = length >> 1; i > 0; i >>= 1 ){
			for(int j = i; j < length; j++){
				int temp = nums[j], k = j -	i;
				for(; k >= 0 && temp < nums[k]; k -= i){
					nums[k + i] = nums[k];
				}
				nums[k + i] = temp;
			}
		}
	}
	public static void main(String[] args){
		int[] nums = new int[args.length];
		int index = 0;
		for(String s : args) {
			nums[index++] = Integer.valueOf(s);
		}
		sort(nums);
		for(int i : nums){
			System.out.println(i);
		}
	}
}