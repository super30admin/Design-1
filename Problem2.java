class MinStack {

    /** initialize your data structure here. */

    //Stack that gonna store all the elements
    Stack<Integer> minStack = new Stack<>();

    //Stack that will store the minimum element
    Stack<Integer> curStack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(minStack.isEmpty()){
            curStack.push(x);
        }else if(x<=curStack.peek()){
            curStack.push(x);
        }
        minStack.push(x);
    }
    
    public void pop() {
        if(minStack.peek()<=curStack.peek()){
            curStack.pop();
        }
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return curStack.peek();
    }
}

class Main { 
    public static void main(String args[]) 
    { 
        MinStack s = new MinStack(); 
        s.push(-2); 
        s.push(0); 
        s.push(-3);
        int min = s.getMin();
        System.out.println("Minimum Element in the stack:" + min); 
        s.pop();
        s.pop();
        min = s.getMin();
        System.out.println("Minimum Element in the stack:" + min); 
    } 
}