/*
Created a single stack,and maintain a min variable.
Compare the value with min if its smaller than push the contents of min into stack then update the min val to the val and push the item.
If not push the item directly into stack.
For pop if the val is not equal to min simply pop
else compare the val with min if it is min remove the item set your min to the top of stack pop another val.
Time Complexity O(1)
Space Complexity O(1)

*/
class MinStack {
    Stack<Integer>s;
   // Stack<Integer> ms;
    int min;
    public MinStack() {
        s = new Stack<>();
        //ms = new Stack<>();
        min = Integer.MAX_VALUE;
        //ms.push(min);
        

    }
    
    public void push(int val) {
        if(val<=min){
            s.push(min);
            min = val;
            
        }
       
            s.push(val);
       
       /* min = Math.min(min,val);
        s.push(val);
        ms.push(min);*/

    }
    
    public void pop() {
     /*   s.pop();
        ms.pop();
        min = ms.peek();*/
        int popped = s.pop();
   /* if(s.peek()==min){
        s.pop();
        min = s.peek();
        s.pop();
    }
    else{
        s.pop();
    }*/
    if(popped == min){
        min = s.pop();

    }

    }
    
    public int top() {
        return s.peek();   
    }
    
    public int getMin() {
        /*if(s==null){
            return 0;
        }*/
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */