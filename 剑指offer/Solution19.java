import java.util.Stack;

class node{
	int val;
	int min;
	node next;
	node last;
}

public class Solution19 {

	node head = new node();
	node p = head;
    
    public void push(int node) {
    	p.next = new node();
    	p.next.val = node;
    	p.next.last = p;
    	if(p == head) p.next.min = node;
    	else{
    		p.next.min = (p.min < node ? p.min : node);
    	}
    	p = p.next;
    }

    public void pop() {
    	if(p == head) return;
       	p = p.last;
       	p.next = null; 
    }
    
    public int top() {
    	if(p == head) return -1;
    	return p.val;
    }
    
    public int min() {
    	if(p == head) return -1;
    	return p.min;
    }
}