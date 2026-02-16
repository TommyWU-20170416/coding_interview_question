package algorithms;

import java.util.Arrays;

/**
 * https://hackmd.io/hY-bzqreSC2vBnKyrtvq7Q
 */
public class LPS {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'a', 'b', 'a', 'b'};
        int[] result = longestPrefixSuffix(arr);
        System.out.println(Arrays.toString(result)); // [0, 0, 1, 2, 3, 4]

        char[] arr1 = {'a', 'b', 'a', 'b', 'a', 'c', 'a'};
        int[] result1 = longestPrefixSuffix(arr1);
        System.out.println(Arrays.toString(result1)); // [0, 0, 1, 2, 3, 0, 1]

        char[] arr2 = {'a', 'a', 'b', 'a', 'a', 'a', 'c'};
        int[] result2 = longestPrefixSuffix(arr2);
        System.out.println(Arrays.toString(result2)); // [0, 1, 0, 1, 2, 2, 0]
    }

    /**
     * Longest Proper Prefix which is also Suffix
     */
    private static int[] longestPrefixSuffix(char[] arr) {
        int[] lps = new int[arr.length];

        if (arr.length == 0) {
            return lps;
        }

        lps[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            int len = lps[i - 1];

            if (arr[len] == arr[i]) {
                lps[i] = len + 1;
            } else {
                while (len > 0) {
                    len = lps[len - 1];
                    if (arr[len] == arr[i]) {
                        lps[i] = len + 1;
                        break; // 設定完要跳出迴圈，否則會繼續往前找
                    }
                }
            }
        }

        return lps;
    }
}
