package binarysearch;

import java.util.*;

/**
 * 981.https://leetcode.com/problems/time-based-key-value-store/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/19 16:04:43
 * @since JDK8.0
 */
public class Time_Based_Key_Value_Store_981 {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();

        obj.set("foo", "bar", 1);
        obj.set("panda", "bar", 1);
        String param_2 = obj.get("foo", 0);
        String param_3 = obj.get("foo", 3);

        obj.set("foo", "bar2", 4);
        String param_4 = obj.get("foo", 4);
        String param_5 = obj.get("foo", 5);

        obj.set("foo", "bar3", 8);
        String param_6 = obj.get("foo", 2);
        String param_7 = obj.get("foo", 5);
    }

// ["TimeMap",  "set",          "get",      "get",      "set",              "get",      "get"]
// [[],         ["foo","bar",1],["foo",1],  ["foo",3],  ["foo","bar2",4],   ["foo",4],  ["foo",5]]
}

/**
 * <pre>
 * {@code
 * // foo : values: [bar, bar2, bar3]
 * //     : times : [1  ,    3,    8]
 * }
 * </pre>
 * 一開始希望用這樣的方式去做管理，只要找到 key 就可以往後找 timestamp 在 times 的哪裡
 * 接著找到 index 後再去 values.get(index)
 * <p>
 * !! 最重要的是後面二分搜尋法完成，是 return values[end]
 * 以 [ 0 4 6] 來找 5
 * 第一次切出 4 發現 4 < 5，接著繼續往右邊切 start = mid + 1;
 * 然後找到 6 > 5 所以 end = mid - 1，跳出 while
 * return values[end] 而end 就會對應到 4 的位置
 * <p>
 * 二分法後 除了 mid 找到，end 會是最接近該值的左邊的數
 * start 是目標值 應該插入的位置或第一個大于目标值的位置。
 * end 是目标值应该插入的位置或最后一个小于目标值的位置。
 */

/**
 * Runtime: 135 ms, Beats 79.63%
 */
//class TimeMap {
//
//
//    class ValueTime {
//        private List<String> values;
//        private List<Integer> times;
//
//        ValueTime() {
//            this.values = new ArrayList<>();
//            this.times = new ArrayList<>();
//        }
//    }
//
//    private Map<String, ValueTime> map;
//
//    public TimeMap() {
//        map = new HashMap<>();
//    }
//
//    // 這個寫法要記，因為它直接用 getOrDefault 去看存不存在，反正最終都要 add 後加入
//    public void set(String key, String value, int timestamp) {
//        ValueTime vt = map.getOrDefault(key, new ValueTime());
//        vt.values.add(value);
//        vt.times.add(timestamp);
//        map.put(key, vt);
//    }
//
//    public String get(String key, int timestamp) {
//        if (!map.containsKey(key)) {
//            return "";
//        }
//
//        ValueTime vt = map.get(key);
//        List<Integer> times = vt.times;
//        List<String> values = vt.values;
//
//        // bound check
//        if (timestamp <= times.get(0)) {
//            return "";
//        }
//
//        // binary search
//        int start = 0, end = times.size() - 1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//
//            if (times.get(mid) == timestamp) {
//                return values.get(mid);
//            } else if (times.get(mid) < timestamp) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return values.get(end); // 最重要的這一行 可以去看 README.md 有筆記
//    }
//}

/**
 * Runtime: 116 ms, Beats 99.77%
 * 使用 node 去做
 * (foo, bar3, 8) > (foo, bar2, 4) > (foo, bar, 1)
 * 剛開始懷疑這樣是否可容納多 key
 * 但因為他是 node 而且他會檢查 如果 key 不同就往下找
 * 只是這樣我覺得不夠扁平，如果 key 多一點或許會壞掉，因為每一次找 key 最差情況就會是 O(n)
 */
class TimeMap {
    public class Time {
        String key;
        String value;
        int timestamp;
        Time prev;

        public Time(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            this.prev = null;
        }
    }

    Time timeMap;

    public TimeMap() {
        timeMap = null;
    }

    public void set(String key, String value, int timestamp) {
        Time temp = new Time(key, value, timestamp);
        temp.prev = timeMap;
        timeMap = temp;
    }

    public String get(String key, int timestamp) {
        return get(key, timestamp, timeMap);
    }

    private String get(String key, int timestamp, Time map) {
        if (map == null) {
            return "";
        }
        if (key.equals(map.key)) {
            if (map.timestamp <= timestamp) {
                return map.value;
            }
        }
        return get(key, timestamp, map.prev);
    }
}