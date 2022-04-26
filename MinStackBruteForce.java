//Brute force
// Time Complexity :getMin-O(n) except this all methods o(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Time Limit Exceeded
// Any problem you faced while coding this : how to keep record of minvalue after pop operation

class MinStack {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int minValue = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        st1.push(val);
        // System.out.println(st1+" inside push end");
    }

    public void pop() {
        int x = st1.pop();// if we are popping min value element update minvalue
        if (x == minValue) {
            minValue = Integer.MAX_VALUE;
        }

        // System.out.println(st1+" inside pop end");

    }

    public int top() {
        // System.out.println(st1+" inside peek end");
        return st1.peek();

    }

    public int getMin() {
        // if(!st1.isEmpty()){
        while (!st1.isEmpty()) {// calculate minimum value by traversing through each element to calculate
                                // minValue
            int temp = st1.pop();
            minValue = Math.min(minValue, temp);
            st2.push(temp);
        }
        // }

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }

        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
