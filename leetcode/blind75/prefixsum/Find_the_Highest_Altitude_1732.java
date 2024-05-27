package prefixsum;

/**
 * 1732.https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * @author AaronWU
 * @created 創建時間：2024/05/27 16:24:07
 * @since JDK8.0
 */
public class Find_the_Highest_Altitude_1732 {
    public static void main(String[] args) {
        Find_the_Highest_Altitude_1732 s = new Find_the_Highest_Altitude_1732();
        Solution solution = s.new Solution();
//        int[] gain = {-5, 1, 5, 0, -7};
        int[] gain = {44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64, -47, 95, 91, -40, 65, 67, 92, -28, 97, 100, 81};
        int result = solution.largestAltitude(gain);
        System.out.println(result);
    }

    class Solution {
//        public int largestAltitude(int[] gain) {
//            int[] sumArray = new int[gain.length + 1];
//            int max = 0;
//            for (int i = 1; i < sumArray.length; i++) {
//                sumArray[i] += sumArray[i - 1] + gain[i - 1];
//                max = Math.max(max, sumArray[i]);
//            }
//            return max;
//        }

        public int largestAltitude(int[] gain) {
            int sum = 0, max = 0;
            for (int i = 0; i < gain.length; i++) {
                sum += gain[i];
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}
