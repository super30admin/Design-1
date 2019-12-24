//Leetcode Problem : 155
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
   Stack<Integer> stack; //original stack to store input
   Stack<Integer> minStack; //stack used to store minimum value only at each input
   
    public MinStack() {
       stack = new Stack<Integer>();
       minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        
        //if stack is empty, push first input in both stack
        if(stack.isEmpty()){
            stack.push(x);
            minStack.push(x);
        }else{ 
        	//compare the last element of minStack and the new input, put the smaller value in minStack and original input in original stack
            int y = minStack.peek();
            if(x>=y){
                stack.push(x);
                minStack.push(y);
            }
            else{
                stack.push(x);
                minStack.push(x);
            }
                
        }
        
        
        
    }
    
    //remove the topmost element from both stack
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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
