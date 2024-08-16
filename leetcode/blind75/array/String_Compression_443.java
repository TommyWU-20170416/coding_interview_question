package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * 443.https://leetcode.com/problems/string-compression/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/23 22:01:12
 * @since JDK8.0
 */

/**
 * input array 會是連續重複字串，不會跳
 * return 除了 length，這個 length 會是從 input array 來
 * 所以要改動 input array
 */
public class String_Compression_443 {
    public static void main(String[] args) {
        String_Compression_443 r = new String_Compression_443();
        String_Compression_443.Solution s = r.new Solution();

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'}; // Return 6
//        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}; // Return 4
//        char[] chars = {'a', 'a', 'a', 'b', 'b', 'a', 'a'}; // Return 6   ['a','3','b','2','a','2']

        int result = s.compress(chars);
        System.out.println("reuslt:" + result);
        for (int i = 0; i < result; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    class Solution {
        /**
         * Runtime: 1 ms, Beats 99.58%
         * test1
         * 解說:
         * 動作拆成三部分
         * 1. 寫入 char
         * 2. 計算重複次數
         * 3. 回寫到 input array
         * <p>
         * !! 注意 !!
         * for 迴圈不用 i++，因為再計算重複就會往前進
         * 若重複超過個位數或十位數，用 for 去放入 input array
         * 有 ++ 的地方都要思考為啥這樣寫
         * 像是
         * chars[start++] = chars[i - 1];   => 把字母放進去後，往後前進
         * chars[start++] = c;              => 把數量放進去後，往後前進
         */
        public int compress(char[] chars) {
            if (chars.length == 1) return 1;
            int start = 0;
            for (int i = 0; i < chars.length; ) {
                char letter = chars[i];
                int count = 0;
                while (true) {
                    if (i < chars.length && chars[i] == letter) {
                        i++;
                        count++;
                    } else break;
                }
                chars[start++] = chars[i - 1];
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[start++] = c;
                    }
                }
            }
            return start;
        }
    }
}
