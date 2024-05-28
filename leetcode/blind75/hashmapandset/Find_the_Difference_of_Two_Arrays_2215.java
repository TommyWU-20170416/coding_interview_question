package hashmapandset;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_the_Difference_of_Two_Arrays_2215 {
    public static void main(String[] args) {
        Find_the_Difference_of_Two_Arrays_2215 s = new Find_the_Difference_of_Two_Arrays_2215();
        Find_the_Difference_of_Two_Arrays_2215.Solution solution = s.new Solution();

        int[] nums1 = {1, 2, 3, 3}, nums2 = {2, 4, 6, 6}; // return [[1,3],[4,6]]

        List<List<Integer>> result = solution.findDifference(nums1, nums2);
        for (List<Integer> innerList : result) {
            for (Integer number : innerList) {
                System.out.print(number + " ");
            }
            System.out.println(); // 打印完一個內部列表後換行
        }
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 1. 把 nums1 存進 set 去除重複。nums2 比照辦理
         * 2. 把 set1 當作遍歷，如果不在 set2 存在，則存入到 list1 中。nums2 比照辦理
         */
//        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//            List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
//            Set<Integer> set1 = new HashSet(), set2 = new HashSet();
//            for (int i : nums1) {
//                set1.add(i);
//            }
//            for (int j : nums2) {
//                set2.add(j);
//            }
//
//            for (int i : set1) {
//                if (!set2.contains(i)) {
//                    list1.add(i);
//                }
//            }
//            for (int j : set2) {
//                if (!set1.contains(j)) {
//                    list2.add(j);
//                }
//            }
//
//            List<List<Integer>> result = new ArrayList<>();
//            result.add(list1);
//            result.add(list2);
//
//            return result;
//        }

        /**
         * test2
         * 解法:
         * 跟 test1 方法一樣，只是在排除的時候
         * 使用 public ArrayList(Collection<? extends E> c)
         * 意思就是把 set1 的元素放進去 list1
         * 接著使用 boolean removeAll(Collection<?> c)
         * 把 set2 有的元素都移除
         */
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
            for (int i : nums1) {
                set1.add(i);
            }
            for (int i : nums2) {
                set2.add(i);
            }
            List<Integer> list1 = new ArrayList<>(set1);
            list1.removeAll(set2);
            List<Integer> list2 = new ArrayList<>(set2);
            list2.removeAll(set1);

            List<List<Integer>> result = new ArrayList<>();
            result.add(list1);
            result.add(list2);
            return result;
        }

    }
}
