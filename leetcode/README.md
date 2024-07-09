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
- 淺拷貝　：1-4 方法都是指引到原數組

### 實測: 分成一維以及二維，1000 rounds * 1000 array_length
method: System.arraycopy     operation took      205 nanoseconds on average.
method: Arrays.copyOf        operation took     2083 nanoseconds on average.
method: clone                operation took     2341 nanoseconds on average.
method: Arrays.copyOfRange   operation took     2198 nanoseconds on average.
method: For                  operation took     4011 nanoseconds on average.
method: System.arraycopy     operation took   832404 nanoseconds on average.
method: Arrays.copyOf        operation took  1057720 nanoseconds on average.
method: clone                operation took  1076408 nanoseconds on average.
method: Arrays.copyOfRange   operation took   969507 nanoseconds on average.
method: For                  operation took   739607 nanoseconds on average.


## 字串 > char[] > byte[]

## 陣列排序方式
[Merge_Intervals_56.java](..%2Fpattern_learned%2Fsrc%2Fintervals%2FMerge_Intervals_56.java)
Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // 同等下面的意思
Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).reversed()); // 這是由小大到排序後，再進行翻轉，就可以獲得由大到小
Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 測試下來 比較快

## 陣列轉成 List
List<int[]> result = new ArrayList<>();
result.toArray(new int[result.size()][]);