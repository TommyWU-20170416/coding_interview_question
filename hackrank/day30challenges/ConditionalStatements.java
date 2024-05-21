import java.io.*;

/**
 * 30-3.https://www.hackerrank.com/challenges/30-conditional-statements/problem?isFullScreen=true
 *
 * @author AaronWU
 * @created 創建時間：2024/05/21 17:02:33
 * @since JDK8.0
 *
 * Given an integer, , perform the following conditional actions:
 *
 * If  is odd, print Weird
 * If  is even and in the inclusive range of  to , print Not Weird
 * If  is even and in the inclusive range of  to , print Weird
 * If  is even and greater than , print Not Weird
 */

public class ConditionalStatements {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());

        if (N % 2 == 1) {
            System.out.println("Weird");
        } else {
            if (2 <= N && N <= 5) {
                System.out.println("Not Weird");
            } else if (6 <= N && N <= 20) {
                System.out.println("Weird");
            } else if (20 < N) {
                System.out.println("Not Weird");
            }
        }

        bufferedReader.close();
    }
}
