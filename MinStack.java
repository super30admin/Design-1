class MinStack {
    int min = Integer.MAX_VALUE;  // initlializing with infinity
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value at the time when the current element being          //pushed is smaller than the current min
       
        if(x <= min){          
            stack.push(min);
            min=x; //after pushing the second lowest min update the current min
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();// if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(x == min) 
        min=stack.pop(); //next minimum value popped to update the minimum
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

//time complexity : retrieving the minimum - o(1)
//space complexity : o(n)