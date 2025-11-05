package leetCode.question;

import java.util.HashMap;

public class leetCode146 {

}

class LRUCache {

    public class DlinkedNode {
        public int key;
        public int value;
        public DlinkedNode prev;
        public DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DlinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DlinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DlinkedNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DlinkedNode node = map.get(key);
        if (node == null) {
            DlinkedNode newNode = new DlinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DlinkedNode tailNode = removeTail();
                map.remove(tailNode.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DlinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DlinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DlinkedNode removeTail(){
        DlinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
