/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 */
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// 1. Create a new stack that has datatype of Element.
//     Element class has an integer x and a min value.
// 2. For every element that we push in stack we also push 
//     min value along.
// 3. Whenever we need min value it will be stack.peek().min

class MinStack {

    Stack<Element> stack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            min = x;
        }
        else min = x<min?x:min;
        stack.push(new Element(x,min));
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            if(!stack.isEmpty())
                min = stack.peek().min;
        }
    }
    
    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.peek().x;
    }
    
    public int getMin() {
        if(stack.isEmpty())
            return -1;
        return stack.peek().min;
    }
}

class Element {
    
    int x;
    int min;
    
    public Element(int x,int min) {
        this.x = x;
        this.min = min;
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




