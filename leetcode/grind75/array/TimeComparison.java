package array;

import java.util.Random;

import java.util.Random;

public class TimeComparison {

    // 第一段程式碼
    public static int[] twoSumMethod1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // 未找到
    }

    // 第二段程式碼
    public static int[] twoSumMethod2(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] + nums[j - i] == target) {
                    return new int[]{j, j - i};
                }
            }
        }
        return null; // 未找到
    }

    // 測試方法
    public static void main(String[] args) {
        int[] nums = generateRandomArray(100000, 100000);
        int target = 500;

        // 重複測試次數
        int iterations = 100;
        long totalDuration1 = 0;
        long totalDuration2 = 0;

        for (int k = 0; k < iterations; k++) {
            // 測試第一段程式碼
            long startTime1 = System.nanoTime();
            twoSumMethod1(nums, target);
            long endTime1 = System.nanoTime();
            totalDuration1 += (endTime1 - startTime1);

            // 測試第二段程式碼
            long startTime2 = System.nanoTime();
            twoSumMethod2(nums, target);
            long endTime2 = System.nanoTime();
            totalDuration2 += (endTime2 - startTime2);
        }

        long averageDuration1 = totalDuration1 / iterations;
        long averageDuration2 = totalDuration2 / iterations;

        System.out.println("Method 1 average duration: " + averageDuration1 + " ns");
        System.out.println("Method 2 average duration: " + averageDuration2 + " ns");
    }

    // 生成隨機數組的方法
    private static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(bound);
        }
        return nums;
    }
}
