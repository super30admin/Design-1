import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> currstack = new Stack<Integer>();
    public void push(int val) {
     // if val is less than minimum then push the val to currstack and assign the 
        //min to val else just push val into stack with no min assignment 
        if(val <= min){          
            currstack.push(min);
            min=val;
        }
        currstack.push(val);
    }

    public void pop() {
//still working on this one
        //getting some errors
    }

    public int top() {
        return currstack.peek();
    }

    public int getMin() {
        return min;
    }
}

