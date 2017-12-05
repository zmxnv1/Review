import java.util.ArrayList;
import java.util.*;

public class Solution20 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	Deque stack = new LinkedList<Integer>();
    	if(popA.length == 0) return true;
    	int x = 0, y = 0;
    	while(!stack.isEmpty() || x != pushA.length) {
    		if(!stack.isEmpty() && (Integer)stack.peekLast() == popA[y]) {
    			stack.pollLast();
    			y++;
    		}
    		else {
    			if(x >= pushA.length) return false;
    			stack.offerLast(pushA[x++]);
    		}
    	}
    	if(y == popA.length) return true;
    	return false;
    }
}