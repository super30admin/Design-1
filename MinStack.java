// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : is time complexity right for this problem i am a bit confused.

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack minStack;
    int smallest;
    
    public MinStack() {
        minStack = new Stack();
    }

    public void push(int x) {
        minStack.push(x);
    }

    public void pop() {

       minStack.pop();
    }

    public int top() {
       return (int) minStack.peek();

    }

    public int getMin() {
        smallest = top();
        minStack.forEach(element->{
        if(smallest > (int)element){
                smallest = (int)element;
            }
        

        
        });
       return smallest;
    }

    boolean isEmpty() 
    { 
        //Write your code here 
        return minStack.empty();

    } 

    
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */