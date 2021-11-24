// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I was able to understand the concept in the lecture and follow it through


// Your code here along with comments explaining your approach


class MinStack {
    Stack<Integer> stack; 
    //Stack<Integer> minStack;
    int min; 
public MinStack() {
    stack = new Stack();
    //minStack = new Stack();
    this.min = Integer.MAX_VALUE; //initialise the min element with inf
   // minStack.push(min);
    
}

public void push(int val) {
   // min = Math.min(min,val);
    if(min >= val){
        stack.push(min);   //compare and push the min element and store min
        min = val; 
    }
    stack.push(val);   //push the value as we store min and val
    //minStack.push(min);
}

public void pop() {
    int popped = stack.pop(); //pop item
    if(popped == min){
        min = stack.pop();  //check if item is min, update min to old min
    }
    
    //minStack.pop();
    //min 
}

public int top() {
    return stack.peek();
    
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