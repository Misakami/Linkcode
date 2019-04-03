import java.util.HashMap;
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
        firstNode = new DoubleNode(0,0);
        lastNode = new DoubleNode(0,0);
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            newGet(map.get(key));
            return map.get(key).value;
        } else
            return -1;
    }

    private void newGet(DoubleNode doubleNode) {
        if (doubleNode.prev!=null)
        doubleNode.prev.next = doubleNode.next;
        if (doubleNode.next!=null)
        doubleNode.next.prev = doubleNode.prev;
        doubleNode.prev = null;
        doubleNode.next = firstNode;
        firstNode.prev = doubleNode;
        firstNode = doubleNode;

    }

    public void put(int key, int value) {
        DoubleNode newNode = map.get(key);
        if (newNode != null) {
            newNode = null;
        } else {
            newNode = new DoubleNode(key, value);
            if (capacity == 0) {
                reMove();
                capacity++;
            }
            map.put(key,newNode);
            newPut(newNode);
            capacity--;
        }
    }

    private void newPut(DoubleNode newNode) {
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            firstNode.prev = newNode;
            newNode.next = firstNode;
            firstNode = newNode;
        }
        lastNode = firstNode;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
    }

    private void reMove() {
        DoubleNode node = lastNode;
        map.remove(lastNode.key);
        lastNode = node.prev;
        if (lastNode != null) {
            lastNode.next = null;
            node.prev = null;
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
        if(!map.containsKey(key)) {
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
            if(size >= capa){
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