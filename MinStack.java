import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {

    List<Integer> list = new ArrayList<Integer>();
    Stack<List<Integer>> stack = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack= new Stack<List<Integer>>();
    }
    
    public void push(int x) {
        if(!stack.isEmpty())
        {
            List<Integer> list = stack.peek();
            int min = x < list.get(1) ? x: list.get(1);
            List<Integer> node = new ArrayList<Integer>();
            node.add(x);node.add(min);
            stack.push(node);
        }
        else
        {
            List<Integer> node = new ArrayList<Integer>();
            node.add(x);node.add(x);
            stack.push(node);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty())
        {
            stack.pop();
        }
    }
    
    public int top() {
        List<Integer> list = null;
        if(!stack.isEmpty())
        {
          list = stack.peek();
        }
        return list.get(0);
    }
    
    public int getMin() {
        List<Integer> list = null;
        if(!stack.isEmpty())
        {
          list = stack.peek();
        }
        return list.get(1);
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