import java.util.*;

class MinStack {
    Stack<Integer> s1;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        min = Integer.MAX_VALUE;
 
    }
    
    //push data 
    public void push(int x) {
        if(x <= min){
            s1.push(min);
            min = x;
        }
        s1.push(x);
        
    }
    
    //pop data
    public void pop() {
        int pop_elem = s1.pop();
        if(pop_elem == min){
            min = s1.pop();
        }
        
    }
    
    //return top value
    public int top() {
        return s1.peek();
    }
    
    //return min value
    public int getMin() {
       return min;
    }
}