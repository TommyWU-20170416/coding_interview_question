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
//        int k = 3, n = 9;
        int k = 9, n = 45;
        List<List<Integer>> result = solution.combinationSum3(k, n);
        System.out.print(result);
    }

    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<Integer>(), k, n, 1);

            return result;
        }

        private void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int k, int remain, int index) {
            if (tempList.size() == k && remain == 0) {
                result.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = index; i < 10; i++) {
                if (tempList.size() == k) {
                    break;
                }

                tempList.add(i);
                backtrack(result, tempList, k, remain - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
