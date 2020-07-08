import java.util.Stack;

class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    MinStack() {

    }

    void push(int x) {
        stack.push(x);
        if(min.size() == 0){
            min.push(x);
            return;
        }
        if(min.peek() >= x){
            min.push(x);
        }
    }

    void pop() {
        if(stack.size() == 0){
            return;
        }
        int top = stack.pop();
        if(min.peek() == top){
            min.pop();
        }

    }

    int top() {
        if(stack.size() == 0){
            /*Should throw exception*/
            return -1;
        }
        return stack.peek();
    }

    int getMin() {
        if(min.size() == 0){
            /*Should throw exception*/
            return -1;
        }
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */