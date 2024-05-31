package slidingwindow;

/**
 * 1456.https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/25 14:30:52
 * @since JDK8.0
 */
public class Maximum_Number_Of_Vowels_In_A_Substring_Of_Given_Length_1456 {
    public static void main(String[] args) {
        Maximum_Number_Of_Vowels_In_A_Substring_Of_Given_Length_1456 r = new Maximum_Number_Of_Vowels_In_A_Substring_Of_Given_Length_1456();
        Maximum_Number_Of_Vowels_In_A_Substring_Of_Given_Length_1456.Solution solution = r.new Solution();

        String s = "abciiidef";
        int k = 3;
//        String s = "bbbbbb";
//        int k = 3;
        int result = solution.maxVowels(s, k);
        System.out.println("reuslt:" + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 1. 建立一個 aeiou 等於 1，提供之後加減使用
         * 2. 當加到 k 數後，開始比大小
         */
//        public int maxVowels(String s, int k) {
//            int[] vowels = new int[128];
//            vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = 1;
//
//            int windowStart = 0, windowCountTmp = 0, windowCount = 0;
//            char[] chars = s.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                windowCountTmp += vowels[chars[i]];
//                if (i >= k - 1) {
//                    windowCount = Math.max(windowCountTmp, windowCount);
//                    windowCountTmp -= vowels[chars[windowStart++]];
//                }
//            }
//            return windowCount;
//        }

        /**
         * test2
         * 解法:
         * 他先把前面 k 算完
         * 接著再往後去算，很酷的地方在
         * current += alphabet[str[j++]];
         * current -= alphabet[str[i++]];
         * <p>
         * 這邊先去加上右邊，再減去左邊
         */
//        public int maxVowels(String s, int k) {
//            int max = 0;
//            int current = 0;
//            int i = 0;
//            int j = 0;
//            byte[] alphabet = new byte[123];
//            byte[] str = new byte[s.length()];
//            s.getBytes(0, s.length(), str, 0);
//            alphabet['a'] = alphabet['e'] = alphabet['u'] = alphabet['i'] = alphabet['o'] = 1;
//            while (j < k) {
//                max += alphabet[str[j++]];
//            }
//
//            current = max;
//            while (j < str.length) {
//                current += alphabet[str[j++]];
//                current -= alphabet[str[i++]];
//                if (max < current)
//                    max = current;
//            }
//
//            return max;
//        }
        public int maxVowels(String s, int k) {
            int[] vowels = new int[123];// 0-122
            vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = 1;
            int start = 0, sum = 0, count = 0;
            char[] chars = s.toCharArray();

            for (int end = 0; end < chars.length; end++) {
                sum += vowels[chars[end]];
                if (end - start + 1 == k) {
                    count = Math.max(count, sum);
                    sum -= vowels[chars[start++]];
                }
            }
            return count;
        }
    }
}
