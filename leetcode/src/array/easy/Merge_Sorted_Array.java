package array.easy;

import java.util.Arrays;

/**
 * @author AaronWU
 * @version 創建時間：2020年1月21日 下午5:48:08
 * @since JDK8.0
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * nums1.length == m + n
 * nums2.length == n
 */
public class Merge_Sorted_Array {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(arr1, m, arr2, n);
    }

    /**
     * 重點在於說，如何調整已經固定長度的 array ，一開始想說用 arraylist 但是卡在說還要把 arraylist 存回 array 耗時
     * 新的想法就是直接將後面多的調整成 arr2 再去做排序。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];/* nums1[6] = nums2[0] */
        }
        Arrays.sort(nums1);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
