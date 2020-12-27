class MinStack {

    //Time Complexity: 1. O(1) to push the element 2. O(1) to pop
    //Space Complexity: 1. O(2N)--> O(N) for 2 stacks used to monitor.

    /*
    We would need two stacks 1. to have normal stack for the elements to push
                             2. to check if we got minimum value in those input elements.
     */

    private Stack<Integer> normal;
    private Stack<Integer> minSt;

    /** initialize your data structure here. */
    public MinStack() {
        normal = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int x) {
        /*
        1. we are checking if minStack is empty here because in future when we pop the value,
           we dont have to check separately whether the stack is empty or not.
           Or else the code gets complicated with null checks. For few test cases it works but few of them does not work

        2. We are checking the minValue from stack directly. My earlier approach was to use separate
            min variable, but it was no use once the first element enters the stack. So better to avoid extra variable
            with max Value;
         */

        if (minSt.isEmpty() || x <= minSt.peek()){
            minSt.push(x);
        }
        normal.push(x);
    }

    public void pop() {
        //we have to use .equals method here as Stack has Integer object as parameter.
        // if we use "==" operator then this will not work and we will get error running this bit of code on leetcode.
        if (normal.peek().equals(minSt.peek())){
            minSt.pop();
        }
        normal.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return minSt.peek();
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

/*
Leetcode analysis:
18 / 18 test cases passed.
Status: Accepted
Runtime: 5 ms
Memory Usage: 40.5 MB
 */