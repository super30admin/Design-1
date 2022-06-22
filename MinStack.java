//Time Complexity:
    //Push: O(1)
    //Pop: O(1)
    //top: O(1)
//Space Complexity: O(2N) = O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//The minstack operation can be implemented by using 2 stacks or in one stack. 
//The aim of 2 stack implementation is computational efficiency. 






class MinStack {
    //Declaring stack1 and stack 2
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int min; 
public MinStack() {
    //initializing both the stacks
    stack1 = new Stack<>();
    stack2 = new Stack<>();
    stack2.push(Integer.MAX_VALUE);
}

public void push(int val) {
    //adding an element to the stack
    stack1.add(val);
    min = stack2.peek();
    if (val < min)
        stack2.push(val);
    else
        stack2.push(min);
}

public void pop() {
    //Removing from the stack
    if (!stack1.isEmpty())
        stack1.pop();
    if (!stack2.isEmpty())
         stack2.pop();
}

public int top() {
    //Rettriving the stack top
        return stack1.peek();
}

public int getMin() {
       return stack2.peek();
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