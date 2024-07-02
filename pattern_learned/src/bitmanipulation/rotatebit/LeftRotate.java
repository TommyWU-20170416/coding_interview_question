package bitmanipulation.rotatebit;

public class LeftRotate {
    public static int leftRotate(int n, int d) {
        int size = 32; // 假設我們處理的是 32 位元整數
        int a = n << d; // 10100
        int b = n >>> (size - d); //
        return (n << d) | (n >>> (size - d));
    }

    public static void main(String[] args) {
        int num = 5;  // 0101
        int d = 2;
        System.out.println("Before: " + Integer.toBinaryString(num));
        num = leftRotate(num, d);
        System.out.println("After: " + Integer.toBinaryString(num)); // 10100
    }
}
