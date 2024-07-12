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

## 陣列轉成 List

List<int[]> result = new ArrayList<>();
result.toArray(new int[result.size()][]);

## 雙 For 優化方式

### 改變 i 跟 j 寫法

[Two_Sum_1.java](grind75/array/Two_Sum_1.java)

### hashmap

## 有名演算法

Boyer–Moore majority vote algorithm 多數投票演算法
[Majority_Element_169.java](grind75/array/Majority_Element_169.java)
原地演算法（in-place algorithm，也稱就地演算法）
[Sort_Colors_75.java](grind75/array/Sort_Colors_75.java)

## O(n) 有時候也是會跑輸 O(n^2)

[Contains_Duplicate_217.java](grind75%2Farray%2FContains_Duplicate_217.java)

## 數學

### 最大公因數

[Greatest_Common_Divisor_Of_Strings_1071.java](blind75%2Farray%2FGreatest_Common_Divisor_Of_Strings_1071.java)
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