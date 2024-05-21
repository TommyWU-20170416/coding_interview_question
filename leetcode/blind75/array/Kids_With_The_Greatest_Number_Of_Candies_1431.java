package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431.https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/05/21 17:12:49
 * @since JDK8.0
 * <p>
 * 找出 int[] candies 內加上 extraCandies 是否就是最多糖果的
 * 最後回傳 boolean list
 */
public class Kids_With_The_Greatest_Number_Of_Candies_1431 {
    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies_1431_Solution s = new KidsWithTheGreatestNumberOfCandies_1431_Solution();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        s.kidsWithCandies(candies, extraCandies);
    }
}

class KidsWithTheGreatestNumberOfCandies_1431_Solution {

    // test1
    // 使用方法: 暴力解 這樣會有兩倍的 n 因為要去尋找最大值，沒看到有更好的解法
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find the biggest num
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i]) max = candies[i];
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}