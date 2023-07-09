//Time Complexity is O(1) for all operations
//Space Complexity is O(N); new Stack with all the numbers added to stack
// Code ran in Leetcode without any errors
class MinStack {
    Stack<Integer> minstack;
    int min;
    public MinStack() {
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min ){
            minstack.push(min);
            minstack.push(val);
            min = val;
        }else minstack.push(val);
    }

    public void pop() {
        if(minstack.peek() == min){
            minstack.pop();
            min = minstack.pop();
        }
        else minstack.pop();
    }

    public int top() {
        return minstack.peek();
    }

    public int getMin() {
        return min;
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