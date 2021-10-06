import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Node> stack;
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int val) {
     Node node=new Node();
        if(!stack.isEmpty()){
            Node n=stack.peek();
            int prevMin=n.min;
            if(val<prevMin){
                node.min=val;
            }else{
                node.min=prevMin;
            }
        }else{
             node.min=val;
        }
         node.element=val;
         stack.push(node);     
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek().element;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

class Node{
    int element;
    int min;
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */