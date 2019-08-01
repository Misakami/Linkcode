import java.util.HashMap;
import java.util.HashSet;


class MyCircularQueue {

    private int[] data;
    private int size;
    private int head; //头指针
    private int tail; //尾指针

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.size = 0;
        this.head = -1;
        this.tail = -1;
    }

    public boolean enQueue(int value) {
        if (size == data.length) {
            return false;
        }
        tail = (tail + 1) % data.length;
        data[tail] = value;
        if (size == 0) {
            head = tail;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % data.length;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

