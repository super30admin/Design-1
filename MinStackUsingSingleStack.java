import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> st =  new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
       
    }
    
    public void push(int x) {
        if(x<=min){
         st.push(min);
         min = x;
     }
	
		st.push(x);
    }
    
    public void pop() {
        int popped = st.pop();
        if(popped == min){
            min = st.pop();
        }
    }
    
    public int top() {
       return st.peek();
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

public class MinStackUsingSingleStack {
	 public static void main(String[] args) {
		SpecialStack stack = new SpecialStack();
		 stack.push(10);
		 stack.push(11);
		 stack.push(12);
		 stack.getMin();
		 stack.push(7);
		 stack.pop();
		 stack.getMin();
}

}
