package queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 649.https://leetcode.com/problems/dota2-senate/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/03 10:53:38
 * @since JDK8.0
 */
public class Dota2_Senate_649 {
    public static void main(String[] args) {
        Dota2_Senate_649 s = new Dota2_Senate_649();
        Dota2_Senate_649.Solution solution = s.new Solution();
        String senate = "DDRRR";
        String result = solution.predictPartyVictory(senate);
        System.out.println(result);
    }


    class Solution {
        /**
         * Runtime: 10 ms, Beats 88.68%
         * 解法:
         * 把 Radiant 跟 Dire 分別記錄 index 到 queue 內
         * 接著 poll 出來，只要比較小的代表可以把對方 ban 掉，ban 掉後再自己的 queue 新增一組，表示下一輪還可以繼續做
         * 最後看 誰空掉誰就輸
         */
        public String predictPartyVictory(String senate) {
            Queue<Integer> rad = new ArrayDeque<>(), dir = new ArrayDeque<>();
            int end = senate.length();

            for (int i = 0; i < senate.length(); i++) {
                if (senate.charAt(i) == 'R') {
                    rad.add(i);
                } else {
                    dir.add(i);
                }
            }

            while (!rad.isEmpty() && !dir.isEmpty()) {
                int radPoll = rad.poll();
                int dirPoll = dir.poll();
                if (radPoll > dirPoll) {
                    dir.add(end++);
                } else {
                    rad.add(end++);
                }
            }

            return (rad.isEmpty()) ? "Dire" : "Radiant";
        }
    }
}
