package bitmanipulation;

public class Minimum_Flips_To_Make_A_OR_B_Equal_To_C_1318 {
    public static void main(String[] args) {
        Minimum_Flips_To_Make_A_OR_B_Equal_To_C_1318 s = new Minimum_Flips_To_Make_A_OR_B_Equal_To_C_1318();
        Minimum_Flips_To_Make_A_OR_B_Equal_To_C_1318.Solution solution = s.new Solution();
//        int a = 2, b = 6, c = 5;
        int a = 8, b = 3, c = 5;
        int result = solution.minFlips(a, b, c);

        System.out.println("result: " + result);
    }

    class Solution {
        /**
         * test1
         * 解法:
         * 把每一個數字最後的數字取出來，並拿去做比對
         */
        public int AminFlips(int a, int b, int c) {
            int count = 0;
            while (a > 0 || b > 0 || c > 0) {
                int a_f = a & 1;
                int b_f = b & 1;
                int c_f = c & 1;

                if (c_f == 1 && (a_f | b_f) != 1) count++;
                else if (c_f == 0 && (a_f | b_f) == 1) {
                    count += a_f + b_f;
                }

                a >>= 1;
                b >>= 1;
                c >>= 1;
            }
            return count;
        }

        /**
         * test2
         * 優化
         * 使用另一種方式去遍歷整個數
         *
         * EX: (a & (1 << i)) 這意思是從最後一位往前找有 1 的
         * 0101 & ( 0001 << 0) = 0101 & 0001 = 0001
         * 0101 & ( 0001 << 1) = 0101 & 0010 = 0000
         * 0101 & ( 0001 << 2) = 0101 & 0100 = 0100
         */
        public int minFlips(int a, int b, int c) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                int flipAB = 0;
                if ((a & (1 << i)) > 0) flipAB++;
                if ((b & (1 << i)) > 0) flipAB++;

                int c_f = (c & (1 << i)) > 0 ? 1 : 0;
                if (c_f == 0) count += flipAB;
                else if (c_f == 1 && flipAB == 0) count++;
            }
            return count;
        }
    }
}
