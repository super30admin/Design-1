class MinStack {
    int min =Integer.MAX_VALUE;
        
        /** initialize your data structure here. */
        Stack<Integer> st = new Stack<Integer>();
        public MinStack() {
            
        }
        
        public void push(int x) {
            if(x<=min){
                
                st.push(min);
                min=x;
    
            }
            st.push(x);
        }
        
        public void pop() {
            int popd =st.pop();
            if(popd==min){
                min=st.pop();
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