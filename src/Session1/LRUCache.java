package Session1;

import java.util.HashMap;

class LRUCache {

    private class Node {
        Node prev, next;
        int key, val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }

    private class DLList {
        public Node tail;
        Node head;
        int capacity;
        int size;

        public DLList(int capacity) {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
            this.capacity = capacity;
        }

        public void enq(Node n) {
            ++size;
            n.next = head.next;
            head.next = n;
            n.next.prev = n;
            n.prev = head;
        }

        public void delete(Node n) {
            --size;
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = null;
            n.prev = null;
        }
    }

    HashMap<Integer, Node> map;
    DLList list;

    public LRUCache(int capacity) {
        list = new DLList(capacity);
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            list.delete(n);
            list.enq(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            list.delete(n);
            list.enq(n);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            if (list.size >= list.capacity) {
                map.remove(list.tail.prev.key);
                list.delete(list.tail.prev);
            }
            list.enq(n);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

