public class SampleMinStack {
    // Time Complexity : O(1) for push, pop, isEmpty, isFull and getMin()

    // Space Complexity : O(N) where N is size of the stack

    // Did this code successfully run on Leetcode : Yes

    // Any problem you faced while coding this : No

    // Your code here along with comments explaining your approach
    public static void main(String args[]) {

        MinStack obj = new MinStack();

        obj.push(-1);

        obj.push(0);

        obj.push(-3);

        obj.push(2);

        obj.pop();

        System.out.println("Top is: " + obj.top());

        System.out.println("Minimum is: " + obj.getMin());

        obj.push(2);

        System.out.println("Top is: " + obj.top());

        System.out.println("Minimum is: " + obj.getMin());

    }

}

class MinStack {

    StackData[] splStack;

    int count;

    int MAX_SIZE = 1000000;

    public MinStack(int maxSize) {

        MAX_SIZE = maxSize;

        splStack = new StackData[MAX_SIZE];

        count = -1;

    }

    public MinStack() {

        splStack = new StackData[MAX_SIZE];

        count = -1;

    }

    public void push(int val) {

        // check if stack is not full to avoid array overflow

        if (isFull()) {

            System.out.println("Stack is full");

            return;

        }

        if (isEmpty()) {

            // if stack is empty we the val will be minimum value

            splStack[++count] = new StackData(val, val);

        } else {

            // At each push we need to compare the current val with previous min value to
            // get the running min value

            StackData topData = splStack[count];

            StackData newData = new StackData(val, val);

            if (topData.min < val) {

                newData.min = topData.min;

            }

            splStack[++count] = newData;

        }

    }

    public void pop() {

        if (isEmpty()) {

            System.out.println("Stack is full");

            return;

        }

        // just decrement the counter to simulate pop operation

        count--;

    }

    public int top() {

        if (isEmpty()) {

            return -1;

        }

        return splStack[count].val;

    }

    public int getMin() {

        if (isEmpty()) {

            return -1;

        }

        return splStack[count].min;

    }

    public boolean isEmpty() {

        if (count == -1) {

            return true;

        } else {

            return false;

        }

    }

    public boolean isFull() {

        if (count >= MAX_SIZE - 1) {

            return true;

        } else {

            return false;

        }

    }

    // this object maintains data along with overall minimum value in stack

    class StackData {

        int val;

        int min = Integer.MIN_VALUE;

        public StackData(int val, int min) {

            this.val = val;

            this.min = min;

        }

    }

}
