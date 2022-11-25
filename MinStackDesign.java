//time complexity is O(1)
//space complexity is O(N)
//able to submit the in leetcode
class MinStack {
    Stack<int[]> st = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty())
        {
            st.push((new int[]{val, val}));
        }
        else{
            int[] temp = st.peek();
            st.push(new int[] {val, Math.min(val, temp[1])});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

//Approach learnt from class
class MinStack {
    Stack<Integer> st = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(val<=min){
            st.push(min);
        }
        min = Math.min(val, min);
        st.push(val);
    }
    
    public void pop() {
        int num =st.pop();
        if(num==min){
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
