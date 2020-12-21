// Time Complexity : push() O(1), pop O(1), top O(1), getMin O(1)
// Space Complexity : Not too sure? 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : was not too sure about how to maintain the minimum value. Then I created a private class that makes it easy to access the min value. 


// Your code here along with comments explaining your approach

class MinStack {
    Integer min = Integer.MAX_VALUE;
    Stack<Node> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Node>();
    }
    
    public void push(int x) {
        if(x < min){
            min = x;
        }
        //The minimum from this stack element and below is min. 
        //If we remove the element that is min, the next stack will have the updated min. 
        stack.add(new Node(x, min));
    }
    
    public void pop() {
        Node removedElement = stack.pop();
        if(stack.size() == 0){
            min = Integer.MAX_VALUE;
        }else{
            min = stack.peek().min;
        }
    }
    
    public int top() {
       return stack.peek().value;
    }
    
    public int getMin() {
        return min;
    }
    
    // This private class helps keep the minimum value, so if we pop an element, we know what the next minimum is. 
    private class Node{
        Integer value;
        Integer min;
        
        Node(Integer val, Integer min){
            this.value = val;
            this.min = min;
        }
        
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