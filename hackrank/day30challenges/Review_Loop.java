import java.util.Scanner;

/**
 * 30-6.https://www.hackerrank.com/challenges/30-review-loop/problem?isFullScreen=true
 *
 * @author AaronWU
 * @created 創建時間：2024/05/24 14:09:45
 * @since JDK8.0
 */

/**
 * Sample Input *
 * 2
 * Hacker
 * Rank
 */
public class Review_Loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStrings = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfStrings; i++) {
            String result = parseStringFromOddAndEven(sc.nextLine());
            System.out.println(result);
        }
        sc.close();
    }

    private static String parseStringFromOddAndEven(String str) {
        char[] strOdd = new char[str.length() / 2];
        char[] strEven = new char[str.length() - strOdd.length];
        int odd = 0, even = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                strEven[even++] = str.charAt(i);
            } else {
                strOdd[odd++] = str.charAt(i);
            }
        }
        return new String(strEven) + " " + new String(strOdd);
    }
}
