package leetcodeProblems.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache1 {

    int capacity;
    Map<Integer,DllLinkedList> freqMap;
    Map<Integer, DllNode> nodeMap;
    int currSize;
    int minFreq;


    public void LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        freqMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        DllNode node = nodeMap.get(key);
        updateNode(node);
        return node.val;

    }

    private void updateNode(DllNode node) {
        int currFreq = node.frequency;
        DllLinkedList currList = freqMap.get(currFreq);
        currList.removeNode(node);
        if(currList.listSize == 0 && currFreq == minFreq){
            minFreq++;
        }
        node.frequency++;
        DllLinkedList linkedList = freqMap.getOrDefault(node.frequency, new DllLinkedList());
        linkedList.addNode(node);
        freqMap.put(node.frequency,linkedList);
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(nodeMap.containsKey(key)){
            DllNode node = nodeMap.get(key);
            updateNode(node);
        }
        currSize++;
        if(currSize>capacity){
            DllLinkedList linkedList = freqMap.get(minFreq);
            DllNode nodeToRemove = linkedList.tail.prev;
            if (nodeToRemove != null) {
                linkedList.removeNode(nodeToRemove); // Remove from DLL
                nodeMap.remove(nodeToRemove.key);    // Remove from nodeMap
            }
            currSize--;  // Decrease the current size after eviction

        }
        minFreq = 1;
        DllNode node= new DllNode(key,value);
        DllLinkedList linkedList = freqMap.getOrDefault(1, new DllLinkedList());
        linkedList.addNode(node);
        freqMap.put(1,linkedList);
        nodeMap.put(key,node);
    }

    class DllNode{
        int key;
        int val;
        int frequency;

       DllNode next;
       DllNode prev;

       public DllNode(int key, int val){
           this.key = key;
           this.val = val;
           this.frequency = 1;
       }
    }

    class DllLinkedList{
        int listSize;
        DllNode head;
        DllNode tail;

        public DllLinkedList(){
            this.listSize = 0;
            this.head = new DllNode(0,0);
            this.tail = new DllNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void removeNode(DllNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            listSize--;
        }

        public void addNode(DllNode node) {
            DllNode headNext = head.next;
            head.next = node;
            node.prev = head;
            node.next = headNext;
            headNext.prev = node;

        }
    }

}
