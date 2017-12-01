public class Solution7 {
	public int Fibonacci(int n) {
		if(n <= 0) return 0;
		if(n == 1) return 1;
		return f(0, 1, 0, n);
	}
	public int f(int a, int b, int t, int n) {
		if(t == n - 2) return a + b;
		return f(b, a + b, t + 1, n);
	}
}