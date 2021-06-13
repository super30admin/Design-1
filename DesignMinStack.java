/*
    Time Complexity
    O(1) for all operations
    Space Complexity
    O(n)
*/

class MinStack {

    Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    //Before pushing if min is being updated or is equal to min (handle duplicates) we push the prev min
    public void push(int val) {
        if (val <= min) {
            stack.add(min);
            min = val;
        }

        stack.add(val);

    }
    //If the value is equal to min we pop 2 becuase we need to pop the element and the previous min and set it to min
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}