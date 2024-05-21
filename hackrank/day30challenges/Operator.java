import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 30-3.https://www.hackerrank.com/challenges/30-operators/problem?isFullScreen=true
 *
 * @author AaronWU
 * @created 創建時間：2024/05/21 16:58:16
 * @since JDK8.0
 */

/**
 * 測資:
 * 12
 * 20
 * 8
 *
 * 10.25
 * 17
 * 5
 */
public class Operator {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        // Write your code here
        double d = Math.round(meal_cost + (meal_cost * tip_percent * 0.01) + (meal_cost * tax_percent * 0.01));
        System.out.println((int) (d));
    }

}