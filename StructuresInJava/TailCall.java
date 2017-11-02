public class TailCall{
	public int recursion(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		else return (recursion(n-1) + recursion(n-2));
	}

	public int tailCall(int a, int b, int c, int d){
		if(c == 1 || c == 2) return 1;
		if(c == d+1) return (a + b);
		else return tailCall(b, a+b, c, d+1);
	}


	public static void main(String[] args) {
		TailCall n = new TailCall();
		//System.out.println(n.recursion(20));
		System.out.println(n.tailCall(0, 1, 30, 1));
	}
}