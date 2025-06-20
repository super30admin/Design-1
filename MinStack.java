import java.util.Stack;

public class MinStack {
	
    Stack<Integer> s;
    int min;
    
    public MinStack() {
        s = new Stack<>();
    }
    public void push(int val) {
       if (val <= min) {
            s.push(min);
            min = val;
           
        } 
       s.push(val);
    }
    public void pop() {
       s.pop();
    }
    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }

	

}
