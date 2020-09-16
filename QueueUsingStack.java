// Time Complexity : O(1), O(n) while moving elemets from stack1 to stack2 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//I will take two stacks here, I will move pop elemts from stack1 to and push them to stack2 so that elements  
// while poping from stack1 satisfies property of LIFO and while getting pushed into stack2 follows FIFO queue property.

class QueueUsingStack {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        else if(stack2.isEmpty()) return -1;
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        else if(stack2.isEmpty()) return -1;
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}