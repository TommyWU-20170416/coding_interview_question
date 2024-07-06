import java.util.Arrays;

public class CopyArray {
    static final int NUM_RUNS = 1000; // 运行次数
    static final int ARRAY_SIZE = 1000; // 数组长度

    public static void main(String[] args) {

        /**
         * 一維陣列
         */
        // 使用 System.arraycopy
        runTest("System.arraycopy", (src, dest) -> {
            System.arraycopy(src, 0, dest, 0, src.length);
        });

        // 使用 Arrays.copyOf
        runTest("Arrays.copyOf", (src, dest) -> {
            int[] result = Arrays.copyOf(src, src.length);
        });

        // 使用 clone 方法
        runTest("clone", (src, dest) -> {
            int[] result = src.clone();
        });

        // 使用 Arrays.copyOfRange
        runTest("Arrays.copyOfRange", (src, dest) -> {
            int[] result = Arrays.copyOfRange(src, 0, src.length);
        });

        // 使用for
        runTest("For", (src, dest) -> {
            for (int i = 0; i < src.length; i++) {
                dest[i] = src[i];
            }
        });

        /**
         * 二維陣列
         */
        runTest2D("System.arraycopy", (src, dest) -> {
            for (int i = 0; i < src.length; i++) {
                System.arraycopy(src[i], 0, dest[i], 0, src[i].length);
            }

        });
        // 使用 Arrays.copyOf
        runTest2D("Arrays.copyOf", (src, dest) -> {
            for (int i = 0; i < src.length; i++) {
                dest[i] = Arrays.copyOf(src[i], src[i].length);
            }
        });

        // 使用 clone 方法
        runTest2D("clone", (src, dest) -> {
            for (int i = 0; i < src.length; i++) {
                dest[i] = src[i].clone();
            }
        });

        // 使用 Arrays.copyOfRange
        runTest2D("Arrays.copyOfRange", (src, dest) -> {
            for (int i = 0; i < src.length; i++) {
                dest[i] = Arrays.copyOfRange(src[i], 0, src[i].length);
            }
        });

        // 使用手動循環 for
        runTest2D("For", (src, dest) -> {
            for (int i = 0; i < src.length; i++) {
                for (int j = 0; j < src[i].length; j++) {
                    dest[i][j] = src[i][j];
                }
            }
        });
    }

    private static void runTest(String methodName, ArrayCopyMethod method) {
        long totalTime = 0;
        for (int i = 0; i < NUM_RUNS; i++) {
            int[] src = new int[ARRAY_SIZE];
            for (int j = 0; j < ARRAY_SIZE; j++) {
                src[j] = j;
            }
            int[] dest = new int[ARRAY_SIZE];

            long startTime = System.nanoTime();
            method.copy(src, dest);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }
        long avgTime = totalTime / NUM_RUNS;
        System.out.printf("method: %-20s operation took %8d nanoseconds on average.%n", methodName, avgTime);

    }

    private static void runTest2D(String methodName, ArrayCopyMethod2D method) {
        long totalTime = 0;
        for (int i = 0; i < NUM_RUNS; i++) {
            int[][] src = new int[ARRAY_SIZE][ARRAY_SIZE];
            for (int j = 0; j < ARRAY_SIZE; j++) {
                for (int k = 0; k < ARRAY_SIZE; k++) {
                    src[j][k] = j * ARRAY_SIZE + k;
                }
            }
            int[][] dest = new int[ARRAY_SIZE][ARRAY_SIZE];

            long startTime = System.nanoTime();
            method.copy(src, dest);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }
        long avgTime = totalTime / NUM_RUNS;
        System.out.printf("method: %-20s operation took %8d nanoseconds on average.%n", methodName, avgTime);
    }

    @FunctionalInterface
    private interface ArrayCopyMethod {
        void copy(int[] src, int[] dest);
    }

    @FunctionalInterface
    private interface ArrayCopyMethod2D {
        void copy(int[][] src, int[][] dest);
    }
}