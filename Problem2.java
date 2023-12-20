//Got executed in leetcode
// The idea i had was to make a stack and also keep the track of minimum so when ever the min changed i pushed the last min and than the new element and while poping out i checked if it was min i poped out twice and the 2nd pop will be the new min
//Time complexities push O(1) ; pop (1) ; top,getmin O(1)

import java.util.Stack;
class MinStack {
    public Stack<Integer> x;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        this.x = new Stack<>();
        x.push(min);
        
    }
    
    public void push(int val) {
        if(val<=min){
            x.push(min);
            x.push(val);
            min = val;

        }
        else{
            x.push(val);
        }
        
    }
    
    public void pop() {
        if(x.peek()==min){
            x.pop();
            min = x.pop();
        }
        else{
            x.pop();
        }
        
    }
    
    public int top() {
        return x.peek();
        
    }
    
    public int getMin() {
        return min;
        
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