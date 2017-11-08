import java.util.*;
public class InsertSort{
	public static void sort(int[] nums){
		for(int i = 1; i < nums.length; i++) {
			int temp = nums[i], j = i - 1;
			for(; j >= 0 && nums[j] > temp; j--) {
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = temp;
		}
	}
	public static void main(String[] args){
		int[] nums = new int[args.length];
		for(int i = 0; i < args.length; i++) {
			nums[i] = Integer.valueOf(args[i]);
		}
		sort(nums);
		/*
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		*/
		for(int i : nums){
			System.out.println(i);
		}
	}
}