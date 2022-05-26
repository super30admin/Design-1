// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//We will be making use of 2 stacks in this approach 
//In 1st stack will push the values and will also push the minimum value to the 2nd stack
//Initially minimum value will be initialized to the infinity and then compared accordingly while pushing the elements into the stack
class MinStack {
    
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        min = Integer.MAX_VALUE;
        minSt.push(min);
        
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        st.push(val);
        minSt.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

