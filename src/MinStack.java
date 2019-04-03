import java.util.Stack;

public class MinStack {
    /**
     * 最小栈，可以使用两个栈来放入最小值
     */
    private Stack<Integer> stack;
    private Stack<Integer> minstack;


    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int x) {
        if (minstack.empty()) {
            minstack.push(x);
        } else if (minstack.peek() >= x) {
            minstack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(minstack.peek())) {
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
