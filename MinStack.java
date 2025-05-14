// Time Complexity : All operations take O(1)
// Space Complexity : O(n) where n is size of arraylist
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Created a key class with data and min elements. Created a stack that can store Key objects. 
//          When a new element is added to stack, we check if the incoming element is smaller than the existing min(check min of top element)
//          if yes, add to stack, key object where data = element and min = element, else min will be the minimum element so far (min of top key object in stack)
//          this way, we keey track of both data elements and corresponding minimum element in the stack.
import java.util.*;
class Key{
    int data, min;
    Key(int data, int min){
        this.data = data;
        this.min = min;
    }
}
class MinStack {
    int top;
    ArrayList<Key> stack;
    public MinStack() {
        stack = new ArrayList<Key>();
        top = -1;
    }
    
    public void push(int val) {
        if(top==-1){
            stack.add(new Key(val, val));
        }
        else{
            if(stack.get(top).min<val){
                stack.add(new Key(val, stack.get(top).min));
            }
            else{
                stack.add(new Key(val, val));
            }
        }
        top++;
    }
    
    public void pop() {
        if(top==-1){
            System.out.println("Stack underflow error");
        }
        else{
            stack.remove(top);
            top--;
        }
    }
    
    public int top() {
        if(top==-1){
            System.out.println("Stack is empty");
            return -1;
        }
        Key key = stack.get(top);
        return key.data;
    }
    
    public int getMin() {
        if(top==-1){
            System.out.println("Stack is empty");
            return -1;
        }
        Key key = stack.get(top);
        return key.min;

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