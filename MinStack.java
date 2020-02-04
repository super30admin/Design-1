// o(1) for all operaions assaigned to perform
// o(n) space
//  passed all test cases in leetcode



// using two stacks approacch, one storing min value of the stack and another regular stack for performing push pop and peek.

class MinStack {

    /** initialize your data structure here. */
    Stack <Integer> main;
    Stack <Integer> secondary;

    public MinStack() {
        main = new Stack<>();
        secondary = new Stack<>();
    }

    public void push(int x) {
        if(!main.isEmpty()){
            int small = secondary.peek();
            if(x<=small){
                secondary.push(x);
            }
            main.push(x);
        }
        else{
            main.push(x);
            secondary.push(x);
        }
    }

    public void pop() {
        if(!main.isEmpty()){
            if(secondary.peek()>=main.peek()){
                secondary.pop();
            }
            main.pop();
        }
    }

    public int top() {
        if(main.isEmpty()){
            return -1;
        }
        else{
            return main.peek();
        }
    }

    public int getMin() {
        if(secondary.isEmpty()){
            return -1;
        }
        else{
            return secondary.peek();
        }
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
