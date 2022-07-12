//Single stack implementation approach
//Asymptotic Time Complexity: O(1)
//Asymptotic Space Complexity: O(n)
class MinStack {
Stack<Integer> st = new Stack();
// Stack<Integer> minSt = new Stack();

int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        st.push(min);
    }

    public void push(int x) {
        if(x<=min){
            st.push(min);// first push the current minimum to maintain a historical tracking of minimums in the stack
            min = x;
        }
        st.push(x); // now push the current incoming element
    }

    public void pop() {

        if(st.pop() == min){
            min = st.pop();
        }
    }

    public int top() {
        // Throwing an exception for empty stack
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}
