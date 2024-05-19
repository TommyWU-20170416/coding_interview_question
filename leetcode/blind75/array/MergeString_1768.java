package array;

/**
 * 1768.https://leetcode.com/problems/merge-strings-alternately/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/18 18:15:59
 * @since JDK8.0
 */
public class MergeString_1768 {

    // ------------------ test1 ------------------
    /**
     * <ul>設計思維</ul>
     * 若要方便 Append 字串，可使用 stringbuilder
     */
//    public String mergeAlternately(String word1, String word2) {
//        StringBuilder result = new StringBuilder();
//        int i = 0;
//        while (true) {
//            if (i == (word1.length() + word2.length())) break;
//            if (i < word1.length()) {
//                result.append(word1.charAt(i));
//            }
//            if (i < word2.length()) {
//                result.append(word2.charAt(i));
//            }
//            i++;
//        }
//        return result.toString();
//    }

    // ------------------ test2 ------------------
    /**
     * <ul>設計思維</ul>
     * 因為要調閱字串，當下想到用 char，所以就建立 char[] result，而且這樣省空間
     */
    public String mergeAlternately(String word1, String word2) {
        char[] result = new char[word1.length() + word2.length()];
        int index = 0;
        for (int i = 0; i < word1.length() + word2.length(); i++) {
            if (i < word1.length()) {
                result[index] = word1.charAt(i);
                index++;
            }
            if (i < word2.length()) {
                result[index] = word2.charAt(i);
                index++;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        MergeString_1768 mergeString = new MergeString_1768();
        String result = mergeString.mergeAlternately("word1", "word2");
        System.out.print(result);
    }
}