package backtracking;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39.https://leetcode.com/problems/combination-sum/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/24 15:35:41
 * @since JDK8.0
 */
public class Combination_Sum_39 {
    public static void main(String[] args) {
        Combination_Sum_39 s = new Combination_Sum_39();
        Combination_Sum_39.Solution solution = s.new Solution();
        // 方法一: 做 27 次
        // 方法二: 做 16 次
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.print(result);
    }

    /**
     * Runtime: 2 ms, Beats 84.00%
     * 使用遞迴的方式，每一次進去都要做遍歷，去檢查每一個組合
     */
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            combinationSum_dfs(0, candidates, target, new ArrayList());
            return result;
        }

        public void combinationSum_dfs(int index, int[] candidates, int target, List<Integer> list) {
            if (index == candidates.length) return;
            if (target == 0) {
                result.add(new ArrayList(list));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                if (target - candidates[i] >= 0) combinationSum_dfs(i, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * test2
     * 優化:
     * 但時間沒有比較好
     * 因為上面的做法無法做到提前結束
     * 所以將 void 改成 int 去判斷是否要提早結束
     * 例如[2, 2, 2, 2] 已經知道 too big，但 [2, 2, 2, 3] 也會繼續算，所以當 too big 就 return -1 並且讓 for 提早結束
     */
//    class Solution {
//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            List<List<Integer>> result = new ArrayList();
//            // make sure that a candidates is sorted
//            Arrays.sort(candidates);
//            backtrack(0, 0, result, new ArrayList<Integer>(), target, candidates);
//
//            return result;
//        }
//
//        private Integer backtrack(int index, int sumOfTempList, List<List<Integer>> result, ArrayList<Integer> tempList, int target, int[] candidates) {
//            if (sumOfTempList > target) {
//                // too big
//                return -1;
//            } else if (sumOfTempList == target) {
//                result.add(new ArrayList<>(tempList));
//            } else {
//                for (int i = index; i < candidates.length; i++) {
//                    tempList.add(candidates[i]);
//                    int state = backtrack(i, sumOfTempList + candidates[i], result, tempList, target, candidates);
//                    if (state == -1) {
//                        tempList.remove(tempList.size() - 1);
//                        break;
//                    }
//                    tempList.remove(tempList.size() - 1);
//                }
//            }
//            return 0;
//        }
//    }
}
