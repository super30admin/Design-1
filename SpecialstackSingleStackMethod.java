class MinStack {
    int min;
    Stack<Integer> st; 
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Integer>();
    }
    
    public void push(int x) {
        //Check if the stack is empty
        if(st.isEmpty())
        {
            //assign min as the first value
            min = x;
            //push the first value
            st.push(x);
        }
        //Check if the value to be pushed is lesser than or equal to the min value
        else 
        {
            if(x <= min)
            {
                // Push the min value to the stack first if it fulfills condition
                st.push(min);
                //assign min as the push
                min = x;
            }
            //push the value into the stack
            st.push(x);
        }
    }
    
    public void pop() {
       //Check if stack is empty
        if(st.isEmpty())
        {
            return ;
        }
        else{
            if(st.peek()!=min)
            {
                st.pop();
            }
            else
            {
                st.pop();
                if(!st.isEmpty())
                {
                    min = st.pop();
                }
                else
                {
                    min = 0;
                }
            }
        }
    }
    
    public int top() {
        if(st.isEmpty())
        {
            return 0;
        }
        else
        {
           //Gives the top most value of the stack
            return st.peek(); 
        }
        
    }
    
    public int getMin() {
        if(st.isEmpty())
        {
            return 0;
        }
        else
        {
            return min;
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

 // Special stack has been implememted using stack data structure in Java
 //time complexity O(1)