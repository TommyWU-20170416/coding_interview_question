package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 146.https://leetcode.com/problems/lru-cache/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/07/23 11:57:55
 * @since JDK8.0
 */
public class LRU_Cache_146 {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        int param_1 = obj.get(1);
        obj.put(3, 3);
        int param_2 = obj.get(2);
        obj.put(4, 4);
        int param_3 = obj.get(1);
        int param_4 = obj.get(3);
        int param_5 = obj.get(4);
    }
}

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == this.capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 這邊要注意順序 head <> node <> tail
    // 先把 node 都做完 prev, next， head < node > tail
    // 再來是 node < tail、最後是 head > node
    // 如果 head.next = node; 優先於 head.next.prev = node; 會發生什麼事情

    private int insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        return node.value;
    }
}