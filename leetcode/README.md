# leetcode 小技巧

## 使用 boolean[]

## 複製陣列(實測: [CopyArray.java](tips/CopyArray.java))

> 有時候需要把 A 陣列複製給 B 陣列，且需要截斷的時候。[Asteroid_Collision_735.java](blind75/stack/Asteroid_Collision_735.java)

### 1. 使用 System.arraycopy

- 優點
    - 使用 native method 高效
- 缺點
    - 代碼可讀性稍微差點

### 2. 使用 Arrays.copyOf

- 優點
    - 代碼可讀性好
    - 容易調整目標數組長度
- 缺點
    - 因調用 System.arraycopy 並做額外處理，效能稍差

### 3. 使用 clone 方法

- 優點
    - 代碼簡潔易讀，適用於一維數組複製
- 缺點
    - 只能複製一維數組

### 4. 使用 Arrays.copyOfRange

- 優點
    - 可複製部分範圍
- 缺點
    - 因調用 System.arraycopy 並做額外處理，效能稍差

### 5. 使用手动循环 for

- 優點
    - 直觀易懂
- 缺點
    - 性能不好

### 結論

- 高效複製：使用 System.arraycopy 或 Arrays.copyOf。
- 全部複製：使用 clone。
- 特殊處理：使用 for。
- 淺拷貝 ：1-4 方法都是指引到原數組

### 實測: 分成一維以及二維，1000 rounds * 1000 array_length

method: System.arraycopy operation took 205 nanoseconds on average.
method: Arrays.copyOf operation took 2083 nanoseconds on average.
method: clone operation took 2341 nanoseconds on average.
method: Arrays.copyOfRange operation took 2198 nanoseconds on average.
method: For operation took 4011 nanoseconds on average.
method: System.arraycopy operation took 832404 nanoseconds on average.
method: Arrays.copyOf operation took 1057720 nanoseconds on average.
method: clone operation took 1076408 nanoseconds on average.
method: Arrays.copyOfRange operation took 969507 nanoseconds on average.
method: For operation took 739607 nanoseconds on average.

## 字串 > char[] > byte[]

## 陣列排序方式

[Merge_Intervals_56.java](../pattern_learned/src/intervals/Merge_Intervals_56.java)
Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // 同等下面的意思
Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).reversed()); // 這是由小大到排序後，再進行翻轉，就可以獲得由大到小
Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 測試下來 比較快

## ListNode

### 翻轉

[Reverse_Linked_List_206.java](blind75/linkedlist/Reverse_Linked_List_206.java)

### 找中間位置

### 變形練習

- 變形:刪除中間
  [Delete_The_Middle_Node_Of_A_Linked_List_2095.java](blind75/linkedlist/Delete_The_Middle_Node_Of_A_Linked_List_2095.java)
- 變形翻轉找中間位置
  [Maximum_Twin_Sum_Of_A_Linked_List_2130.java](blind75/linkedlist/Maximum_Twin_Sum_Of_A_Linked_List_2130.java)

## 陣列轉成 List

List<int[]> result = new ArrayList<>();
result.toArray(new int[result.size()][]);

## 雙 For 優化方式

### 改變 i 跟 j 寫法

[Two_Sum_1.java](grind75/array/Two_Sum_1.java)

### hashmap

## Array

### 陣列可以達到檢查順序不同的字母或數字

[Find_All_Anagrams_in_a_String_438.java](grind75/string/Find_All_Anagrams_in_a_String_438.java)

## 有名演算法

Boyer–Moore majority vote algorithm 多數投票演算法
[Majority_Element_169.java](grind75/array/Majority_Element_169.java)
原地演算法（in-place algorithm，也稱就地演算法）
[Sort_Colors_75.java](grind75/array/Sort_Colors_75.java)

## O(n) 有時候也是會跑輸 O(n^2)

[Contains_Duplicate_217.java](grind75/array/Contains_Duplicate_217.java)

## 數學

### 除法

#### 向上取整 [Successful_Pairs_Of_Spells_And_Potions_2300.java](blind75/binarysearch/Successful_Pairs_Of_Spells_And_Potions_2300.java)

ceil(5 / 2) => (a + b -1) / b = (5 + 2 - 1 / 2) = 3

#### 向下取整(算出來是 2.5 但因為是 int 所以小數點會被自動砍掉)

floor(5 / 2)=> (a / b) = 2

#### 四捨五入

round(5 / 2) 直接除 = 2.5 預期要變成 3
=> (a + b / 2) / b = (5 + 2 / 2) / 2 = 3
round(17/ 4) 直接除 = 4.25 預期要變成 4
=> (a + b / 2) / b = (17+ 4 / 2) / 4 = 4

### 最大公因數

[Greatest_Common_Divisor_Of_Strings_1071.java](blind75/array/Greatest_Common_Divisor_Of_Strings_1071.java)
有兩種方式。Ex: gcd(48, 18)表示

1. 第一種使用餘數(推薦，算得比較快)
    - 48 / 18 = 2 ... 12
    - 18 / 12 = 1 ... 6
    - 12 / 6 = 2 ... 0

> 簡化公式:
> gcd(a, 0) = a <br/>
> gcd(a, b) = gcd(b, a % b)

2. 第二種使用加減
    - 48 - 18 = 30
    - 30 - 18 = 12
    - 18 - 12 = 6(因為減去後已經比 num2 小，所以換 num2 放前面)
    - 12 - 6 = 6
    - 6 = 6

> 簡化公式:
> gcd(a, a) = a <br/>
> gcd(a, b) = gcd(a-b, b); a > b <br/>
> gcd(a, b) = gcd(a, b-a); b > a <br/>

## 大小寫轉換

toLowercase [Valid_Palindrome_125.java](grind75/string/Valid_Palindrome_125.java)

## 二分法

[Time_Based_Key_Value_Store_981.java](grind75/binarysearch/Time_Based_Key_Value_Store_981.java)
二分查找的最終狀態
當目標值不在數組中時：
start 是目標值應該插入的位置或第一個大於目標值的位置。
end 是目標值應該插入的位置或最後一個小於目標值的位置。
[-1, 0, 3, 5, 9, 12] 要找到 2
第一次: [-1, 3, 12]
第二次: [-1, 0, 0]
第三次: [ 3, 0, 0]
最後一個 < 2 的是 0，第一個 > 2 的是 3

### 在重複的陣列中，找最小 index

### 在重複的陣列中，找最大 index


## tree
### 節點的高度（depth）
在樹相關的問題中，return Math.max(leftHeight, rightHeight) + 1; 是一個常見的操作
[Maximum_Depth_Of_Binary_Tree_104.java](grind75%2Fbinarytree%2FMaximum_Depth_Of_Binary_Tree_104.java)