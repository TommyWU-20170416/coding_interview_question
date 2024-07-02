package bitmanipulation.setbit;

public class SetKthBit {
    public static int setKthBit(int n, int k) {
        return n | (1 << k);
    }

    public static void main(String[] args) {
        int num = 5;  // 0101
        int k = 1;
        System.out.println("Before: " + Integer.toBinaryString(num));
        num = setKthBit(num, k);
        System.out.println("After: " + Integer.toBinaryString(num)); // 0111
    }
}
