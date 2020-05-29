Time complexity - O(1) for everyOpertaion
Space complexity - O(n) n - number of elements
 

class MinStack {

    private Stack <int[]> stack = new Stack<>();
    
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[] {x,x});
            return;
        }
        
        int min = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x,min)});
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
