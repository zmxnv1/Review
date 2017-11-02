import java.util.*;

public class SBT implements BinaryTree{
	private Node root;
	public int size = 0;

	public SBT(){

	}

	public SBT(int[] nums){
		for(int i = 0; i < nums.length; i++){
			insert(nums[i]);
		}
	}

	public void insert(int value){
		if(root == null) {
			root = new Node(value);
			size++;
			return;
		}
		Node p = root;
		while(p != null) {
			if(p.value > value ){
				if(p.left != null) p = p.left;
				else {
					p.left = new Node(value);
					size++;
					return;
				}
			} 
			else {
				if(p.right != null) p = p.right;
				else {
					p.right = new Node(value);
					size++;
					return;
				}
			}
		}
	}

	public void delete(int value){
		root = delete(value, root);
	}
	public Node delete(int value, Node p){
		if(p == null) return null;
		if(p.value > value) p.left = delete(value, p.left);
		else if(p.value < value) p.right = delete(value, p.right);
		else if(p.left == null ){ 
			p = p.right; 
		}
		else if(p.right == null){
			p = p.left;
		}
		else{
			Node next = searchNextNode(p);
			p.value = next.value;
			next = delete(next.value, next);				
		}
		return p;

	}
	public Node searchNextNode(Node node){
		Node p = node.right;
		while(p.left != null){
			p = p.left;
		}
		return p;
	}

	public void preOrder(){
		preOrder(root);
	}
	public void preOrder(Node p){
		if(p != null){
			System.out.println(p.value);
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	public void inOrder(){
		preOrder(root);
	}
	public void inOrder(Node p){
		if(p != null) {
			preOrder(p.left);
			System.out.println(p.value);
			preOrder(p.right);
		}
	}
	public void postOrder(){
		postOrder(root);
	}
	public void postOrder(Node p){    //非递归
		Deque<Node> deque = new LinkedList<Node>(); 
		Set<Integer> visit = new HashSet<Integer>();
		while(p != null){
			Node temp = p;
			deque.add(temp);
			visit.add(temp.value);
			p = p.left;
		}
		while(!deque.isEmpty()){
			Node now = deque.peekLast();
			if(now.right == null) {
				System.out.println(now.value);
				deque.pollLast();
				continue;
			}
			else if(visit.contains(now.right.value)){
				System.out.println(now.value);	
				deque.pollLast();
				continue;

			}
			Node right = now.right;
			while(right != null){
				deque.add(right);
				visit.add(right.value);
				right = right.left;
			}
		}
	}


	public int height(){
		return height(root);
	}
	public int height(Node p){
		if(p == null) return -1;
		else return Math.max(height(p.left), height(p.right)) + 1;
	}

	public void levelOrder(){
		levelOrder(root);
	}
	public void levelOrder(Node p){
		Deque<Node> deque = new LinkedList<Node>();
		deque.addLast(p);
		while(!deque.isEmpty()){
			p = deque.pollFirst();	
			System.out.println(p.value);
			Node left = p.left;
			Node right = p.right;
			if(left != null) deque.addLast(left);
			if(right != null) deque.addLast(right);
		}
	}

	public int size(){
		return size;
	}
	public boolean isEmpty(){
		if(size == 0) return true;
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 4 ,-1, 9, 10, -43, -23, 40, 33};
		SBT sbt = new SBT(nums);		
		sbt.levelOrder();
	}
}