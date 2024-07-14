package weeklycontest402;

public class Count_Pairs_That_Form_a_Complete_Day_II {
    public static void main(String[] args) {
        Count_Pairs_That_Form_a_Complete_Day_II s = new Count_Pairs_That_Form_a_Complete_Day_II();
        Count_Pairs_That_Form_a_Complete_Day_II.Solution solution = s.new Solution();
        // 2147483647
        int[] hours = {24};
        long result = solution.countCompleteDayPairs(hours);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * Constraints:
         * <p>
         * 1 <= hours.length <= 5 * 10^5
         * 1 <= hours[i] <= 10^9
         */
        public long countCompleteDayPairs(int[] hours) {
            return 0;
        }
    }
}
