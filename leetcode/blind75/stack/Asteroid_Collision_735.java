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

    class Solution {
        /**
         * Runtime: 8 ms, Beats 20.07%
         * 解法:
         * 衝突就是 + -
         * 三種情況
         * => 大+ 小-
         * 不 push 繼續往右看
         * <p>
         * => 中+ 中-
         * 兩者抵銷，抵銷只會做一次，所以放到最後再檢查
         * <p>
         * => 小+ 大-
         * pop，繼續往左找比 大- 還大的，這個有可能會持續性的發生，所以先做
         */
//        public int[] asteroidCollision(int[] asteroids) {
//            // 使用 stack 去存
//            Stack<Integer> stack = new Stack();
//
//            for (int num : asteroids) {
//                // 小+ 大- 可能要一直 pop 直到找到更大的
//                // 如果當前 peek 是負的，拿去跟 -num 比較，就會變成拿負的跟正的比較(-num變正)
//                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
//                    stack.pop();
//                }
//                // 可能 pop 到沒有 || 之前 peek 已經是負，現在也是負
//                if (stack.isEmpty() || num > 0 || stack.peek() < 0) {
//                    stack.push(num);
//                }
//                // 中+ 中- 會抵消
//                if (stack.peek() == -num) {
//                    stack.pop();
//                }
//            }
//
//            // output stack
//            int[] result = new int[stack.size()];
//            for (int i = 0; i < stack.size(); i++) {
//                result[i] = stack.get(i);
//            }
//            return result;
//        }

        /**
         * Runtime: 1 ms, Beats 100.00%
         * 解法
         * 使用 array + index 取代 stack 功能
         * stack.pop() => index--
         * stack.isEmpty() => index == 0
         * stack.peek() => asteroids[index - 1]
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
