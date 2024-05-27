import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 30-8.https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem?isFullScreen=true
 *
 * @author AaronWU
 * @created 創建時間：2024/05/27 14:32:37
 * @since JDK8.0
 */

/**
 * Sample Input
 *
 * 3
 * sam 99912222
 * tom 11122222
 * harry 12299933
 * sam
 * edward
 * harry
 */
public class Dictionaries_And_Maps {
    public static void main(String[] argh) {
        Map<String, Integer> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            map.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.next();
            if (map.containsKey(s)) {
                System.out.println(s + "=" + map.get(s));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}