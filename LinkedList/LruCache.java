package leetcodeProblems.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    Map<Integer, DllNode> map = new HashMap<>();
    int capacity;
    DllNode head = new DllNode(0,0);
    DllNode tail = new DllNode(0,0);

    public void LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
       DllNode node = map.get(key);
        removeNode(node);
        insertNode(node);
        return node.value;

    }

    private void removeNode(DllNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertNode(DllNode node) {
        map.put(node.key, node);
        DllNode headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }

        if(capacity == map.size()){
            removeNode(tail.prev);
        }
        insertNode(new DllNode(key,value));

    }


}
