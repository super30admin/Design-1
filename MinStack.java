import java.util.Stack;

//Time Complexity: O(1)
//Space Complexity:O(n)// we declare new stack
class MinStack {

    //store regular elements
    Stack<Integer> stk;
    //store min elements
    Stack<Integer> minstk;
    int min;
    public MinStack() {

        stk=new Stack<>();
        minstk=new Stack<>();
        min=Integer.MAX_VALUE;
        minstk.push(min);
    }

    public void push(int val) {

        stk.push(val);
        min=Math.min(min,val);
        minstk.push(min);

    }

    public void pop() {
        stk.pop();
        minstk.pop();
        min=minstk.peek();

    }

    public int top() {

        return stk.peek();
    }

    public int getMin() {
        return min;
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