package bitmanipulation;

public class CountBits {
    public static int findOneInNum(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int num = 11; // 1011 in binary
        System.out.println("Number of 1s in " + num + ": " + findOneInNum(num)); // 3
    }
}
