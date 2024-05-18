package array.method;

/**
 * @author AaronWU
 * @version 創建時間：2021年5月3日 下午10:25:54
 * @since JDK8.0
 */
public class Cyclic_Sort {
    public static void main(String args[]) {
        int a = 6;
        int b = 9;
        System.out.println("交換前，a=" + a + " ,b=" + b);
        swap(a, b);
        System.out.println("交換後，a=" + a + " ,b=" + b);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("swap函數中，a=" + a + " ,b=" + b);
    }
}
