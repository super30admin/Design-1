//Problem 2:
//Design MinStack (https://leetcode.com/problems/min-stack/)

// Time Complexity : O(1) for all the operations
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I have used 2 Array Lists to mantain 2 stacks. Pushed and popped from the index 0.
// One for a standard stack.
// Second one to mantain the mimimum element.
// For the Minstack I push everytime the new element (pushed in the standard stack) is less than or equal to 
// the top on the Minstack.

class MinStack {

    ArrayList<Integer> stk;
    ArrayList<Integer> globalMin;
    /** initialize your data structure here. */
    public MinStack() {
        stk = new ArrayList<Integer>();
        globalMin = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        if(stk.size()==0){
            globalMin.add(0,val);
        }
        else if(val<=globalMin.get(0)){
            globalMin.add(0,val);
        }
        stk.add(0,val);
    }
    
    public void pop() {
        
        int top=stk.remove(0);
        if(top==globalMin.get(0)){
            globalMin.remove(0);
        }
    }
    
    public int top() {
        int topVal = stk.get(0);
        return topVal;
    }
    
    public int getMin() {
        return globalMin.get(0);
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