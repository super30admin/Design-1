// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    Stack <Integer> main = new Stack<>();
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if(x<=min){
            main.push(min);
            min=x;
        }
        main.push(x);   
    }
    
    public void pop() {
        if(min == main.pop()){
            min = main.pop();
        }  
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min;
    }
}