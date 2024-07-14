package weeklycontest402;

import java.util.HashMap;
import java.util.Map;

public class Count_Pairs_That_Form_A_Complete_Day_I {
    public static void main(String[] args) {
        Count_Pairs_That_Form_A_Complete_Day_I s = new Count_Pairs_That_Form_A_Complete_Day_I();
        Count_Pairs_That_Form_A_Complete_Day_I.Solution solution = s.new Solution();
        // 2147483647
        int[] hours = {72, 48, 24, 3};
        int result = solution.countCompleteDayPairs(hours);

        System.out.println("result: " + result);
    }

    class Solution {
        public int countCompleteDayPairs(int[] hours) {
            if (hours.length == 1) return 0;
            Map<Integer, Integer> map = new HashMap();
            int count = 0;
            for (int i = 0; i < hours.length; i++) {
                int a = hours[i] % 24;
                if (map.get(a) != null && (map.get(a) == hours[i] || map.get(a) + hours[i] == 24)) {
                    count++;
                } else {
                    if (a == 0) {
                        map.put(0, map.getOrDefault(0, 0) + 1);
                    } else {
                        map.put(24 - a, map.getOrDefault(a, 1));
                    }
                }
            }
            return count;
        }
    }
}
