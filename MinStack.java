class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public  void push(int val) {
        if (min >= val) {
            st.push(min);
            min =val;
         
         }
         st.push(val);
        }
     public void pop(){
        if(st.pop() == min){
            min = st.pop();
        }
     }
     public int top(){
        return st.peek();
     }
     public int getMin(){
        return min;
     }

}