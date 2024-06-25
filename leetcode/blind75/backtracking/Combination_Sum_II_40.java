package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.https://leetcode.com/problems/combination-sum-ii/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/25 22:27:39
 * @since JDK8.0
 */
public class Combination_Sum_II_40 {
    public static void main(String[] args) {
        Combination_Sum_II_40 s = new Combination_Sum_II_40();
        Combination_Sum_II_40.Solution solution = s.new Solution();
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;

        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        System.out.print(result);
    }

    class Solution {
        private int count = 1;

        private void printTempList(List<Integer> list) {
            System.out.print("第" + count++ + "次: ");
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        /**
         * test1
         * 解法:
         * 這一題跟 Combination_Sum_39 差異在 不能娶到自己，所以原本往下傳的 i 要變成 i + 1
         * 另一個重點是不能有重複，因為 i + 1 且 candidates 本身有重複，會造成相同的值被重複加到 result
         * 為了避免這樣的錯誤，要在 for 裡面判斷，如果 index < i(代表他已經呼叫過一次 backtrack 回來做第二次) && 當前 candidate[i] 值跟上一個一樣就要跳過
         */
//        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//            List<List<Integer>> result = new ArrayList<>();
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
//                // 加入之前去判斷是否有涵蓋，這樣寫會有 TLE，因為實際上計算也是繼續重複計算
//                // when input = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//                // 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
//                // target = 30
////                if (!result.contains(new ArrayList<>(tempList)))
//                result.add(new ArrayList<>(tempList));
//            } else {
//                for (int i = index; i < candidates.length; i++) {
//                    if (index < i && candidates[i] == candidates[i - 1]) {
//                        continue;
//                    }
//
//                    int cur = candidates[i];
//                    tempList.add(cur);
//                    printTempList(tempList);
//                    int state = backtrack(i + 1, sumOfTempList + candidates[i], result, tempList, target, candidates);
//                    if (state == -1) {
//                        tempList.remove(tempList.size() - 1);
//                        break;
//                    }
//                    tempList.remove(tempList.size() - 1);
//                }
//            }
//            return 0;
//        }

        /**
         * test2
         * 改變寫法
         * 1. 把 private int 改成 private void
         * 2. 把原本一進去提早判斷，拉到 for 裡面去算，可以減少 backtrack 呼叫
         * 3. 把 backtrack 參數減少
         *
         * 減少 recursive || 減少參數 都是可以降低 time complexity 的好方向
         */
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            // make sure that a candidates is sorted
            Arrays.sort(candidates);
            backtrack(0, result, new ArrayList<Integer>(), target, candidates);

            return result;
        }
        private void backtrack(int index, List<List<Integer>> result, ArrayList<Integer> tempList, int remain, int[] candidates) {
            if (0 == remain) {
                result.add(new ArrayList<>(tempList));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if (index < i && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] > remain) {
                    break;
                }

                tempList.add(candidates[i]);
                printTempList(tempList);
                backtrack(i + 1, result, tempList, remain - candidates[i], candidates);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

