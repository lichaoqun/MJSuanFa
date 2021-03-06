public class Main {

	public static void main(String[] args) {
		// - 斐波那契数列 0 1 1 2 3 5 8 13 21...
		System.out.println(fib4(20));
	}
	
	// - 方法一 时间复杂度很高 O(2^n)
	public static int fib1(int n) {
		if (n <= 1) return n;
		return (fib1(n - 1) + fib1(n - 2));
	}
	
	// - 方法二 时间复杂度比较低 O(n)
	public static int fib2(int n) {
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int next = first + second;
			first = second;
			second = next;
		}
		return second;
	}
	
	// - 方法三 省略局部变量
	public static int fib3(int n) {
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		while (n-- > 1) {
			second += first;
			first = second - first;
		}
		return second;
	}
	
	// - 方法四 特征方程 时间复杂度很高 O(1)
	public static int fib4(int n) {
		double c = Math.sqrt(5);
		return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
	}
	/**
	 * 时间复杂度 : 估算程序指令执行的次数, 假设每个分号范围是一个指令;
	 * 空间复杂度 : 估算所需占用的存储空间;
	 **/
}
