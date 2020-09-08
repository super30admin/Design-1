//time complexity O(n)
//space complexity O(2n)
//APPROACH: Using 2 stacks

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int x) {
        st.push(x);
        if(x < min){
            min = x;
        }
        minStack.push(min);
    }

    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//time complexity O(n)
//space complexity O(2n)
//APPROACH: Using 1 stack

class MinStack {
    Stack<Integer> st;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
        st.push(min);
    }

    public void push(int x) {
        if(x <= min){
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    public void pop() {
	//pop one ele and see if it's = to curr min
	//if it is we need to pop one more ele
	//which the previous stored min and re-assign    
        if(min == st.pop()){
            min = st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
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
