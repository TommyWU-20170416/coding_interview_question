package bitmanipulation;

/**
 * 如果都是奇數，再跟 0001 去做 & 的時候，因為奇數尾數一定有1 所以 & 後 == 1 表示奇數
 * <pre>
 * {@code
 * // EX: 7
 * //   0111:7
 * // & 0001:1
 * // = 0001:1
 *
 * // EX: 8
 * //   1000:8
 * // & 0001:1
 * // = 0000:0
 * }
 * </pre>
 */
public class FindOddOrEven {
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(num + " is odd: " + isOdd(num)); // true
    }
}