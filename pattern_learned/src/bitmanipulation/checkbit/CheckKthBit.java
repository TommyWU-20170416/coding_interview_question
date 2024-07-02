package bitmanipulation.checkbit;

public class CheckKthBit {
    public static boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    public static void main(String[] args) {
        int num = 5;  // 0101
        int k = 2;
        System.out.println("Is " + k + "th bit set? " + checkKthBit(num, k)); // true
    }
}
