package stack;

import java.util.Stack;

/**
 * 735.https://leetcode.com/problems/asteroid-collision/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/05 23:00:31
 * @since JDK8.0
 */
public class Asteroid_Collision_735 {
    public static void main(String[] args) {
        Asteroid_Collision_735 s = new Asteroid_Collision_735();
        Asteroid_Collision_735.Solution solution = s.new Solution();
//        int[] asteroids = {5, 10, -5};
//        int[] asteroids = {-2, -1, 1, 2};
        int[] asteroids = {1, -2, 3, -4};
//        int[] asteroids = {1, -1};
        int[] result = solution.asteroidCollision(asteroids);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * tset1
     * 解法:
     * 一開始知道 stack > 0 且 num < 0 代表有衝突，要解掉
     * 衝突就是 + -
     * 三種情況
     * => 大+ 小-
     * 小- 不 push 繼續往右看
     * <p>
     * => 中+ 中-
     * 兩者抵銷，抵銷只會做一次，所以放到最後再檢查
     * <p>
     * => 小+ 大-
     * 小+ pop，繼續往左找比 大- 還大的，這個有可能會持續性的發生，所以先做
     */

    class Solution {
        //        public int[] asteroidCollision(int[] asteroids) {
//            Stack<Integer> stack = new Stack<>();
//
//            for (int num : asteroids) {
//                if (num > 0) {
//                    stack.push(num);
//                } else {
//                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
//                        stack.pop();
//                    }
//                    if (stack.isEmpty() || stack.peek() < 0) {
//                        stack.push(num);
//                    }
//                    if (stack.peek() == -num) {
//                        stack.pop();
//                    }
//                }
//            }
//
//            int[] res = new int[stack.size()];
//            int i = stack.size() - 1;
//            while (!stack.isEmpty()) {
//                res[i--] = stack.pop();
//            }
//
//            return res;
//        }

        /**
         * test2
         * 解法
         * 使用 array + index 取代 stack 功能
         * index 像是 stack.peek() 的指標
         */
        public int[] asteroidCollision(int[] asteroids) {
            int n = asteroids.length;
            int index = 0;

            for (int i = 0; i < n; i++) {
                int cur = asteroids[i];
                while (index > 0 && cur < 0 && asteroids[index - 1] > 0 && asteroids[index - 1] < -cur) {
                    // 當前直 < 0 && 上一筆 > 0 && abs(當前) > 上一筆
                    index--;
                }

                if (index == 0 || cur > 0 || asteroids[index - 1] < 0) {
                    // 初始 || 大於0 || 上一個 < 0
                    asteroids[index++] = cur;
                } else if (-cur == asteroids[index - 1]) {
                    // 現在跟 上一個 abs 一樣大
                    index--;
                }
            }
            int[] res = new int[index];
            System.arraycopy(asteroids, 0, res, 0, index);
            return res;
        }
    }

}
