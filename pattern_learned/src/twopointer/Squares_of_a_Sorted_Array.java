package twopointer;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * @author AaronWU
 * @version 創建時間：2021年5月8日 下午2:24:33
 * @since JDK8.0
 * <p>
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
public class Squares_of_a_Sorted_Array {
    private static int[] nums = {-4, -3, 1, 2, 10};

    public static void main(String[] args) {
        Squares_of_a_Sorted_Array test = new Squares_of_a_Sorted_Array();
        printArray(test.twoPoint_1(nums));
        printArray(test.twoPoint_2(nums));

        /* test.exchange(nums); 不可使用 */

    }

    /**
     * 如果使用比大小，遇到就交換，這樣會有一個問題[-5,-3,-2,-1]
     * 當我比第一次變成 -> [-1,-3,-2,-5]
     * 第二次變成[-1,-3,-2,-5]
     * 第三次變成[-1,-3,-2,-5]
     * 交換的兩者無法知道交換後與其他的比較
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            System.out.println(nums[left]);
            System.out.println(nums[right]);
            if (Math.pow(nums[left], 2) > Math.pow(nums[right], 2)) {
                int tmp = nums[right];
                nums[right] = (int) Math.pow(nums[left], 2);
                nums[left] = tmp;

                for (int i : nums) {
                    System.out.print(i + " ");
                }

                right--;
            } else {
                nums[right] = (int) Math.pow(nums[right], 2);
                right--;
            }
        }
        return nums;
    }

    /**
     * 優化 twoPoint_1 使用 Math.abs方式做比較
     *
     * @param nums
     * @return Runtime: 1 ms, faster than 100.00% of Java online submissions for
     * Squares of a Sorted Array.
     * Memory Usage: 40.9 MB, less than 42.13% of Java online submissions
     * for Squares of a Sorted Array.
     */
    public int[] twoPoint_2(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0, right = nums.length - 1, point = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                answer[point--] = nums[left] * nums[left];
                left++;
            } else {
                answer[point--] = nums[right] * nums[right];
                right--;
            }
        }
        return answer;
    }

    /**
     * 使用 Two Point 兩者平方後比較大小，大的放右邊
     *
     * @param nums
     * @return Runtime: 2 ms, faster than 51.75% of Java online submissions for
     * Squares of a Sorted Array.
     * Memory Usage: 40.6 MB, less than 79.74% of Java online submissions
     * for Squares of a Sorted Array.
     */
    public int[] twoPoint_1(int[] nums) {
        int[] result = new int[nums.length];
        int index1 = 0, index2 = nums.length - 1;
        while (index1 < index2) {
            int numPow1 = (int) Math.pow(nums[index1], 2);
            int numPow2 = (int) Math.pow(nums[index2], 2);
            result[index2] = (numPow1 < numPow2) ? numPow2 : numPow1;
            if (numPow1 < numPow2) index2--;
            else index1++;
        }
        return new int[2];


//		int[] answer = new int[nums.length];
//		int left = 0, right = nums.length - 1, point = nums.length - 1;
//		while (left <= right) {
//			int right_num = (int) Math.pow(nums[right], 2);
//			int left_num = (int) Math.pow(nums[left], 2);
//			if (left_num > right_num) {
//				answer[point--] = left_num;
//				left++;
//			} else {
//				answer[point--] = right_num;
//				right--;
//			}
//		}
//		return answer;
    }

    /**
     * print Array
     *
     * @param nums
     */
    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
