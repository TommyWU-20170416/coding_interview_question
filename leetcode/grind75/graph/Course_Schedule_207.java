package graph;

import java.util.*;

/**
 * 207.https://leetcode.com/problems/course-schedule/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/02 14:33:13
 * @since JDK8.0
 */
public class Course_Schedule_207 {
    public static void main(String[] args) {
        Course_Schedule_207 ss = new Course_Schedule_207();
        Course_Schedule_207.Solution solution = ss.new Solution();
//        int numCourses = 2;
//        int[][] prerequisites = {{1, 0}}; // true

//        int numCourses = 2;
//        int[][] prerequisites = {{1, 0}, {0, 1}}; // false

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}}; // true 沒有提高效率之前，算 3 的時候都要再回去算 2 ，然後再回去算 1 ，重複算了

//        int numCourses = 4;
//        int[][] prerequisites = {{1, 0}, {1, 2}, {0, 1}}; // false

        boolean result = solution.canFinish(numCourses, prerequisites);

        System.out.println(result);
    }

    /**
     * Runtime: 7 ms, Beats 31.13%
     */
//    class Solution {
//        Set<Integer> goodCourses = new HashSet<>(); // 提高效率使用
//        private Map<Integer, List<Integer>> course2pre = new HashMap<>(); // ex: {0, 1>2>3} 代表要上第 0 課 就要先修 1 2 3
//
//        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            // step 01: create the "course2pre" Graph
//            for (int i = 0; i < prerequisites.length; i++) {
//                int course = prerequisites[i][0];
//                int pre = prerequisites[i][1];
//
//                if (!course2pre.containsKey(course)) {
//                    course2pre.put(course, new LinkedList<>());
//                }
//                List<Integer> preList = course2pre.get(course);
//                preList.add(pre);
//            }
//
//            // step 02: find loop in Graph
//            for (int course = 0; course < numCourses; course++) {
//                Set<Integer> visitedCourses = new HashSet<>();
//                boolean isFinishable = isFinishable(course, visitedCourses);
//                if (!isFinishable) return false;
//            }
//            return true;
//        }
//
//        // 透過 course2pre 裡面的 preList 去跑 for，每一次進去都記錄到 set，若有重複就代表 loop 了
//        // 如果 for 跑完要把 add 過的移除
//        private boolean isFinishable(int course, Set<Integer> visitedCourses) {
//            if (goodCourses.contains(course)) return true;
//
//            if (visitedCourses.contains(course))
//                return false;
//            visitedCourses.add(course);
//
//            List<Integer> preList = course2pre.get(course);
//            if (preList != null) {
//                for (int pre : preList) {
//                    boolean isFinishable = isFinishable(pre, visitedCourses);
//                    if (!isFinishable) return false;
//                }
//            }
//            visitedCourses.remove(course); // 跑到這邊代表這個課程不用擔心，不會有重複
//
//            goodCourses.add(course);
//            return true;
//        }
//    }

    /**
     * Runtime: 2 ms, Beats 99.88%
     * 其實跟上面方法類似，都是用 創建一個 Graph 只是這邊用 array 呈現
     * 另一個重點她是以 pre 當作 key ，這樣在 DFS 的時候效率會更快一點
     * !! 因為先修課程是有可能重疊的，例如要先修 0 才可以上 1 跟 2，這樣子用 0 去追究可以 0 > 1 > 2
     * 但如果以 課程當 key 就要追三次 0 > X、1 > 0、2 > 0
     */
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new ArrayList[numCourses];
            // 初始化
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            // 把 pre & course 放進 graph
            for (int[] prerequisite : prerequisites) { // [先修課程: 課程]
                int course = prerequisite[0], pre = prerequisite[1];
                graph[course].add(pre);
            }
            int visited[] = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                // visited[i] == 0 初始值
                if (visited[i] == 0 && hasCycle(graph, visited, i)) {
                    return false;
                }
            }
            return true;
        }

        // true: 重複了、false: 沒有重複
        public boolean hasCycle(List<Integer> graph[], int visited[], int course) {
            if (visited[course] == 1) return true;
            if (visited[course] == 2) return false;

            visited[course] = 1; // 拜訪過
            for (int neighbor : graph[course]) {
                if (hasCycle(graph, visited, neighbor)) {
                    return true; // 若 return true 表示被拜訪過，代表重複了，所以回傳上一層
                }
            }
            visited[course] = 2; // 拜訪過但是不重複
            return false;
        }
    }
}