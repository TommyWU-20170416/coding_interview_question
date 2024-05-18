package nextgreaterelement;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496.https://leetcode.com/problems/next-greater-element-i/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月23日 下午5:14:27
 * @since JDK8.0
 * You are given two integer arrays nums1 and nums2 both of unique
 * elements, where nums1 is a subset of nums2.
 * <p>
 * Find all the next greater numbers for nums1's elements in the
 * corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater
 * number to its right in nums2. If it does not exist, return -1 for this
 * number.
 * Example 1:
 * <p>
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater
 * number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the
 * second array is 3.
 * For number 2 in the first array, there is no next greater number for
 * it in the second array, so output -1.
 */
public class Next_Greater_Element_I {
    //    private static int[] nums1 = {4, 5}, nums2 = {6, 2, 1, 5, 4};
//    private static int[] nums1 = {4, 1, 3, 5}, nums2 = {1, 3, 4, 2, 5};
//	private static int[] nums1 = { 1, 3, 5, 2, 4	 }, nums2 = { 6, 5, 4, 3, 2, 1, 7 };
    private static int[] nums1 = {5, 4, 3, 2, 1}, nums2 = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        Next_Greater_Element_I test = new Next_Greater_Element_I();
        int[] num_result = test.nextGreaterElement1(nums1, nums2);
        printArray(num_result);
    }

    /**
     * Runtime 4 ms
     * Memory 38.9 MB
     * time:O(n+m) space:O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        // 把有 greatNumber 的放進 nextGreater
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            // stack 若此時存的是 (0, 1, 2) num 是 5 則 nextGreater 會儲存 (0, 5) (1, 5) (2, 5)
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return result;

//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//		for (int i = 0; i < nums1.length; i++) {
//			map.put(nums1[i], i);	/* [num, index] */
//		}
//		int[] result = new int[nums1.length];
//		Arrays.fill(result, -1);	/* 初始化陣列為 -1 */
//		Stack<Integer> stack = new Stack<Integer>();
//		for (int j = 0; j < nums2.length; j++) {
//			while (!stack.isEmpty() && stack.peek() < nums2[j]) {
//				int cur = stack.peek();
//				stack.pop();
//
//				/* 如果有包含就代表，存在於nums1 */
//				if (map.containsKey(cur)) {
//					result[map.get(cur)] = nums2[j];
//				}
//			}
//			stack.push(nums2[j]);
//		}
//
//		return result;
    }

    /**
     * brute force
     * time:O(m*n) space:O(1)
     * Runtime: 4 ms, faster than 52.32%
     * Memory Usage: 39.1 MB, less than 47.34%
     *
     * @param nums1
     * @param nums2
     * @return nums1 做for，當num2有找到的時候，就將其位置記下來(target_index)
     * 下一個迴圈就會進到 if (target_index > -1)，在這裡面判斷是否有找到大於的數
     * 若有的話就跳離結束，若無的話繼續找，找到最後沒有的話就給 -1
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] num_result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int count = 0, target_index = -1;
            while (count < nums2.length) {
                /* 判斷有無找到，找到之後找比他大的數字 */
                if (target_index > -1) {
                    if (nums2[count] > nums1[i]) {
                        num_result[i] = nums2[count];
                        break;
                    }
                }
                if (nums1[i] == nums2[count]) {
                    target_index = count;
                    if (target_index == nums2.length - 1) {
                        num_result[i] = -1;
                        break;
                    }
                }
                count++;
            }
            /* 找到最後沒有就給-1 */
            if (num_result[i] == 0) {
                num_result[i] = -1;
            }
        }
        return num_result;
    }

    public static void printArray(int[] num) {
        System.out.print("i: ");
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}