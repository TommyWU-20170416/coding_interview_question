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
//        int[] asteroids = {-2, -1, 1, 2};
//        int[] asteroids = {1, -2, 3, -4};
        int[] asteroids = {1, -1};
        int[] result = solution.asteroidCollision(asteroids);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int num : asteroids) {
                if (num > 0) {
                    stack.push(num);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(num);
                    }
                    if (stack.peek() == -num) {
                        stack.pop();
                    }
                }
            }

            int[] res = new int[stack.size()];
            int i = stack.size() - 1;
            while (!stack.isEmpty()) {
                res[i--] = stack.pop();
            }

            return res;
        }
    }
}
