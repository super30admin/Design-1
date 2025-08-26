// Firstly need to craete a stack
// check if it is empty and push the first number and make minimum.
// now, keep a track of minimum number in stack in every step with a PAIR of Current value and minimum.
// whichever number is being pushed should carry its minimum number until that.

// Time Complexity O(1)
//Space Complexity O(N)


class MinStack {

    class pair{
        int x,y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    Stack<pair> st;
    public MinStack() {
        st = new Stack<pair>();
    }
    
    public void push(int val) {
        int min;
        if(st.isEmpty()){
            min= val;
        }
        else{
            min = Math.min(st.peek().y,val);
        }
        st.push(new pair(val,min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        int res = st.peek().x;
        return res;
    }
    
    public int getMin() {
        return st.peek().y;
    }
}
