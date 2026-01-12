/*used two stack approach , one just noemal and one to store the min val */ 

class MinStack {
Stack <Integer> st;
Stack<Integer> mst;
    public MinStack() {
        st= new Stack<>();
        mst= new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(mst.isEmpty())
        {
            mst.push(val);
        }

        else
        {
            mst.push(Math.min(val, mst.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        mst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mst.peek(); 
    }
}

