/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The idea in this question is to create a new data structure type, and store the current minimum of the all values
 * with them. Then return the min of the current value.
 */

public class LC_155_MinStack {

    /**
     * initialize your data structure here.
     */
    private Deque<Element> stack;

    public class Element {
        int value;
        int min;

        public Element(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public LC_155_MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Element(x, x));
        } else {
            stack.push(new Element(x, Math.min(x, stack.peekFirst().min)));
        }
    }

    public void pop() {
        stack.removeFirst();
    }

    public int top() {
        return stack.peekFirst().value;
    }

    public int getMin() {
        return stack.peekFirst().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */