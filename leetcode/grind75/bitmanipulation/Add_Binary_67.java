package bitmanipulation;

import java.math.BigInteger;

/**
 * 67.https://leetcode.com/problems/add-binary/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/10 15:09:53
 * @since JDK8.0
 */
public class Add_Binary_67 {
    public static void main(String[] args) {
        Add_Binary_67 ss = new Add_Binary_67();
        Add_Binary_67.Solution solution = ss.new Solution();
        String a = "11";
        String b = "1";
//        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String result = solution.addBinary(a, b);
        System.out.print(result);
    }

    class Solution {
        /**
         * Runtime: 6 ms, Beats 14.84%
         */
//        public String addBinary(String a, String b) {
//            BigInteger aBigInt = new BigInteger(a, 2);
//            BigInteger bBigInt = new BigInteger(b, 2);
//
//            return aBigInt.add(bBigInt).toString(2);
//        }

        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();

            int i = a.length()-1;
            int j = b.length()-1;
            int carry = 0;

            while(i>=0 || j>=0){
                int sum = carry;
                if(i>=0)
                    sum +=a.charAt(i--) - '0';
                if(j>=0)
                    sum +=b.charAt(j--) - '0';
                result.append(sum%2);
                carry = sum/2;
            }

            if(carry!=0){
                result.append(carry);
            }
            return result.reverse().toString();
        }
    }
}
