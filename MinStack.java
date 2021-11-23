// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach
// Here in this code im using two stacks one to keep track of Minimum values and the other is just a normal stack. 
// so for the push operation the minstack checks if it is empty or the peek value of the minstack is greater than or equal to value 
// then the value gets pushed to the minstack and also gets pushed to the st(Normal stack).
//And for the pop operation it compares minstack peek and st.peek() if they are equal then pop is performed on minstack and st.
//top() returns the element at the top in st(stack).
// getMin() returns the element at the top in minStack()
import java.util.Stack;
public class MinStack {
    Stack<Integer> st; 
    Stack<Integer> minStack;
    public MinStack() {
        st=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
       if(minStack.isEmpty() || minStack.peek()>=val){
           minStack.push(val);
       }
        st.push(val);
    }
    
    public void pop() {
        if(minStack.peek().equals(st.peek())){
            minStack.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
       
            return minStack.peek();
       
    }

public static void main(String args[]){
    MinStack obj = new MinStack();
    obj.push(1);
    obj.push(-10);
    obj.push(45);
    obj.push(-100);
    obj.pop();
  int param_3 = obj.top();
  int param_4 = obj.getMin();
  System.out.println(param_3);
  System.out.println(param_4);
}
  
}

