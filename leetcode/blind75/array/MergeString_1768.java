package array;

/**
 * 1768.https://leetcode.com/problems/merge-strings-alternately/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/18 18:15:59
 * @since JDK8.0
 */
public class MergeString_1768 {
    public static void main(String[] args) {
        MergeString_1768 mergeString = new MergeString_1768();
        String result = mergeString.mergeAlternately("word1", "w");
        System.out.print(result);
    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * <ul>設計思維</ul>
     * 因為要調閱字串，當下想到用 char，所以就建立 char[] result，而且這樣省空間
     */
//    public String mergeAlternately(String word1, String word2) {
//        int index = 0, index1 = 0, index2 = 0;
//        int len1 = word1.length(), len2 = word2.length();
//        char[] result = new char[len1 + len2];
//        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
//
//        while (index1 < len1 && index2 < len2) {
//            result[index++] = chars1[index1++];
//            result[index++] = chars2[index2++];
//        }
//
//        while (index1 < len1) {
//            result[index++] = chars1[index1++];
//        }
//        while (index2 < len2) {
//            result[index++] = chars2[index2++];
//        }
//        return new String(result);
//    }

    /**
     * Runtime: 0 ms, Beats 100.00%
     * 改用 StringBuilder 可以減少 index 使用
     */
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < len1 && i < len2) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }

        while (i < len1) {
            sb.append(word1.charAt(i));
            i++;
        }

        while (i < len2) {
            sb.append(word2.charAt(i));
            i++;
        }

        return sb.toString();
    }
}