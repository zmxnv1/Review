public class PriorityQueue{
	private int min;
	private int[] nums;
	private int size = 1;

	public PriorityQueue(int size){
		nums = new int[size];
	}
	public PriorityQueue(int[] nums){
		this.nums = new int[nums.length * 2];
		for(int i = 0; i < nums.length; i++) {
			this.nums[i+1] = nums[i];
			size++;
		}
		for(int i = nums.length / 2; i > 0; i--) {
			percolateDown(i);
		}
	}


	public void percolateDown(int index){
		int temp = nums[index];

		while((index * 2 < size && temp > nums[index * 2]) ||
			(index * 2 + 1 < size) && temp > nums[index * 2 + 1]) {
			if(index * 2 + 1 < size && nums[index * 2 + 1] < nums[index * 2]) {
				nums[index] = nums[index * 2 + 1];
				index = index * 2 + 1;
			}
			else {
				nums[index] = nums[index * 2];
				index = index * 2;
			}

		}
		nums[index] = temp;
	}
	public void insert(int num){
		int index = size++;
		if(size > nums.length) {
			System.out.println("OutOfMemory");
			return ;
		}
		while(index / 2 > 0 && nums[index / 2] > num) {
			nums[index] = nums[index / 2];
			index = index / 2;
		}
		nums[index] = num;
	}
	public void deleteTop() {
		nums[1] = nums[--size];
		percolateDown(1);		
	}
	public void print(){
		while(size != 1) {
			System.out.println(nums[1]);
			deleteTop();
		}
	}
	public void println(){
		for(int i = 1; i < size; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void main(String[] args){
		PriorityQueue queue = new PriorityQueue(20);	
		for(int i = 0; i < args.length; i++){
			queue.insert( Integer.valueOf(args[i]));
		}
		queue.print();
	}
}