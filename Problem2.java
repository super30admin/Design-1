// Using 1 stack
// Time Complexity - O(n) where n is the number of operations
//Space Complexity - O(n) where n is the number of elements to push on stack
// We will be using min global variable to keep track of the running minimum. The minstack will be used to keep track of the previous min values and the elements that are pushed. When we push the new element in the stack, we compare it with the min variable, if the min is greater than or equal to the element, we will push the minimum variable value in the stack and then the element and update the min variable with the element. This will allow us to keep historic value of the minimum in stack whenever min value is updated with new minimum value.  If the min is less than the element, simply push the element in stack. We won't push the min value because it did not get updated. In case of pop, we will compare if the pop value is same as min value. If it is same, if means the minimum value is no more valid. So, we pop one more time from the stack which will give the previous min value and it will be assigned to the min variable. If the pop value is not same as min, we will simply pop it from the stack.

class MinStack {

    /** initialize your data structure here. */
    int min =Integer.MAX_VALUE;
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(min >= x){
            minStack.push(min);
            minStack.push(x);
            min = x;
        }
        else{
            minStack.push(x); 
        }
    }
    
    public void pop() {
        if(minStack.peek() == min){
            minStack.pop();
            min = minStack.peek();
            minStack.pop();
        }
        else{
            minStack.pop(); 
        }      
    }
    
    public int top() {
        return minStack.peek();   
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
