package graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 133.https://leetcode.com/problems/clone-graph/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/06/14 14:57:57
 * @since JDK8.0
 */
public class Clone_Graph_133 {
    public static void main(String[] args) {
        Clone_Graph_133 s = new Clone_Graph_133();
        Clone_Graph_133.Solution solution = s.new Solution();

        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node);

        Node result = solution.cloneGraph(node);
        System.out.println("result: " + result.val);
    }

    class Solution {

        /**
         * test1
         * 解法:
         * 使用 DFS 搭配 Map 紀錄哪些點已存在過
         * 在遍歷的過程中，也順便做 clone 動作
         */
//        Map<Integer, Node> nodes_cloned = new HashMap<>();
//
//        public Node cloneGraph(Node node) {
//            if (node == null) return null;
//
//            Set<Integer> visited = new HashSet<>();
//            cloneGraph_recursion(node, visited);
//
//            return get_cloned_node(node);
//        }
//
//        private void cloneGraph_recursion(Node node, Set<Integer> visited) {
//            if (visited.contains(node.val)) return;
//            visited.add(node.val);
//
//            Node node_src_cloned = get_cloned_node(node);
//
//            for (int i = 0; i < node.neighbors.size(); i++) {
//                Node node_next = node.neighbors.get(i);
//
//                Node node_dst_cloned = get_cloned_node(node_next);
//                node_src_cloned.neighbors.add(node_dst_cloned);
//
//                cloneGraph_recursion(node_next, visited);
//            }
//        }
//
//        private Node get_cloned_node(Node node) {
//            if (nodes_cloned.containsKey(node.val)) {
//                return nodes_cloned.get(node.val);
//            }
//            nodes_cloned.put(node.val, new Node(node.val));
//            return nodes_cloned.get(node.val);
//        }

        /**
         * test2
         * 解法
         * 把 test1 的 get_cloned_node 整併到 clone 內
         *
         */
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            return clone(node, new HashMap<>());
        }

        public Node clone(Node node, Map<Node, Node> clonedMap) {
            if (clonedMap.containsKey(node))
                return clonedMap.get(node);

            Node cloneNode = new Node(node.val);

            clonedMap.put(node, cloneNode);
            for (Node n : node.neighbors) {
                cloneNode.neighbors.add(clone(n, clonedMap));
            }

            return cloneNode;
        }
    }
}
