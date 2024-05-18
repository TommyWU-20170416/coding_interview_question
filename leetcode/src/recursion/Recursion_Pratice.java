package recursion;

/**
 * 優點：會先由最小的開始計算，不用管順序，且只計算必要的問題。（一開始是5，最後會遞迴到1跟0開始算，必要的為function有呼叫的，其餘的不管）
 * 缺點：因為不斷呼叫function降低效率，且無法自由控制計算訊，會很難控制記憶體配置
 *
 * @author AaronWU
 * @version 創建時間：2021年6月14日 下午3:33:38
 * @since JDK8.0
 */
public class Recursion_Pratice {
    private int[] table = new int[1 + 5];
    private boolean[] solve = new boolean[1 + 5];
    private int count = 0;

    public static void main(String[] args) {
        Recursion_Pratice test = new Recursion_Pratice();

        System.out.println("第5階總共有 " + test.f(5) + " 種步伐");
    }

    /**
     * 此方法有個問題就是 沒有去儲存已經計算過的數值，導致要再重新計算一次
     * 總共執行 8 次
     * @param n
     * @return
     */
//	private int f(int n) {
//		System.out.println(count++);
//		if (n < 0  || n > 5)  return 0;
//		if (n == 0 || n == 1) return 1;
//		else return f(n - 1) + f(n - 2);
//	}

    /**
     * 每一個計算出來的f(n)都會儲存到n欄位，也有對應的 solve[]，如果有做過就存true，可以再優化，如果table[n] >0 代表有計算過
     * 總共執行 6 次，減少了2跟3的重複
     * @param n
     * @return
     */
//	private int f(int n) {
//		System.out.println(count++);
//		if (n < 0  || n > 5)  return 0;
//		if (n == 0 || n == 1) return table[n] = 1;
//
//		if(solve[n]) return table[n];	/* 如果已經計算過，就直接抓儲存的數值*/
//		table[n] = f(n-1) + f(n - 2);	/* 沒抓過就去計算，並且儲存到table並返回 */
//		solve[n] = true;
//		return table[n];
//	}

    /**
     * 簡化solve將其修改為判斷table內的值是否不為0，因0為初始值，故非0則代表有計算過
     * @param n
     * @return
     */
//	private int f(int n) {
//		System.out.println(count++);
//		if (n < 0  || n > 5)  return 0;
//		if (n == 0 || n == 1) return table[n] = 1;
//
//		if(table[n] != 0) return table[n];	/* 如果已經計算過，就直接抓儲存的數值*/
//		return f(n-1) + f(n - 2);			/* 沒抓過就去計算，並且儲存到table並返回 */
//	}

    /**
     * 將 遞迴 改成 迴圈，與遞迴特性相反
     * 優點：提高記憶體的可用性，降低消耗function
     * 缺點：
     *
     * @param n
     * @return
     */
    private int f(int n) {
        table[0] = 1;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            System.out.println(count++);
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }


}
