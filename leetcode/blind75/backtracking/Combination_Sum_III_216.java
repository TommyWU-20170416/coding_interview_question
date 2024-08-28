package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.https://leetcode.com/problems/combination-sum-iii/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/26 14:22:27
 * @since JDK8.0
 */
public class Combination_Sum_III_216 {
    public static void main(String[] args) {
        Combination_Sum_III_216 s = new Combination_Sum_III_216();
        Combination_Sum_III_216.Solution solution = s.new Solution();
        int k = 3, n = 9;
//        int k = 9, n = 45;
        List<List<Integer>> result = solution.combinationSum3(k, n);
        System.out.print(result);
    }

    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(k, n, 1, new ArrayList<Integer>());
            return result;
        }

        private void dfs(int k, int n, int index, List<Integer> list) {
            if (k == 0) {
                if (n != 0) return;
                else {
                    result.add(new ArrayList<>(list));
                }
            }

            for (int i = index; i < 10; i++) {
                list.add(i);
                dfs(k - 1, n - i, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
