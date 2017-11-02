class Node{
	int value;
	Node left;
	Node right;
	public Node(int value){
		this.value = value;
	}
}
public interface BinaryTree{
	boolean isEmpty();
	int size();
	int height();
	void preOrder();
	void inOrder();
	void postOrder();
	void levelOrder();
	void insert(int value);
}
