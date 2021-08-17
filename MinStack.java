// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack minStack;

    public MinStack() {

        minStack = new Stack();

    }

    public void push(int val) {


        minStack.push(val);

    }

    public void pop() {

        if (!minStack.isEmpty()) {

            minStack.pop();
        }

    }

    public int top() {

        if (!minStack.isEmpty()) {

            int topElement = (int) minStack.peek();
            return topElement;
        }

        return -1;

    }

    public int getMin() {

        Object[] arr = minStack.toArray();

        Arrays.sort(arr);

        int minElement = (int) arr[0];

        return minElement;

    }

    // Your MinStack object will be instantiated and called as such:
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }
}

