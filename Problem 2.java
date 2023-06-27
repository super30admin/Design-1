// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using a integer array stack to keey the track of each value 
//first vaule in the array is the vaule inserted for each push
//Second vaule in the array the min vaule in the stack
//pop: removes the first int[] from the stack
//top: return the vaule of the int array at index[0]
//getMin: return the vaule of the int array at index[1]


class MinStack {

    Stack<int[]> stack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[]{x,x});
            return;
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x,Math.min(x,currentMin)});
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