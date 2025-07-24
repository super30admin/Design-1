import java.util.Stack;

class MinStack {

    private Stack<Integer> st;
    private int min;

    public MinStack() {
        this.st=new Stack<>();
        this.min=Integer.MAX_VALUE;

    }

    public void push(int val) {
        if(min>=val){
            st.push(min);
            min=val;
        }
        st.push(val);
    }

    public void pop() {
        if(!st.isEmpty()){
            int top=st.pop();
            if(top==min)min=st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}

