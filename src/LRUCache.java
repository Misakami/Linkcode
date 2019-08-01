import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    /**
     * 首先得使用双向链表来实现最近最少使用
     */
    class DoubleNode {
        int value;
        int key;
        DoubleNode next;
        DoubleNode prev;

        public DoubleNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    private int capacity;
    HashMap<Integer, DoubleNode> map = new HashMap<>();
    private DoubleNode firstNode;
    private DoubleNode lastNode;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        firstNode = new DoubleNode(-1, -1);
        lastNode = new DoubleNode(-1, -1);
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleNode getNode = map.get(key);

            //删除所在节点
            DoubleNode nodePerv = getNode.prev;
            DoubleNode nodeNext = getNode.next;
            nodeNext.prev = nodePerv;
            nodePerv.next = nodeNext;

            //放在最近使用位置
            DoubleNode lastNodePrev = lastNode.prev;
            lastNodePrev.next = getNode;
            getNode.prev = lastNodePrev;
            getNode.next = lastNode;
            lastNode.prev = getNode;

            return getNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            DoubleNode containNode = map.get(key);
            containNode.prev.next = containNode.next;
            containNode.next.prev = containNode.prev;

            lastNode.prev.next = containNode;
            containNode.prev = lastNode.prev;
            containNode.next = lastNode;
            lastNode.prev = containNode;
            containNode.value = value;
        }else {
            if (capacity <= 0){
                DoubleNode node = firstNode.next;
                map.remove(node.key);

                firstNode.next = node.next;
                node.next.prev = firstNode;
            }
            capacity--;
            DoubleNode node = new DoubleNode(key, value);
            lastNode.prev.next = node;
            node.prev = lastNode.prev;
            node.next = lastNode;
            lastNode.prev = node;
            map.put(key,node);
        }
    }
}

class LRUCache1 {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Map<Integer, Node> map = new HashMap<>();

    int size = 0;
    Node dummy = new Node();
    Node tail = new Node();
    int capa;

    public LRUCache1(int capacity) {
        capa = capacity;
        dummy.next = tail;
        tail.prev = dummy;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node i = map.get(key);
        Node tempPrev = i.prev;
        Node tempNext = i.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
        Node tempTailPrev = tail.prev;
        tempTailPrev.next = i;
        i.prev = tempTailPrev;
        i.next = tail;
        tail.prev = i;
        return i.value;

    }

//     private moveNodetoTail (Node cur) {

//     }

    public void put(int key, int value) {
        Node i = map.get(key);
        if (i == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            if (size >= capa) {
                Node tempHead = dummy.next;
                dummy.next = tempHead.next;
                dummy.next.prev = dummy;
                map.remove(tempHead.key);
            }
            map.put(key, newNode);
            Node tempTailPrev = tail.prev;
            tempTailPrev.next = newNode;
            newNode.prev = tempTailPrev;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        } else {
            i.value = value;
            Node tempPrev = i.prev;
            Node tempNext = i.next;
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;

            Node tempTailPrev = tail.prev;
            tempTailPrev.next = i;
            i.prev = tempTailPrev;
            i.next = tail;
            tail.prev = i;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */