package array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/
 *
 * @author AaronWU
 * @version 創建時間：2021年4月30日 下午4:58:58
 * @since JDK8.0
 * <p>
 * 找出最長的子陣列，其中0與1的個數要相同
 * Input: nums = [0,1]
 * Output: 2
 * Input: nums = [0,1,0]
 * Output: 2
 * Input: nums = [0,0,1,0,0,0,1,1]
 * Output: 6
 * Input: nums = [0,1,1,0,1,1,1,0]
 * Output: 4
 */
public class Contiguous_Array {
    /*
     * 兩個差異點在於儲存的時候，hashmap需要填入key value但是array只需要覆寫值*/
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1, 1, 1};
        System.out.println(findMaxLength(nums));
        System.out.println(findMaxLength1(nums));

    }

    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int length_subArray = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);/* sum=0, index=-1 */

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(sum)) {
                length_subArray = Math.max(length_subArray, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return length_subArray;
    }


    public static int findMaxLength1(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int length_subArray = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {/* 陣列裡面會放 index跟長度，-1 是因為index從0開始算 */
                length_subArray = Math.max(length_subArray,
                        i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return length_subArray;
    }
}/* {0,0,1,0}; */
