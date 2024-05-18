package nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;


/**
 * 503.https://leetcode.com/problems/next-greater-element-ii/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月23日 下午10:38:20
 * @since JDK8.0
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which
 * is also 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 */
public class Next_Greater_Element_II {
    //    private static int[] nums = {1, 22, 1, 3, 6};
    private static int[] nums = {100, 1, 2, 1};
//    private static int[] nums = {5, 4, 3, 2, 1};

    public static void main(String[] args) {
        Next_Greater_Element_II test = new Next_Greater_Element_II();
        int[] result = test.nextGreaterElements(nums);
        printArray(result);
    }

    public int[] nextGreaterElements(int[] nums) {
        // 原本是用 hashmap 存 什麼value 對應什麼 greatNumber
        // 但因為會有 duplicated ，所以要存的是 index，什麼value 對應 greaNumber 的 index
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return result;


//        if (nums == null || nums.length == 0) return new int[0];
//        Deque<Integer> stack = new LinkedList<>();
//        int[] res = new int[nums.length];
//        for (int i = 2 * nums.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
//                stack.pop();
//            }
//            res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
//            stack.push(i % nums.length);
//        }
//        return res;
    }

    public static void printArray(int[] num) {
        System.out.print("i: ");
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
