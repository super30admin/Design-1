/*
S30 Version

Maintain  single stack for maintaining current minimum : 


N =  Size of input
Time Complexity:  Push O(1) 
                  Pop O(1)
                  peek O(1)
Space Complexity : O(N) N is size of input
CODE Worked on leetcode : YES

*/


import java.util.Stack;

class Min_Stack_Using_Single_Stack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        // Whenever the element to be pushed is less than current minimum push current minimum into stack and
// then change the current min to newly added element
        if(x < min ){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        int popped = stack.pop();
        // if popped element is min  then we have to update the min to peek element then poped that element


        if(min == popped){
            min = stack.pop();
        }
        
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */