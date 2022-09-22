
// TC  push pop getMin top all O(1)

public class MinStack {
    
    private int min;
    private Stack<Integer>vivek;  
    
public
    MinStack() {
        min= Integer.MAX_VALUE;
        vivek= new Stack<>();
    }
    
    void push(int val) {
        if(val<=min){  
            vivek.push(min);// we r gonna push it one more time if the incoming element is the new minimum
            min=val;
        }
        vivek.push(val);
    }
    
    void pop() {
        int popped_ele= vivek.pop();
        if(popped_ele<= min){
            min=vivek.pop(); // since we have pushed the element twice when it is the minimum one, we r now popping it twice when the outgoing is the minimum and the last popped element is set to minimum
        }
    }
    
    int top() {
        return vivek.peek();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */