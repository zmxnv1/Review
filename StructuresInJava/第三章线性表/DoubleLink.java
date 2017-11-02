import java.util.*;

class Node{
	String value;
	Node last;
	Node next;	

	Node(){

	}
	Node(String value, Node last, Node next) {
		this.value = value;
		this.last = last;
		this.next = next;
	}

}
public class DoubleLink<N>{
	Node head;
	Node till;
	int length = 0;

	public DoubleLink(){
		head = new Node();
		till = head;
	}

	public boolean isEmpty(){
		if(length == 0) return true;
		else return false;

	}

	public void addNodePre(String value){
		Node node = new Node(value, till, null);
		till.next = node;
		till = till.next;
	}
	public void addNodeRev(String value){
		Node node = new Node(value, head, head.next);
		if(head.next != null) head.next.last = node;
		else till = node;
		head.next = node;

	}

	public void deleteNode(Node node) {
		for(Node p = head.next; p != null; p = p.next){
			if(p.value.equals(node.value)){
				p.last.next = p.next;
				if(p.next != null) p.next.last = p.last;
				else till = p.last;
			}
		}

	}

	public void printPre(){
		for(Node p = head.next; p != null; p = p.next){
			System.out.println(p.value);
		}
	}
	public void printRev(){
		for(Node p = till; p != head; p = p.last){
			System.out.println(p.value);
		}

	}

	public static void main(String[] args){
		DoubleLink<String> doubleLink = new DoubleLink<String>();
		for(int i = 0; i < args.length; i++) {
			if(i < args.length/2) doubleLink.addNodeRev(args[i]);
			else doubleLink.addNodePre(args[i]);
		}
		Node node = new Node();
		node.value = "a";
		doubleLink.deleteNode(node);
		doubleLink.printPre();
	}
}