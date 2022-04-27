//time complexity: for pushing, popping, top and get mininmum is O(1)
//space complexity: O(n) since 2 stacks are userd O(2n) is nothing much O(n)
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
        Stack<Integer> minstack;

    public MinStack() {
        stack=new Stack<Integer>();
        minstack= new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        int min=val;
        if(!minstack.empty())
        {
            if(min>minstack.peek())
            {
                min=minstack.peek();
            }
        }
        minstack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
        
    }
    public static void main(String args[]) 
    { 
        MinStack ms = new MinStack();  
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        
        
    } 
}
