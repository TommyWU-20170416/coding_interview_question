package bitmanipulation;

public class ApplyMask {
    public static int applyMask(int n, int mask) {
        return n & mask;
    }

    public static void main(String[] args) {
        int num = 29;  // 11101
        int mask = 14; // 01110
        System.out.println("Number: " + Integer.toBinaryString(num));
        System.out.println("Mask: " + Integer.toBinaryString(mask));
        int result = applyMask(num, mask);
        System.out.println("After applying mask: " + Integer.toBinaryString(result)); // 01100
    }
}
