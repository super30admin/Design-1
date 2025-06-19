// Time Complexity : push-O(1),pop-O(1),top-O(1).getMin-O(1)
// Space Complexity :O(n)
class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;// initializing minimum with infinity
        s.push(min); // pushing infinity minimum onto stack
    }

    // adding data/element/value(Val) in stack
    public void push(int val) {
        if (val <= min)// checking if the value is less than or equals to minimum
        {// if its less we have to push current minimum onto stack and assign new value
         // as minimum
            s.push(min);
            min = val;
        }
        s.push(val);// pushing the value onto stack

    }

    // removing value from stack
    // If popped element is not equals to minimum , we have to pop just one element.
    // If popped element is equals to minimum , we have to pop two element.(value
    // and previous minimum)
    public void pop() {
        int popped = s.pop();// remove/pop the element and assign it to popped
        if (popped == min)// check if popped is equals to minimum
        {
            min = s.pop();
        }

    }

    // Checking top element
    public int top() {
        return s.peek();

    }

    // method to get minimum element
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