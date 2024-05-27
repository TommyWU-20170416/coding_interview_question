import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 30-7.https://www.hackerrank.com/challenges/30-arrays/problem?isFullScreen=true
 *
 * @author AaronWU
 * @created 創建時間：2024/05/27 14:26:20
 * @since JDK8.0
 */
public class Arrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // \\s 代表任何空白字符（包括空格、製表符、換行符等）
        // + 表示匹配前面的模式一次或多次。
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(arr.get(i));
            } else {
                System.out.print(arr.get(i) + " ");
            }

        }

        bufferedReader.close();
    }
}
