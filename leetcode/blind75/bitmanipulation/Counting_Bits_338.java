package bitmanipulation;

/**
 * 338.https://leetcode.com/problems/counting-bits/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/30 23:32:44
 * @since JDK8.0
 */
public class Counting_Bits_338 {
    public static void main(String[] args) {
        Counting_Bits_338 s = new Counting_Bits_338();
        Counting_Bits_338.Solution solution = s.new Solution();
        int n = 5;
        int[] result = solution.countBits(n);

        System.out.println("result: " + result);
    }

    class Solution {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int count = 0, num = i;
                while (num > 0) {
                    count += num & 1;
                    num >>= 1;
                }
                result[i] = count;
            }
            return result;
        }
    }
}
