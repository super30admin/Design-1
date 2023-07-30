// Time Complexity :O(1)
// Space Complexity :O(n)^2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

//2nd Approach using 2 stacks
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt; //for first approach
    int min;
    public MinStack() {
        this.st = new Stack<Integer>();
        this.minSt = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);

    }

    public void push(int val) {
        this.min = Math.min(min, val); // First approach
        minSt.push(min);
        st.push(val);


    }

    public void pop() {
        if(st.peek() != null){
            st.pop();
            minSt.pop(); //after poping , min will be whatever is at the top of the minstack, done below
            min = minSt.peek();// v imp : you have to re assign again ;
        }

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return  minSt.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//Using just 1 stack
class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
            st.push(min);
            min=val;
        }
        st.push(val);
    }

    public void pop() {
// check if element coming out is current min : below
        if(st.pop()== min){ // if 4 , 4: then again we will be storing 4 ke neeche 4 and assigning old 4 to min
            min = st.pop(); // set your min to prev min
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min; //this works for other as well
    }
}