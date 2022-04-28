// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
    
    //create two stacks to use in all methods
    private Stack<Integer> S1; //to store all values
    private Stack<Integer> S2; //to store minimum values

    public MinStack() {
        //Initialise the stacks
        S1 = new Stack<>();
        S2 = new Stack<>();
    }
    
    public void push(int val) {
        S1.push(val); //Push values as they come in stack 1
        int min = 0; 
        if(S2.isEmpty() || val<S2.peek()){ //check if stack 2 empty or new value less than peek
            min = val;
        }else{
            min = S2.peek();
        }
        S2.push(min);// push new value
    }
    
    public void pop() {
        S1.pop();
        S2.pop();
    }
    
    public int top() {
        return S1.peek();
    }
    
    public int getMin() {
        return S2.peek();
    }
}
