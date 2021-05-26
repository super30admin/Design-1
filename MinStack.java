//This problem was asked at Microsoft

//Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and an operation getMin() which should return minimum element from the SplStack. All these operations must be O(1). To implement this, you should only use standard Stack data structure.

//Source Link: https://leetcode.com/problems/min-stack/

//Time Complexity : O(1) for all operations
//Space Complexity : O(2n) space worst case
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> s1;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        //check if value to be pushed is the new min
        if(val <= min){
          s1.push(min); 
          min = val;  
        }
        // push every value anyways
        s1.push(val);
    }

    public void pop() {
        int popped = s1.pop();
        //check if popped element is the min, then set the min again
        if(popped == min){
            min = s1.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return min;
    }
}
ß