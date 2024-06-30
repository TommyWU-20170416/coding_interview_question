package dynamicprogramming.onedim;

import java.util.HashMap;
import java.util.Map;

/**
 * f(0) = 0
 * f(1) = 1
 * f(2) = f(1) + f(0) = 1
 * f(3) = f(2) + f(1) = 2
 * f(4) = f(3)        + f(2) = 3
 * ____ = f(2) + f(1) + f(2) = 3
 */
public class Fibonacci {
    private int count_fib = 0;
    private int count_fib_memo = 0;

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(10)); // if n = 10, count_fib would be 177
        System.out.println(fibonacci.fib_memo(10)); // if n = 10, count_fib_memo would be 19
        System.out.println(fibonacci.fib_bottom_up(2));
    }

    /**
     * 單純用 遞歸
     */
    public int fib(int n) {
        System.out.println("count_fib 第" + ++count_fib + "次");
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 加上 備忘錄優化
     */
    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib_memo(int n) {
        System.out.println("count_fib_memo 第" + ++count_fib_memo + "次");
        if (n <= 1) return n;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fib_memo(n - 1) + fib_memo(n - 2);
        memo.put(n, result);
        return result;
    }

    public int fib_bottom_up(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
