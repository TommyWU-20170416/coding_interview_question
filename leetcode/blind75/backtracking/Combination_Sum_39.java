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

    class Solution {
        private int count = 1;

        /**
         * test1
         * 解法:
         * 先排序，並使用 recursive 抓出每一個的結果
         * 1. 如果 target - 當前 < 0 表示太大，則要把該數字拿掉往後尋找
         * 2. 如果 target - 當前 ==0 表示找到了，要新增到 result 內，tempList 因為要沿用所以 new 出來放到 result 內
         * 3. 如果不是上述的情況，就繼續累加下去
         */
//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            List<List<Integer>> result = new ArrayList();
//            Arrays.sort(candidates); // 排序後若 sum 大於 traget 後面就不用再算
//            backtrack(candidates, target, result, new ArrayList<>(), 0);
//
//            return result;
//        }
//
//        private void backtrack(int[] candidates, int remain, List<List<Integer>> result, List<Integer> tempList, int start) {
//            if (remain < 0) {
//                return;
//            } else if (remain == 0) {
//                result.add(new ArrayList<>(tempList)); // why is here need new, because we need to continue using the templist
//                return;
//            } else {
//                for (int i = start; i < candidates.length; i++) {
//                    tempList.add(candidates[i]);
//                    backtrack(candidates, remain - candidates[i], result, tempList, i);  // not i + 1 because we can reuse same elements
//                    tempList.remove(tempList.size() - 1);
//                }
//            }
//        }
//
//        private void printTempList(List<Integer> list) {
//            System.out.print("第" + count++ + "次: ");
//            for (int num : list) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }

        /**
         * test2
         * 優化:
         * 因為上面的做法無法做到提前結束
         * 所以將 void 改成 int 去判斷是否要提早結束
         * 例如[2, 2, 2, 2] 已經知道 too big，但 [2, 2, 2, 3] 也會繼續算，所以當 too big 就 return -1 並且讓 for 提早結束
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList();
            // make sure that a candidates is sorted
            Arrays.sort(candidates);
            backtrack(0, 0, result, new ArrayList<Integer>(), target, candidates);

            return result;
        }

        private Integer backtrack(int index, int sumOfTempList, List<List<Integer>> result, ArrayList<Integer> tempList, int target, int[] candidates) {
            if (sumOfTempList > target) {
                // too big
                return -1;
            } else if (sumOfTempList == target) {
                result.add(new ArrayList<>(tempList));
            } else {
                for (int i = index; i < candidates.length; i++) {
                    tempList.add(candidates[i]);
                    int state = backtrack(i, sumOfTempList + candidates[i], result, tempList, target, candidates);
                    if (state == -1) {
                        tempList.remove(tempList.size() - 1);
                        break;
                    }
                    tempList.remove(tempList.size() - 1);
                }
            }
            return 0;
        }
    }
}
