package array;

/**
 * 1071.https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/19 11:39:37
 * @since JDK8.0
 */
public class Greatest_Common_Divisor_Of_Strings_1071 {
    public static void main(String[] args) {
        Greatest_Common_Divisor_Of_Strings_1071_Solution s = new Greatest_Common_Divisor_Of_Strings_1071_Solution();
        String gcd1 = s.gcdOfStrings("ABAB", "ABABAB");
        System.out.println("gcd1: " + gcd1);
        String gcd2 = s.gcdOfStrings("ABABABAB", "ABAB");
        System.out.println("gcd2: " + gcd2);
        String gcd3 = s.gcdOfStrings("leet", "code");
        System.out.println("gcd3: " + gcd3);
        String gcd4 = s.gcdOfStrings("ABCDEF", "ABC");
        System.out.println("gcd4: " + gcd4);
        String gcd5 = s.gcdOfStrings("ABCABCABC", "ABCAAA");
        System.out.println("gcd5: " + gcd5);
    }
}

class Greatest_Common_Divisor_Of_Strings_1071_Solution {
    // ------------------ test1 ------------------
    /**
     * <ul>設計思維</ul>
     * 起初想說先判斷第一位是不是一樣，如果不是就一定不能整除(這樣後面會有問題)
     * 接著用 str1、str2 長度去找出最大公因數最長的長度
     * 但這樣做法會失敗 String gcd4 = s.gcdOfStrings("ABCDEF", "ABC");
     * 這樣會找出 ABC 這答案
     */
//    public String gcdOfStrings(String str1, String str2) {
//        // check the first char
//        if (str1.charAt(0) != str2.charAt(0)) return "";
//        int end = gcd(str1.length(), str2.length());
//        return str2.substring(0, end);
//    }
//
//    public int gcd(int num1, int num2) {
//        if (num2 == 0) return num1;
//        return gcd(num2, num1 % num2);
//    }

    // ------------------ test2 ------------------

    /**
     * Runtime: 0 ms, Beats 100.00%
     * <ul>設計思維</ul>
     * gcd(a, b) if(a == b) return a
     * gcd(a, b) if(a > b) gcd(a-b, b)
     * gcd(a, b) if(a < b) gcd(a, b-a)
     * a - b 就是從 0 開始把 兩邊有的扣掉
     * ABABAB, ABAB
     * => AB, ABAB
     * => AB, AB => AB
     */
    public String gcdOfStrings(String str1, String str2) {
        int index = 0;
        if (str1.length() > str2.length()) {
            // 提早前檢查是否裡面有不一樣的字，但如果拿掉也可以正常運作
            for (int i = 0; i < str2.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) index++;
                else break;
            }
            return index == 0 ? "" : gcdOfStrings(str1.substring(index, str1.length()), str2);
        } else if (str1.length() < str2.length()) {
            // 提早前檢查是否裡面有不一樣的字，但如果拿掉也可以正常運作
            for (int i = 0; i < str1.length(); i++) {
                if (str2.charAt(i) == str1.charAt(i)) index++;
                else break;
            }
            return index == 0 ? "" : gcdOfStrings(str1, str2.substring(index, str2.length()));
        } else if (str1.equals(str2)) {
            return str1;
        }
        return "";
    }

    // ------------------ test3 ------------------

    /**
     * Runtime: 0 ms, Beats 100.00%
     * <ul>設計思維</ul>
     * 網路大神補充
     * 因為是找最大公因數，以字串來說 s = t + t + ... t
     * 所以 s + t = t + s => (t+t+t...) + t = t + (t+t+t...)
     * 等於說把 test1 判斷首字，改成更全面的檢查
     * <p>
     * 如果今天 gcd(48, 18) 會比 gcd(18, 48) 少做一次，所以在 end 要判斷大小，加速他取得內容
     */
//    public String gcdOfStrings(String str1, String str2) {
//        if (!(str1 + str2).equals(str2 + str1)) return "";
//        int end = str1.length() > str2.length() ? gcd(str1.length(), str2.length()) : gcd(str2.length(), str1.length());
//        return str2.substring(0, end);
//    }
//
//    public int gcd(int num1, int num2) {
//        if (num2 == 0) return num1;
//        return gcd(num2, num1 % num2);
//    }
}