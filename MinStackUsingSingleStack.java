//minstack using single stack
// Complexity : all operations are having O(1) time complexity and space complexity in worst case when elements are in decreasing order then need to maintain min and element both in stack so space required is O(2n) ~ O(n) 
class MinStack {

    /** initialize your data structure here. */
    int min=Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack();
    
    public MinStack() {
        //dont push max value here because we are pushing it only if min changes in push function
       // minStack.push(min);
    }
    
    public void push(int x) {
        if(x<= min)
        {
        //stores previous min because current min you are already storing in variable min and updating each time, you need to keep track of historical min value so that you wont loose prev min track once the current min element out
            stack.push(min);
            min=x; 
        }
        
        stack.push(x);
    }
    
    public void pop() {
     int item= stack.pop();
        // if popped item and min is same means we need to update min by its old min data
     if(item == min)
     {
         //update minimum by popping out its value
         min=stack.pop();
     }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
