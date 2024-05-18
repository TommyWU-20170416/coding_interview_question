package array.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * @author AaronWU
 * @version 創建時間：2020年1月21日 下午5:48:08
 * @since JDK8.0
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * <p>
 */
public class Intersection_of_Two_Arrays {

    public static List<String> list = new ArrayList<String>();
    public static Set<String> set = new HashSet<>();
    public static Set<String> sortset = new LinkedHashSet<>();

    public static void main(String[] args) {
//		int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};			/* ex1 */
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};    /* ex2 */
        int[] nums = intersection(nums1, nums2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
		/* method 1 ���� for �s�� set
		Set<Integer> arr = new HashSet<Integer>();
		for(int i = 0; i < nums2.length; i++) {
			for(int j = 0; j < nums1.length; j++) {
				if(nums1[j] == nums2[i]) {
					arr.add(nums2[i]);
				}
			}
		}*/

        /* method 2 ���B�z nums1, nums2 to set �A����� */
        Set<Integer> arr = new HashSet<Integer>();
        Set<Integer> arr1 = new HashSet<Integer>();
        Set<Integer> arr2 = new HashSet<Integer>();

        for (int a : nums1) {
            if (!arr1.contains(a)) {
                arr1.add(a);
            }
        }
        for (int a : nums2) {
            if (!arr2.contains(a)) {
                arr2.add(a);
            }
        }

        if (arr1.size() > arr2.size()) {
            return compareTwoSet(arr1, arr2);
        } else {
            return compareTwoSet(arr2, arr1);
        }


        /* change ArrayList to array */
		/* method 1 
		Integer[] arr1 = new Integer[arr.size()]; 
        arr1 = arr.toArray(arr1); */
        
		/* method 2 
		Integer[] arr1 = new Integer[arr.size()]; 
        for (int i = 0; i < arr.size(); i++) {
            arr1[i] = arr.get(i);
        }*/
        
		/* method 3 
		int [] arr1 = arr.stream().mapToInt(i->i).toArray();*/


//		return arr.stream().mapToInt(i->i).toArray();
    }

    public static int[] compareTwoSet(Set<Integer> set1, Set<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            if (set2.contains(s)) output[idx++] = s;
        }
        return Arrays.copyOf(output, idx);
    }
}
