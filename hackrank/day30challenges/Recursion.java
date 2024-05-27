/**
 * 30-9.https://www.hackerrank.com/challenges/30-recursion/problem?isFullScreen=true
 *
 * @author AaronWU
 * @created 創建時間：2024/05/27 14:36:54
 * @since JDK8.0
 */

import java.io.*;

/**
 * Sample Input
 * <p>
 * 3
 */
public class Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.factorial(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Result {

        /*
         * Complete the 'factorial' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER n as parameter.
         */

        public static int factorial(int n) {
            // Write your code here
            if (n == 1) return 1;

            return n * factorial(n - 1);
        }

    }
}
