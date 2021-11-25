/*Time Complexity : O(1)
 Space Complexity :O(N)
Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : No

*/

class MinStack {
    Stack<Integer> s ;
    Stack<Integer> minStack;
    int min;
    
    
    /*Apprach :
     * Using Extra Stack to to Maintain the Min of the satck
     * While pushing into the stack will chesk if its lessthan the min
     * If its less than min then will push lesser value otherwise will push the old min value into the stack
     * 
     * Also while popping we are going to pop from the both the satcks
     * 
     */
    public MinStack() {
        s = new Stack<Integer>();
        minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE; 
        minStack.push(min);
    }
    
    public void push(int val) {
            min = Math.min(val, min);
            s.push(val);
            minStack.push(min);

    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
        
    }
}

