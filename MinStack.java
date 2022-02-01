/*
    
    
	Push Time Complexity : O(1)
	Pop Time Complexity : O(1)
	Top Time Complexity : O(1)
	Get Min Time Complexity : O(1)
    
	Space Time Complexity : O(n)
	
	Problem successfully runs on Leetcode.
	
	Url to accepted solution on leetcode:   https://leetcode.com/submissions/detail/631739156/ 

    
*/
import java.util.*;

class MinStack {
        
    Stack<Integer> one;
    Stack<Integer> two;
    
    public MinStack() {
        this.one = new Stack<>();
        this.two = new Stack<>();
    }
    
    public void push(int val) {
        if(this.one.empty()){
            this.one.push(val);
            this.two.push(val);
        }else{
            if(this.two.peek() > val){
                this.one.push(val);
                this.two.push(val);
            }else{
                this.one.push(val);
                this.two.push(this.two.peek());
            }
        }
    }
    
    public void pop() {
        this.two.pop();
        this.one.pop();
    }
    
    public int top() {
        return this.one.peek();
    }
    
    public int getMin() {
        int rv = this.two.peek();
        this.one.peek();
        return rv;
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
