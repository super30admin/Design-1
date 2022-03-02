// Time Complexity : push(x) - O(n) pop() - O(1) peek() - O(1) empty() - O(1)
// Space Complexity : O(n) [O(2n)]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I am not sure if this is the efficient way or not.


// Your code here along with comments explaining your approach

class MyQueue {
    
    private Stack<Integer> st1; //Stack for storing values
    private Stack<Integer> st2; //Used as buffer to store the elements in reverse order
    int size;

    public MyQueue() {
        //Initialising values
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
        size = 0;
    }
    
    public void push(int x) {
        while(!st1.empty()){ //transfering all elements to stack2
            st2.push(st1.pop()); 
        }
        st1.push(x); // adding element to stack1
        size++;
        while(!st2.empty()){ //transfering all elements back to stack1
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        size--;
        return st1.pop(); //pop the top element
    }
    
    public int peek() {
        return st1.peek(); //peek the top element
    }
    
    public boolean empty() {
        return st1.empty(); //checking whether the queue is empty
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */